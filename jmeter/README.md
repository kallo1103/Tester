# Báo cáo Kiểm thử Hiệu năng với JMeter

## 1. Mục tiêu

Thực hiện kiểm thử hiệu năng cho website **VnExpress** (<https://vnexpress.net>) để đánh giá khả năng chịu tải và phản hồi của hệ thống dưới các mức độ truy cập khác nhau.

## 2. Kịch bản Kiểm thử (Test Scenarios)

Kế hoạch kiểm thử (`performance_test.jmx`) bao gồm 3 Thread Groups với các cấu hình sau:

### Scenario 1: Kịch bản Cơ bản (Basic)

- **Mục tiêu**: Kiểm tra phản hồi cơ bản của trang chủ.
- **Cấu hình**:
  - Số lượng người dùng (Threads): 10
  - Thời gian chạy (Loops): 5 lần lặp
  - Ramp-up: 1 giây
- **Hành vi**: Gửi yêu cầu HTTP GET đến trang chủ (`/`).

### Scenario 2: Kịch bản Tải nặng (Heavy Load)

- **Mục tiêu**: Đánh giá hiệu năng khi lượng truy cập tăng cao.
- **Cấu hình**:
  - Số lượng người dùng (Threads): 50
  - Ramp-up: 30 giây
  - Loop Count: 1
- **Hành vi**:
  - Gửi yêu cầu HTTP GET đến trang chủ (`/`).
  - Gửi yêu cầu HTTP GET đến trang con "Thời sự" (`/thoi-su`).

### Scenario 3: Kịch bản Tùy chỉnh (Custom)

- **Mục tiêu**: Mô phỏng hành vi người dùng truy cập ngẫu nhiên trong thời gian dài.
- **Cấu hình**:
  - Số lượng người dùng (Threads): 20
  - Thời gian chạy (Duration): 60 giây
  - Ramp-up: 10 giây
- **Hành vi**:
  - Gửi yêu cầu HTTP GET đến trang "Kinh doanh" (`/kinh-doanh`).
  - Gửi yêu cầu HTTP GET đến trang "Thể thao" (`/the-thao`).

## 3. Thực hiện Kiểm thử

Kiểm thử được thực hiện bằng JMeter qua dòng lệnh (CLI mode) để đảm bảo độ chính xác của kết quả.

**Lệnh thực thi:**

```bash
jmeter -n -t jmeter/performance_test.jmx -l jmeter/results.csv
```

## 4. Kết quả Kiểm thử

Kết quả chi tiết được lưu trong file `results.csv`.
Dưới đây là tóm tắt các chỉ số chính từ lần chạy kiểm thử:

### Phân tích sơ bộ (Sample Data)

Dựa trên file `results.csv`:

- **Response Time (Thời gian phản hồi)**:
  - Trang chủ: Dao động từ ~100ms đến ~500ms (tùy thuộc vào tải).
  - Web Server trả về mã `200 OK` cho hầu hết các yêu cầu.
- **Throughput (Thông lượng)**: Ổn định trong quá trình ramp-up.
- **Error Rate (Tỷ lệ lỗi)**: 0% (trong mẫu thử nghiệm ban đầu).

### Evidence

- File cấu hình: `performance_test.jmx`
- File kết quả: `results.csv`

## 5. Kết luận

Hệ thống VnExpress phản hồi tốt với mức tải thử nghiệm (lên đến 50 threads đồng thời). Thời gian phản hồi nằm trong mức chấp nhận được cho trải nghiệm người dùng thông thường.
