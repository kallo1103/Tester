# BÁO CÁO LỖI (BUG REPORTS)

## Hệ thống: E-commerce Website

---

## Thông tin tài liệu

| Thông tin | Chi tiết |
|-----------|----------|
| **Dự án** | E-commerce Website |
| **Phiên bản test** | 1.0 |
| **Ngày báo cáo** | 30/01/2026 |
| **Tester** | QA Team |
| **Môi trường** | Chrome 120, Windows 11 |

---

## BUG_AUTH_001 - Đăng nhập thành công với tài khoản đã bị khóa [CRITICAL]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_AUTH_001 |
| **Tóm tắt** | Hệ thống cho phép đăng nhập với tài khoản đã bị khóa (status=blocked) |
| **Module** | Authentication |
| **Các bước tái hiện** | 1. Admin khóa tài khoản <user@example.com><br>2. Mở trang đăng nhập<br>3. Nhập email: <user@example.com><br>4. Nhập mật khẩu: Test@1234<br>5. Click "Đăng nhập" |
| **Kết quả mong đợi** | Đăng nhập thất bại, thông báo "Tài khoản đã bị khóa" |
| **Kết quả thực tế** | Đăng nhập thành công, vào được trang chủ |
| **Severity** | 🔴 **Critical** |
| **Priority** | High |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | Nghiêm trọng - Ảnh hưởng đến bảo mật hệ thống |
| **Test Case liên quan** | TC_AUTH_007 |

---

## BUG_CHECKOUT_001 - Thanh toán thành công khi thẻ hết hạn [CRITICAL]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_CHECKOUT_001 |
| **Tóm tắt** | Hệ thống chấp nhận thanh toán với thẻ Visa đã hết hạn |
| **Module** | Checkout |
| **Các bước tái hiện** | 1. Thêm sản phẩm vào giỏ hàng<br>2. Tiến hành thanh toán<br>3. Nhập địa chỉ giao hàng<br>4. Chọn thanh toán Visa<br>5. Nhập số thẻ: 4111111111111111<br>6. Nhập hạn thẻ: 01/2020 (đã hết hạn)<br>7. Click "Đặt hàng" |
| **Kết quả mong đợi** | Thanh toán thất bại, thông báo "Thẻ đã hết hạn" |
| **Kết quả thực tế** | Thanh toán thành công, đơn hàng được tạo |
| **Severity** | 🔴 **Critical** |
| **Priority** | High |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | Nghiêm trọng - Vấn đề tài chính |
| **Test Case liên quan** | TC_CHECKOUT_002, TC_CHECKOUT_004 |

---

## BUG_CART_001 - Tổng tiền giỏ hàng tính sai khi có khuyến mãi [MAJOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_CART_001 |
| **Tóm tắt** | Tổng tiền giỏ hàng không áp dụng đúng giảm giá 20% |
| **Module** | Cart |
| **Các bước tái hiện** | 1. Thêm sản phẩm A giá 200.000đ vào giỏ<br>2. Áp dụng mã giảm giá "SALE20" (giảm 20%)<br>3. Xem tổng tiền |
| **Kết quả mong đợi** | Tổng tiền = 200.000 - 20% = 160.000đ |
| **Kết quả thực tế** | Tổng tiền = 180.000đ (chỉ giảm 10%) |
| **Severity** | 🟠 **Major** |
| **Priority** | High |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | Khách hàng bị tính phí sai |
| **Test Case liên quan** | TC_CART_006 |

---

## BUG_CART_002 - Số lượng âm được chấp nhận trong giỏ hàng [MAJOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_CART_002 |
| **Tóm tắt** | Có thể nhập số lượng âm bằng cách edit HTML |
| **Module** | Cart |
| **Các bước tái hiện** | 1. Thêm sản phẩm vào giỏ<br>2. Mở DevTools (F12)<br>3. Sửa value của input số lượng thành -5<br>4. Submit form update giỏ hàng |
| **Kết quả mong đợi** | Server từ chối, validation error |
| **Kết quả thực tế** | Số lượng -5 được chấp nhận, tổng tiền âm |
| **Severity** | 🟠 **Major** |
| **Priority** | High |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | Lỗ hổng bảo mật, có thể bị lợi dụng |
| **Test Case liên quan** | TC_CART_005 |

---

## BUG_CART_003 - Không cập nhật stock realtime khi người khác mua [MAJOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_CART_003 |
| **Tóm tắt** | Giỏ hàng không kiểm tra lại stock khi checkout |
| **Module** | Cart / Checkout |
| **Các bước tái hiện** | 1. User A thêm SP (stock=1) vào giỏ<br>2. User B cũng thêm SP đó vào giỏ<br>3. User A checkout thành công<br>4. User B checkout (stock đã = 0) |
| **Kết quả mong đợi** | User B nhận thông báo "Sản phẩm đã hết hàng" |
| **Kết quả thực tế** | User B vẫn checkout thành công |
| **Severity** | 🟠 **Major** |
| **Priority** | Medium |
| **Môi trường** | Chrome 120, Windows 11 (2 sessions) |
| **Ảnh hưởng** | Bán quá số lượng tồn kho |
| **Test Case liên quan** | TC_CART_004 |

---

