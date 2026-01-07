
Lê Hoài Nam BCS230059


![Kết quả Can't Unsee](Screenshot%202026-01-05%20at%202.31.14%E2%80%AFPM.png)

**Mô tả chi tiết ảnh:**
- **Nội dung:** Màn hình kết quả cuối cùng sau khi hoàn thành thử thách.
- **Điểm số (Score):** 7530
- **Xếp hạng (Rank):** **Platinum** (Top 5% người chơi) - Chứng tỏ khả năng quan sát chi tiết tốt.
- **Thời gian hoàn thành:** 00:10:04


# Bài tập thực hành kiểm thử với JUnit
## Chủ đề: Phân tích dữ liệu điểm số học sinh

### 1. Giới thiệu
Chương trình Java `StudentAnalyzer` cung cấp các chức năng:
- `countExcellentStudents`: Đếm số học sinh giỏi (điểm >= 8.0).
- `calculateValidAverage`: Tính điểm trung bình của các điểm hợp lệ (0-10).

### 2. Cấu trúc thư mục
- `unit-test/src/StudentAnalyzer.java`: Mã nguồn chính.
- `unit-test/test/StudentAnalyzerTest.java`: Mã nguồn kiểm thử (JUnit 5).

### 3. Hướng dẫn chạy kiểm thử
Để chạy các kiểm thử này, bạn cần có thư viện JUnit 5.

Nếu sử dụng IDE (IntelliJ, Eclipse, VS Code):
- Mở thư mục dự án.
- Đảm bảo thư viện JUnit 5 đã được thêm vào classpath.
- Chuột phải vào file `StudentAnalyzerTest.java` và chọn "Run".

### 4. Các Test Case đã thực hiện
- **countExcellentStudents**:
  - Danh sách hỗn hợp (hợp lệ/không hợp lệ).
  - Danh sách toàn điểm giỏi.
  - Danh sách rỗng/null.
- **calculateValidAverage**:
  - Danh sách hỗn hợp.
  - Danh sách toàn điểm hợp lệ.
  - Danh sách rỗng/null (trả về 0).
