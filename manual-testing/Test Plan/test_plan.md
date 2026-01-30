# KẾ HOẠCH KIỂM THỬ (TEST PLAN)

## Hệ thống: Website Bán Hàng Online (E-commerce)

| Thông tin | Chi tiết |
|-----------|----------|
| **Phiên bản** | 1.0 |
| **Ngày tạo** | 30/01/2026 |
| **Người tạo** | QA Team |
| **Trạng thái** | Draft |

---

## 1. Giới thiệu (Introduction)

### 1.1 Mục đích

Tài liệu này mô tả kế hoạch kiểm thử cho hệ thống Website Bán Hàng Online (E-commerce). Kế hoạch bao gồm phạm vi, phương pháp, nguồn lực và lịch trình kiểm thử.

### 1.2 Mô tả hệ thống

Hệ thống E-commerce cho phép người dùng:

- Đăng ký, đăng nhập và quản lý tài khoản
- Tìm kiếm, lọc và xem chi tiết sản phẩm
- Quản lý giỏ hàng (thêm, sửa, xóa)
- Thanh toán và theo dõi đơn hàng

### 1.3 Tài liệu tham khảo

- SRS (Software Requirements Specification)
- Wireframes và UI Mockups
- Database Schema

---

## 2. Phạm vi kiểm thử (Scope)

### 2.1 Trong phạm vi (In-scope)

| Module | Chức năng |
|--------|-----------|
| **Authentication** | Đăng ký, Đăng nhập, Quên mật khẩu, Đăng xuất |
| **Product & Cart** | Tìm kiếm, Lọc, Xem chi tiết, Thêm/Sửa/Xóa giỏ hàng |
| **Checkout** | Nhập địa chỉ, Chọn thanh toán, Đặt hàng, Lịch sử đơn |

### 2.2 Ngoài phạm vi (Out-of-scope)

| Loại kiểm thử | Lý do |
|---------------|-------|
| Performance Testing | Không nằm trong giai đoạn này |
| Automation Testing | Thực hiện ở phase sau |
| Security Penetration Testing | Cần đội ngũ chuyên biệt |
| Mobile App Testing | Chỉ test web browser |

---

## 3. Phương pháp kiểm thử (Test Approach)

### 3.1 Các loại kiểm thử

| Loại | Mô tả | Mức độ |
|------|-------|--------|
| **Functional Testing** | Kiểm tra chức năng theo requirements | Chính |
| **UI Testing (Basic)** | Kiểm tra giao diện cơ bản | Phụ |
| **Regression Testing** | Smoke test sau mỗi build | Phụ |
| **Integration Testing** | Kiểm tra tích hợp giữa các module | Phụ |

### 3.2 Kỹ thuật thiết kế Test Case

- **Equivalence Partitioning**: Phân vùng tương đương cho input
- **Boundary Value Analysis**: Phân tích giá trị biên
- **Decision Table**: Bảng quyết định cho logic phức tạp
- **Error Guessing**: Dự đoán lỗi dựa trên kinh nghiệm

### 3.3 Mức độ ưu tiên Test Case

| Priority | Mô tả | Thực thi |
|----------|-------|----------|
| High | Critical business flow | Bắt buộc |
| Medium | Important features | Nên thực hiện |
| Low | Nice-to-have | Nếu có thời gian |

---

## 4. Môi trường kiểm thử (Test Environment)

### 4.1 Phần cứng

| Thiết bị | Cấu hình |
|----------|----------|
| PC/Laptop | CPU i5+, RAM 8GB+, SSD 256GB+ |
| Màn hình | Độ phân giải 1920x1080 |

### 4.2 Phần mềm

| Loại | Chi tiết |
|------|----------|
| **Hệ điều hành** | Windows 10/11 |
| **Trình duyệt** | Google Chrome (phiên bản mới nhất) |
| **Công cụ** | Excel/Google Sheet, Jira (nếu có) |

### 4.3 Dữ liệu kiểm thử

| Loại | Mô tả |
|------|-------|
| **Tài khoản test** | <user_test@example.com> / Test@1234 |
| **Sản phẩm test** | 10 sản phẩm mẫu các danh mục |
| **Thanh toán test** | COD, Visa giả lập: 4111111111111111 |

---

## 5. Điều kiện vào / ra (Entry / Exit Criteria)

### 5.1 Điều kiện vào (Entry Criteria)

- [ ] Code đã được deploy lên môi trường test
- [ ] Test environment đã sẵn sàng và ổn định
- [ ] Test data đã được chuẩn bị
- [ ] Test cases đã được review và approve
- [ ] Smoke test passed

### 5.2 Điều kiện ra (Exit Criteria)

- [ ] 100% test cases được thực thi
- [ ] Pass rate ≥ 95%
- [ ] 0 bug Critical còn open
- [ ] Tất cả bug Major đã được fix hoặc có workaround
- [ ] Test report đã được hoàn thành

---

## 6. Rủi ro & Biện pháp giảm thiểu (Risks & Mitigation)

| ID | Rủi ro | Xác suất | Tác động | Biện pháp giảm thiểu |
|----|--------|----------|----------|---------------------|
| R1 | Thiếu thời gian kiểm thử | Cao | Cao | Ưu tiên test các chức năng critical trước |
| R2 | Môi trường test không ổn định | Trung bình | Cao | Có backup environment, liên hệ DevOps sớm |
| R3 | Requirements thay đổi | Trung bình | Trung bình | Cập nhật test cases kịp thời, communication tốt |
| R4 | Thiếu dữ liệu test | Thấp | Trung bình | Chuẩn bị data trước, có script tạo data |
| R5 | Thành viên nghỉ đột xuất | Thấp | Cao | Cross-training, documentation đầy đủ |

---

## 7. Vai trò & Trách nhiệm (Roles & Responsibilities)

| Vai trò | Người đảm nhận | Trách nhiệm |
|---------|----------------|-------------|
| **Test Lead** | [Tên] | Lập kế hoạch, phân công, báo cáo |
| **QA Tester 1** | [Tên] | Test module Authentication |
| **QA Tester 2** | [Tên] | Test module Product & Cart |
| **QA Tester 3** | [Tên] | Test module Checkout |
| **Developer** | [Tên] | Fix bug, support debug |
| **PM** | [Tên] | Review, approve, quyết định release |

---

## 8. Lịch trình kiểm thử (Test Schedule)

| Giai đoạn | Ngày bắt đầu | Ngày kết thúc | Deliverable |
|-----------|--------------|---------------|-------------|
| **Test Planning** | 30/01/2026 | 31/01/2026 | Test Plan, RTM |
| **Test Case Design** | 01/02/2026 | 03/02/2026 | Test Cases |
| **Test Environment Setup** | 03/02/2026 | 04/02/2026 | Environment ready |
| **Test Execution - Round 1** | 05/02/2026 | 08/02/2026 | Test results, Bug reports |
| **Bug Fix** | 09/02/2026 | 11/02/2026 | Fixed bugs |
| **Test Execution - Round 2** | 12/02/2026 | 13/02/2026 | Regression results |
| **Test Closure** | 14/02/2026 | 14/02/2026 | Test Report, Metrics |

---

## 9. Phê duyệt (Approval)

| Vai trò | Họ tên | Chữ ký | Ngày |
|---------|--------|--------|------|
| Test Lead | | | |
| Project Manager | | | |
| Product Owner | | | |

---

**Lịch sử thay đổi:**

| Phiên bản | Ngày | Người sửa | Mô tả thay đổi |
|-----------|------|-----------|----------------|
| 1.0 | 30/01/2026 | QA Team | Phiên bản đầu tiên |