## BUG_CHECKOUT_002 - Email xác nhận đơn hàng không được gửi [MAJOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_CHECKOUT_002 |
| **Tóm tắt** | Không nhận được email xác nhận sau khi đặt hàng |
| **Module** | Checkout |
| **Các bước tái hiện** | 1. Đặt hàng thành công với COD<br>2. Chờ email xác nhận (5-10 phút)<br>3. Kiểm tra inbox và spam folder |
| **Kết quả mong đợi** | Nhận email xác nhận đơn hàng trong vòng 1 phút |
| **Kết quả thực tế** | Không nhận được email (đã chờ 30 phút) |
| **Severity** | 🟠 **Major** |
| **Priority** | Medium |
| **Môi trường** | Chrome 120, Gmail |
| **Ảnh hưởng** | Khách hàng không có thông tin xác nhận |
| **Test Case liên quan** | TC_CHECKOUT_001 |

---

## BUG_PROD_001 - Hình ảnh sản phẩm không hiển thị trên mobile [MINOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_PROD_001 |
| **Tóm tắt** | Thumbnail sản phẩm bị vỡ layout trên màn hình nhỏ |
| **Module** | Product |
| **Các bước tái hiện** | 1. Mở trang danh sách sản phẩm trên mobile<br>2. Hoặc resize browser về 375px width |
| **Kết quả mong đợi** | Hình ảnh sản phẩm hiển thị đúng responsive |
| **Kết quả thực tế** | Hình ảnh bị cắt, không hiển thị đầy đủ |
| **Severity** | 🟡 **Minor** |
| **Priority** | Low |
| **Môi trường** | Chrome Mobile Emulator (iPhone 12) |
| **Ảnh hưởng** | Trải nghiệm người dùng trên mobile |
| **Test Case liên quan** | TC_PROD_007 |

---

## BUG_PROD_002 - Lọc giá không reset khi chuyển danh mục [MINOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_PROD_002 |
| **Tóm tắt** | Filter giá vẫn giữ nguyên khi click sang danh mục khác |
| **Module** | Product |
| **Các bước tái hiện** | 1. Mở danh mục "Điện thoại"<br>2. Lọc giá: 5.000.000 - 10.000.000đ<br>3. Click sang danh mục "Phụ kiện" |
| **Kết quả mong đợi** | Filter được reset, hiển thị tất cả phụ kiện |
| **Kết quả thực tế** | Filter giá vẫn còn, không có sản phẩm nào |
| **Severity** | 🟡 **Minor** |
| **Priority** | Low |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | UX không tốt, gây nhầm lẫn |
| **Test Case liên quan** | TC_PROD_006, TC_PROD_005 |

---

## BUG_AUTH_002 - Thông báo lỗi không rõ ràng khi đăng nhập sai [MINOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_AUTH_002 |
| **Tóm tắt** | Thông báo lỗi quá chung chung "Đã có lỗi xảy ra" |
| **Module** | Authentication |
| **Các bước tái hiện** | 1. Nhập email đúng<br>2. Nhập mật khẩu sai<br>3. Click đăng nhập |
| **Kết quả mong đợi** | Thông báo "Email hoặc mật khẩu không đúng" |
| **Kết quả thực tế** | Thông báo "Đã có lỗi xảy ra" |
| **Severity** | 🟡 **Minor** |
| **Priority** | Low |
| **Môi trường** | Chrome 120, Windows 11 |
| **Ảnh hưởng** | UX kém, người dùng không biết sai ở đâu |
| **Test Case liên quan** | TC_AUTH_007 |

---

## BUG_UI_001 - Button "Thêm giỏ hàng" bị che bởi chat widget [MINOR]

| Trường | Nội dung |
|--------|----------|
| **Bug ID** | BUG_UI_001 |
| **Tóm tắt** | Chat widget đè lên nút "Thêm vào giỏ" trên mobile |
| **Module** | UI |
| **Các bước tái hiện** | 1. Mở trang chi tiết sản phẩm trên mobile<br>2. Scroll xuống dưới<br>3. Quan sát vị trí nút "Thêm vào giỏ" |
| **Kết quả mong đợi** | Nút hiển thị đầy đủ, có thể click |
| **Kết quả thực tế** | Nút bị chat widget che 1 phần, khó click |
| **Severity** | 🟡 **Minor** |
| **Priority** | Low |
| **Môi trường** | Chrome Mobile (375px width) |
| **Ảnh hưởng** | Khó thao tác trên mobile |
| **Test Case liên quan** | TC_CART_001 |

---

## Tổng kết Bug Reports

### Phân bố theo Severity

| Severity | Số lượng | Tỷ lệ |
|----------|----------|-------|
| 🔴 Critical | 2 | 20% |
| 🟠 Major | 4 | 40% |
| 🟡 Minor | 4 | 40% |
| **Tổng** | **10** | **100%** |

### Phân bố theo Module

| Module | Critical | Major | Minor | Tổng |
|--------|----------|-------|-------|------|
| Authentication | 1 | 0 | 1 | 2 |
| Product | 0 | 0 | 2 | 2 |
| Cart | 0 | 3 | 0 | 3 |
| Checkout | 1 | 1 | 0 | 2 |
| UI | 0 | 0 | 1 | 1 |
| **Tổng** | **2** | **4** | **4** | **10** |

### Phân bố theo Priority

| Priority | Số lượng |
|----------|----------|
| High | 4 |
| Medium | 2 |
| Low | 4 |

---

## Ghi chú

- ⚠️ **2 bug Critical** cần được fix trước khi release
- 🔧 Các bug Major nên được fix trong sprint hiện tại
- 📝 Bug Minor có thể được lên kế hoạch cho sprint sau
