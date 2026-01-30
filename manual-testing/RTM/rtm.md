# MA TRẬN TRUY VẾT YÊU CẦU (RTM)

## REQUIREMENT TRACEABILITY MATRIX

---

## Thông tin tài liệu

| Thông tin | Chi tiết |
|-----------|----------|
| **Dự án** | E-commerce Website |
| **Phiên bản** | 1.0 |
| **Ngày tạo** | 30/01/2026 |
| **Người tạo** | QA Team |

---

## Ma trận truy vết

| Req ID | Mô tả yêu cầu | Test Case ID | Số TC | Trạng thái |
|--------|---------------|--------------|-------|------------|
| **R1** | Người dùng đăng ký bằng email hợp lệ | TC_AUTH_001, TC_AUTH_005 | 2 | ✅ Covered |
| **R2** | Không cho đăng ký khi email sai định dạng | TC_AUTH_003, TC_AUTH_002 | 2 | ✅ Covered |
| **R3** | Mật khẩu tối thiểu 8 ký tự | TC_AUTH_004, TC_AUTH_005, TC_AUTH_015 | 3 | ✅ Covered |
| **R4** | Đăng nhập thành công với thông tin hợp lệ | TC_AUTH_006, TC_AUTH_012 | 2 | ✅ Covered |
| **R5** | Đăng nhập thất bại khi sai mật khẩu | TC_AUTH_007, TC_AUTH_008, TC_AUTH_009 | 3 | ✅ Covered |
| **R6** | Quên mật khẩu gửi email đặt lại | TC_AUTH_010, TC_AUTH_011 | 2 | ✅ Covered |
| **R7** | Tìm kiếm hiển thị đúng kết quả | TC_PROD_001, TC_PROD_002, TC_PROD_003 | 3 | ✅ Covered |
| **R8** | Lọc theo giá hoạt động đúng | TC_PROD_004, TC_PROD_005, TC_PROD_009 | 3 | ✅ Covered |
| **R9** | Xem chi tiết sản phẩm | TC_PROD_007, TC_PROD_008 | 2 | ✅ Covered |
| **R10** | Thêm sản phẩm vào giỏ thành công | TC_CART_001, TC_CART_002, TC_CART_003, TC_CART_004 | 4 | ✅ Covered |
| **R11** | Cập nhật số lượng trong giỏ | TC_CART_006, TC_CART_007, TC_CART_012 | 3 | ✅ Covered |
| **R12** | Xoá sản phẩm khỏi giỏ | TC_CART_008, TC_CART_009 | 2 | ✅ Covered |
| **R13** | Thanh toán bắt buộc nhập địa chỉ | TC_CHECKOUT_003, TC_CHECKOUT_006, TC_CHECKOUT_010 | 3 | ✅ Covered |
| **R14** | Chọn phương thức thanh toán | TC_CHECKOUT_001, TC_CHECKOUT_002, TC_CHECKOUT_004, TC_CHECKOUT_009 | 4 | ✅ Covered |
| **R15** | Đặt hàng thành công | TC_CHECKOUT_001, TC_CHECKOUT_002, TC_CHECKOUT_005 | 3 | ✅ Covered |
| **R16** | Lưu lịch sử đơn hàng | TC_CHECKOUT_007, TC_CHECKOUT_008 | 2 | ✅ Covered |

---

## Thống kê độ bao phủ

### Tổng quan

| Chỉ số | Giá trị |
|--------|---------|
| **Tổng số Requirements** | 16 |
| **Requirements được cover** | 16 |
| **Requirements chưa cover** | 0 |
| **Độ bao phủ (Coverage)** | **100%** |

### Chi tiết theo Module

| Module | Requirements | Covered | Coverage |
|--------|--------------|---------|----------|
| Authentication (R1-R6) | 6 | 6 | 100% |
| Product & Cart (R7-R12) | 6 | 6 | 100% |
| Checkout (R13-R16) | 4 | 4 | 100% |
| **Tổng** | **16** | **16** | **100%** |

### Phân bố Test Case theo Requirement

| Số TC/Requirement | Số lượng Req |
|-------------------|--------------|
| 2 Test Cases | 7 |
| 3 Test Cases | 6 |
| 4 Test Cases | 3 |
| **Trung bình** | **2.75 TC/Req** |

---

## Ma trận ngược (Test Case → Requirements)

| Test Case ID | Requirements Covered |
|--------------|---------------------|
| TC_AUTH_001 | R1 |
| TC_AUTH_002 | R2 |
| TC_AUTH_003 | R2 |
| TC_AUTH_004 | R3 |
| TC_AUTH_005 | R1, R3 |
| TC_AUTH_006 | R4 |
| TC_AUTH_007 | R5 |
| TC_AUTH_008 | R5 |
| TC_AUTH_009 | R5 |
| TC_AUTH_010 | R6 |
| TC_AUTH_011 | R6 |
| TC_AUTH_012 | R4 |
| TC_AUTH_013 | - (Security) |
| TC_AUTH_014 | - (Security) |
| TC_AUTH_015 | R3 |
| TC_PROD_001 | R7 |
| TC_PROD_002 | R7 |
| TC_PROD_003 | R7 |
| TC_PROD_004 | R8 |
| TC_PROD_005 | R8 |
| TC_PROD_006 | R8 |
| TC_PROD_007 | R9 |
| TC_PROD_008 | R9 |
| TC_PROD_009 | R8 |
| TC_CART_001 | R10 |
| TC_CART_002 | R10 |
| TC_CART_003 | R10 |
| TC_CART_004 | R10 |
| TC_CART_005 | R10 |
| TC_CART_006 | R11 |
| TC_CART_007 | R11 |
| TC_CART_008 | R12 |
| TC_CART_009 | R12 |
| TC_CART_010 | - (UI/UX) |
| TC_CART_011 | R10 |
| TC_CART_012 | R11 |
| TC_CHECKOUT_001 | R14, R15 |
| TC_CHECKOUT_002 | R14, R15 |
| TC_CHECKOUT_003 | R13 |
| TC_CHECKOUT_004 | R14 |
| TC_CHECKOUT_005 | R15 |
| TC_CHECKOUT_006 | R13 |
| TC_CHECKOUT_007 | R16 |
| TC_CHECKOUT_008 | R16 |
| TC_CHECKOUT_009 | R14 |
| TC_CHECKOUT_010 | R13 |

---

## Ghi chú

- ✅ **Coverage đạt 100%** - Tất cả 16 requirements đều được map với ít nhất 2 test cases
- 📊 Mỗi requirement được cover bởi trung bình **2.75 test cases**
- 🔒 Có 2 test case security (TC_AUTH_013, TC_AUTH_014) không map trực tiếp với requirement nhưng cần thiết cho bảo mật
- 📱 Có 1 test case UI/UX (TC_CART_010) kiểm tra flow chưa đăng nhập
