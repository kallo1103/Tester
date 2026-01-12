# KIỂM THỬ PHẦN MỀM

**Họ và tên:** Lê Hoài Nam
**Mã sinh viên:** BCS230059

---

## 📑 Mục lục

1. [Chương 1: Thử thách thiết kế UI/UX (Can't Unsee)](#chương-1-thử-thách-thiết-kế-uiux-cant-unsee)
2. [Chương 2: Kiểm thử đơn vị với JUnit (Student Analyzer)](#chương-2-kiểm-thử-đơn-vị-với-junit-student-analyzer)
3. [Chương 3: Kiểm thử tự động End-to-End với Cypress](#chương-3-kiểm-thử-tự-động-end-to-end-với-cypress)

---

## Chương 1: Thử thách thiết kế UI/UX (Can't Unsee)

### 1.1 Tổng quan

Phần này ghi lại kết quả thực hành đánh giá giao diện người dùng thông qua trò chơi "Can't Unsee". Mục tiêu là rèn luyện mắt quan sát các lỗi thiết kế nhỏ và sự không nhất quán trong UI.

### 1.2 Kết quả đạt được

![Kết quả Can't Unsee](Screenshot%202026-01-05%20at%202.31.14%E2%80%AFPM.png)

| Chỉ số | Chi tiết | Đánh giá |
| :--- | :--- | :--- |
| **Điểm số** | **7530** | Rất cao |
| **Xếp hạng** | **Platinum** | Top 5% người chơi |
| **Thời gian** | 00:10:04 | Tốc độ xử lý nhanh |

**Nhận xét:** Kết quả mức Platinum chứng tỏ khả năng nhận diện các chi tiết thiết kế UI tinh tế là rất tốt.

---

## Chương 2: Kiểm thử đơn vị với JUnit (Student Analyzer)

### 2.1 Giới thiệu bài toán

Xây dựng và kiểm thử module `StudentAnalyzer` để xử lý dữ liệu điểm số học sinh. Hệ thống cần đảm bảo tính đúng đắn khi xử lý các dữ liệu đầu vào khác nhau, bao gồm cả dữ liệu lỗi.

**Chức năng chính:**

1. **`countExcellentStudents(List<Double> scores)`**: Đếm số lượng học sinh đạt loại Giỏi (điểm từ 8.0 trở lên).
2. **`calculateValidAverage(List<Double> scores)`**: Tính điểm trung bình cộng, tự động loại bỏ các điểm số không hợp lệ (điểm âm hoặc > 10).

### 2.2 Cấu trúc dự án

```text
Tester/
├── unit-test/
│   ├── src/
│   │   └── StudentAnalyzer.java      # Mã nguồn logic xử lý
│   └── test/
│       └── StudentAnalyzerTest.java  # Kịch bản kiểm thử (JUnit 5)
```

### 2.3 Chiến lược kiểm thử (Test Strategy)

Các kịch bản kiểm thử (Test Cases) được thiết kế bao phủ các trường hợp:

**A. Phương thức `countExcellentStudents`**

* ✅ **Normal Case:** Danh sách chứa điểm giỏi, khá, trung bình.
* ✅ **Boundary Case:** Điểm ngay tại ngưỡng 8.0, 7.9, 10.0, 0.0.
* ✅ **Review Error/Invalid:** Điểm âm, điểm > 10, danh sách chứa `null`.
* ✅ **Empty/Null:** Danh sách rỗng hoặc đối tượng list là null.

**B. Phương thức `calculateValidAverage`**

* ✅ **Calculation:** Tính toán chính xác trung bình cộng các số hợp lệ.
* ✅ **Filter Logic:** Bỏ qua điểm sai, chỉ tính điểm đúng.
* ✅ **Edge Case:** Danh sách chỉ toàn điểm sai (trả về 0.0).

### 2.4 Hướng dẫn chạy kiểm thử

**Yêu cầu:** JDK 8+ và thư viện JUnit 5.

**Các bước thực hiện:**

1. Mở dự án bằng IDE (IntelliJ IDEA, Eclipse, hoặc VS Code).
2. Đảm bảo thư viện **JUnit 5.8.1** (hoặc mới hơn) đã được thêm vào classpath.
3. Mở file `unit-test/test/StudentAnalyzerTest.java`.
4. Nhấp chuột phải và chọn **Run 'StudentAnalyzerTest'**.
5. Kiểm tra kết quả trên thanh trạng thái (Green Bar = All Passed).

---

## Chương 3: Kiểm thử tự động End-to-End với Cypress

### 3.1 Giới thiệu

Thực hành kiểm thử tự động End-to-End (E2E) cho trang web **SauceDemo** (<https://www.saucedemo.com>) sử dụng **Cypress**. Dự án bao gồm các kịch bản kiểm thử cho chức năng Đăng nhập, Giỏ hàng và Thanh toán.

### 3.2 Cài đặt và Môi trường

* **Thư mục dự án:** `cypress-exercise/`
* **Công cụ:** Node.js, Cypress 15+

**Cài đặt:**

```bash
cd cypress-exercise
npm install
```

### 3.3 Danh sách kịch bản kiểm thử (Test Scenarios)

Dự án bao gồm 3 tệp kiểm thử chính trong thư mục `cypress/e2e/`:

1. **`login_spec.cy.js` (Chức năng Đăng nhập):**
    * ✅ Kiểm tra hiển thị giao diện đăng nhập.
    * ✅ Đăng nhập thành công với tài khoản chuẩn.
    * ✅ Báo lỗi khi sai tên đăng nhập hoặc mật khẩu.
    * ✅ Kiểm tra tài khoản bị khóa (`locked_out_user`).
    * ✅ Kiểm tra chức năng Đăng xuất.

2. **`cart_spec.cy.js` (Quản lý Giỏ hàng):**
    * ✅ Sắp xếp sản phẩm theo Giá (Thấp -> Cao).
    * ✅ Sắp xếp sản phẩm theo Tên (Z -> A).
    * ✅ Thêm sản phẩm và kiểm tra trạng thái nút (Add -> Remove).
    * ✅ Xóa sản phẩm từ trang danh sách (Inventory).
    * ✅ Xóa sản phẩm từ trang Giỏ hàng (Cart).

3. **`checkout_spec.cy.js` (Quy trình Thanh toán):**
    * ✅ Quy trình thanh toán trọn vẹn (Thêm -> Giỏ hàng -> Checkout -> Finish).
    * ✅ Kiểm tra tính toán tổng tiền (Subtotal).
    * ✅ Kiểm tra xác thực form thông tin (Validate required fields).

### 3.4 Kết quả chạy kiểm thử (Test Execution Results)

Đã thực hiện chạy toàn bộ 13 test cases. Kết quả: **100% PASSED**.

```text
       Spec                                              Tests  Passing  Failing
  ┌─────────────────────────────────────────────────────────────────────────────┐
  │ ✔  cart_spec.cy.js                          00:07        5        5        0│
  ├─────────────────────────────────────────────────────────────────────────────┤
  │ ✔  checkout_spec.cy.js                      00:04        2        2        0│
  ├─────────────────────────────────────────────────────────────────────────────┤
  │ ✔  login_spec.cy.js                         00:06        6        6        0│
  └─────────────────────────────────────────────────────────────────────────────┘
    ✔  All specs passed!                        00:19       13       13        0
```

### 3.5 Hướng dẫn chạy

Để chạy kiểm thử, mở terminal tại thư mục `cypress-exercise`:

* **Chạy ngầm (Headless mode):**

    ```bash
    npx cypress run
    ```

* **Chạy giao diện (Interactive mode):**

    ```bash
    npx cypress open
    ```
