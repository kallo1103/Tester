# BÁO CÁO KIỂM THỬ (TEST REPORT)

## Hệ thống: E-commerce Website

---

## Thông tin tài liệu

| Thông tin | Chi tiết |
|-----------|----------|
| **Dự án** | E-commerce Website |
| **Phiên bản** | 1.0 |
| **Ngày báo cáo** | 30/01/2026 |
| **Giai đoạn** | Test Execution Round 1 |
| **Người báo cáo** | QA Team Lead |

---

## 1. Tóm tắt điều hành (Executive Summary)

Báo cáo này tổng hợp kết quả kiểm thử chức năng cho hệ thống E-commerce Website phiên bản 1.0. Kiểm thử được thực hiện trên 3 module chính: Authentication, Product & Cart, và Checkout.

### Kết quả tổng quan

| Chỉ số | Giá trị |
|--------|---------|
| **Tổng số Test Cases** | 45 |
| **Passed** | 35 |
| **Failed** | 8 |
| **Blocked** | 2 |
| **Pass Rate** | 77.8% |
| **Execution Rate** | 100% |

### 🔴 Quyết định Release: **NO-RELEASE**

> **Lý do**: Còn 2 bug Critical chưa được fix (BUG_AUTH_001, BUG_CHECKOUT_001). Hệ thống chưa đủ điều kiện để release lên production.

---

## 2. Phạm vi kiểm thử

### 2.1 Modules được kiểm thử

| Module | Test Cases | Passed | Failed | Blocked |
|--------|------------|--------|--------|---------|
| Authentication | 15 | 12 | 2 | 1 |
| Product & Cart | 20 | 16 | 3 | 1 |
| Checkout | 10 | 7 | 3 | 0 |
| **Tổng** | **45** | **35** | **8** | **2** |

### 2.2 Loại kiểm thử

| Loại | Thực hiện | Ghi chú |
|------|-----------|---------|
| Functional Testing | ✅ | Đầy đủ 45 TCs |
| UI Testing (Basic) | ✅ | 5 TCs |
| Security Testing (Basic) | ✅ | 2 TCs (XSS, SQL Injection) |
| Regression Testing | ⏳ | Chờ fix bug |

---

## 3. Kết quả chi tiết theo Module

### 3.1 Module Authentication (15 TCs)

| Kết quả | Số lượng | Tỷ lệ |
|---------|----------|-------|
| ✅ Passed | 12 | 80% |
| ❌ Failed | 2 | 13.3% |
| 🔒 Blocked | 1 | 6.7% |

**Test Cases Failed:**

- TC_AUTH_007: Đăng nhập với mật khẩu sai → Thông báo lỗi không rõ ràng
- TC_AUTH_013: SQL Injection → Cần investigate thêm

**Test Cases Blocked:**

- TC_AUTH_010: Quên mật khẩu → Email server chưa cấu hình

### 3.2 Module Product & Cart (20 TCs)

| Kết quả | Số lượng | Tỷ lệ |
|---------|----------|-------|
| ✅ Passed | 16 | 80% |
| ❌ Failed | 3 | 15% |
| 🔒 Blocked | 1 | 5% |

**Test Cases Failed:**

- TC_CART_004: Thêm số lượng vượt stock → Không validate đúng
- TC_CART_005: Số lượng âm → Chấp nhận giá trị âm
- TC_CART_006: Cập nhật số lượng → Tổng tiền tính sai

**Test Cases Blocked:**

- TC_PROD_006: Lọc theo danh mục → Data chưa đủ

### 3.3 Module Checkout (10 TCs)

| Kết quả | Số lượng | Tỷ lệ |
|---------|----------|-------|
| ✅ Passed | 7 | 70% |
| ❌ Failed | 3 | 30% |
| 🔒 Blocked | 0 | 0% |

**Test Cases Failed:**

- TC_CHECKOUT_001: Thanh toán COD → Email không gửi
- TC_CHECKOUT_002: Thanh toán Visa → Chấp nhận thẻ hết hạn
- TC_CHECKOUT_004: Thẻ không hợp lệ → Không validate đúng

---

## 4. Top 5 Bug Nghiêm Trọng Nhất

