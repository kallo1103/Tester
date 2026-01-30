# CA KIỂM THỬ - MODULE THANH TOÁN (CHECKOUT)

## Tổng quan: 10 Test Cases

---

## TC_CHECKOUT_001 - Thanh toán thành công với COD

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_001 |
| **Tiêu đề** | Đặt hàng thành công với phương thức COD |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng có sản phẩm |
| **Các bước** | 1. Mở trang giỏ hàng<br>2. Click "Tiến hành thanh toán"<br>3. Nhập địa chỉ giao hàng đầy đủ<br>4. Chọn phương thức: COD<br>5. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Đặt hàng thành công<br>- Hiển thị trang xác nhận với mã đơn hàng<br>- Email xác nhận được gửi<br>- Giỏ hàng được xóa |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CHECKOUT_002 - Thanh toán thành công với Visa

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_002 |
| **Tiêu đề** | Đặt hàng với thẻ Visa giả lập |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng có sản phẩm |
| **Các bước** | 1. Mở trang thanh toán<br>2. Nhập địa chỉ giao hàng<br>3. Chọn phương thức: Visa<br>4. Nhập thông tin thẻ: 4111111111111111<br>5. Nhập CVV: 123, Hạn: 12/28<br>6. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Thanh toán được xử lý<br>- Đơn hàng được tạo thành công<br>- Trạng thái: "Đã thanh toán" |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CHECKOUT_003 - Thanh toán khi không nhập địa chỉ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_003 |
| **Tiêu đề** | Đặt hàng khi để trống địa chỉ giao hàng |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng có sản phẩm |
| **Các bước** | 1. Mở trang thanh toán<br>2. Để trống tất cả trường địa chỉ<br>3. Chọn phương thức: COD<br>4. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Đặt hàng thất bại<br>- Hiển thị lỗi validation cho các trường bắt buộc<br>- "Vui lòng nhập địa chỉ giao hàng" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_CHECKOUT_004 - Thanh toán với thẻ không hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_004 |
| **Tiêu đề** | Thanh toán với số thẻ Visa sai |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng có sản phẩm |
| **Các bước** | 1. Mở trang thanh toán<br>2. Nhập địa chỉ giao hàng<br>3. Chọn phương thức: Visa<br>4. Nhập số thẻ: 1234567890123456<br>5. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Thanh toán thất bại<br>- Thông báo "Thẻ không hợp lệ" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_CHECKOUT_005 - Thanh toán giỏ hàng trống

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_005 |
| **Tiêu đề** | Truy cập trang checkout khi giỏ hàng trống |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng trống |
| **Các bước** | 1. Truy cập trực tiếp URL: /checkout |
| **Kết quả mong đợi** | - Không cho phép checkout<br>- Chuyển hướng về trang giỏ hàng<br>- Thông báo "Giỏ hàng trống" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_CHECKOUT_006 - Nhập số điện thoại không hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_006 |
| **Tiêu đề** | Nhập số điện thoại sai định dạng |
| **Điều kiện trước** | Đang ở trang thanh toán |
| **Các bước** | 1. Nhập địa chỉ giao hàng<br>2. Nhập số điện thoại: abc123<br>3. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Validation error<br>- Thông báo "Số điện thoại không hợp lệ" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Validation |

---

## TC_CHECKOUT_007 - Xem lịch sử đơn hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_007 |
| **Tiêu đề** | Xem danh sách đơn hàng đã đặt |
| **Điều kiện trước** | Đã đăng nhập, có ít nhất 1 đơn hàng |
| **Các bước** | 1. Click vào menu "Đơn hàng của tôi"<br>2. Xem danh sách đơn hàng |
| **Kết quả mong đợi** | - Hiển thị danh sách đơn hàng<br>- Mỗi đơn hàng có: Mã, Ngày, Tổng tiền, Trạng thái |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CHECKOUT_008 - Xem chi tiết đơn hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_008 |
| **Tiêu đề** | Xem chi tiết một đơn hàng cụ thể |
| **Điều kiện trước** | Có đơn hàng #ORD001 |
| **Các bước** | 1. Mở trang lịch sử đơn hàng<br>2. Click vào đơn hàng #ORD001 |
| **Kết quả mong đợi** | - Hiển thị chi tiết đơn hàng:<br>  + Danh sách sản phẩm<br>  + Địa chỉ giao hàng<br>  + Phương thức thanh toán<br>  + Trạng thái đơn hàng |
| **Độ ưu tiên** | Medium |
| **Loại test** | Positive |

---

## TC_CHECKOUT_009 - Thanh toán khi chưa chọn phương thức

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_009 |
| **Tiêu đề** | Đặt hàng mà không chọn phương thức thanh toán |
| **Điều kiện trước** | Đang ở trang thanh toán |
| **Các bước** | 1. Nhập đầy đủ địa chỉ giao hàng<br>2. Không chọn phương thức thanh toán<br>3. Click "Đặt hàng" |
| **Kết quả mong đợi** | - Đặt hàng thất bại<br>- Thông báo "Vui lòng chọn phương thức thanh toán" |
| **Độ ưu tiên** | High |
| **Loại test** | Validation |

---

## TC_CHECKOUT_010 - Số điện thoại ở biên (10 số)

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CHECKOUT_010 |
| **Tiêu đề** | Nhập số điện thoại đúng 10 số |
| **Điều kiện trước** | Đang ở trang thanh toán |
| **Các bước** | 1. Nhập địa chỉ giao hàng<br>2. Nhập số điện thoại: 0901234567 (10 số)<br>3. Hoàn thành các bước và đặt hàng |
| **Kết quả mong đợi** | - Số điện thoại được chấp nhận<br>- Đặt hàng thành công |
| **Độ ưu tiên** | Medium |
| **Loại test** | Boundary |

---

## Tổng kết Module Checkout

| Loại Test | Số lượng |
|-----------|----------|
| Positive | 5 |
| Negative | 3 |
| Validation | 2 |
| Boundary | 1 |
| **Tổng** | **10** |

---

# TỔNG KẾT TẤT CẢ TEST CASES

| Module | Số lượng | Positive | Negative | Boundary | Validation | Security |
|--------|----------|----------|----------|----------|------------|----------|
| Authentication | 15 | 5 | 5 | 2 | 2 | 2 |
| Product & Cart | 20 | 12 | 5 | 3 | 0 | 0 |
| Checkout | 10 | 5 | 3 | 1 | 2 | 0 |
| **Tổng cộng** | **45** | **22** | **13** | **6** | **4** | **2** |

**Đáp ứng yêu cầu:**

- ✅ Tổng số test case: 45 (≥ 45)
- ✅ Negative test case: 13 (≥ 10)
- ✅ Boundary test case: 6 (≥ 5)
- ✅ Validation/Security test case: 6 (≥ 5)