| Rank | Bug ID | Tóm tắt | Severity | Module |
|------|--------|---------|----------|--------|
| 1 | BUG_AUTH_001 | Đăng nhập được với tài khoản bị khóa | 🔴 Critical | Auth |
| 2 | BUG_CHECKOUT_001 | Thanh toán với thẻ hết hạn thành công | 🔴 Critical | Checkout |
| 3 | BUG_CART_001 | Tổng tiền tính sai khi có khuyến mãi | 🟠 Major | Cart |
| 4 | BUG_CART_002 | Chấp nhận số lượng âm trong giỏ | 🟠 Major | Cart |
| 5 | BUG_CART_003 | Không kiểm tra stock realtime | 🟠 Major | Cart |

---

## 5. Phân tích Bug

### 5.1 Phân bố theo Severity

| Severity | Số lượng | Tỷ lệ | Trạng thái |
|----------|----------|-------|------------|
| 🔴 Critical | 2 | 20% | ⚠️ Open |
| 🟠 Major | 4 | 40% | ⚠️ Open |
| 🟡 Minor | 4 | 40% | Open |
| **Tổng** | **10** | **100%** | |

### 5.2 Phân bố theo Module

```
Authentication:  ██░░░░░░░░ 20% (2 bugs)
Product:         ██░░░░░░░░ 20% (2 bugs)
Cart:            ███░░░░░░░ 30% (3 bugs)
Checkout:        ██░░░░░░░░ 20% (2 bugs)
UI:              █░░░░░░░░░ 10% (1 bug)
```

---

## 6. Nhận xét chất lượng hệ thống

### 6.1 Điểm mạnh

- ✅ Chức năng cơ bản của tìm kiếm và xem sản phẩm hoạt động tốt
- ✅ UI/UX trên desktop ổn định
- ✅ Flow đăng ký tài khoản mới hoạt động đúng

### 6.2 Điểm yếu

- ❌ **Bảo mật**: Có lỗ hổng nghiêm trọng trong xác thực và thanh toán
- ❌ **Validation**: Input validation ở server-side yếu
- ❌ **Email**: Hệ thống gửi email không hoạt động
- ❌ **Cart Logic**: Nhiều bug liên quan đến tính toán giỏ hàng

### 6.3 Rủi ro nếu release

| Rủi ro | Mức độ | Hậu quả |
|--------|--------|---------|
| Tài khoản bị khóa vẫn đăng nhập được | Cao | Bảo mật bị xâm phạm |
| Thanh toán thẻ hết hạn | Cao | Mất tiền, tranh chấp |
| Tính sai tiền giỏ hàng | Trung bình | Khiếu nại khách hàng |

---

## 7. Đề xuất

### 7.1 Yêu cầu bắt buộc trước khi release

1. **Fix BUG_AUTH_001** - Không cho phép đăng nhập với tài khoản bị khóa
2. **Fix BUG_CHECKOUT_001** - Validate thẻ hết hạn
3. **Fix BUG_CART_001, BUG_CART_002** - Sửa logic tính tiền và validate số lượng
4. **Regression test** sau khi fix

### 7.2 Đề xuất cải tiến

- Tăng cường server-side validation
- Implement logging và monitoring
- Thêm unit test cho business logic quan trọng

### 7.3 Timeline đề xuất

| Hoạt động | Thời gian |
|-----------|-----------|
| Fix Critical bugs | 2 ngày |
| Fix Major bugs | 2 ngày |
| Regression testing | 1 ngày |
| Sign-off | 1 ngày |
| **Tổng** | **6 ngày** |

---

## 8. Kết luận

### Quyết định: 🔴 **NO-RELEASE**

Hệ thống **KHÔNG ĐỦ ĐIỀU KIỆN** để release lên production vì:

1. ❌ Còn **2 bug Critical** chưa được fix
2. ❌ Pass rate chỉ đạt **77.8%** (yêu cầu ≥ 95%)
3. ❌ Có lỗ hổng **bảo mật nghiêm trọng** trong Authentication và Payment

### Điều kiện để release

- [ ] 0 bug Critical open
- [ ] Tất cả bug Major đã fix hoặc có workaround được approve
- [ ] Pass rate ≥ 95%
- [ ] Regression test passed

---

## Phê duyệt

| Vai trò | Họ tên | Chữ ký | Ngày |
|---------|--------|--------|------|
| QA Lead | | | |
| Dev Lead | | | |
| PM | | | |
