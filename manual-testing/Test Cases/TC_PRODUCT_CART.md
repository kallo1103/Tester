# CA KIỂM THỬ - MODULE SẢN PHẨM & GIỎ HÀNG (PRODUCT & CART)

## Tổng quan: 20 Test Cases

---

## TC_PROD_001 - Tìm kiếm sản phẩm với từ khóa hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_001 |
| **Tiêu đề** | Tìm kiếm sản phẩm bằng tên sản phẩm |
| **Điều kiện trước** | Hệ thống có sản phẩm "Áo thun nam" |
| **Các bước** | 1. Mở trang chủ<br>2. Nhập "Áo thun" vào ô tìm kiếm<br>3. Click nút tìm kiếm hoặc nhấn Enter |
| **Kết quả mong đợi** | - Hiển thị danh sách sản phẩm có chứa "Áo thun"<br>- Hiển thị số lượng kết quả |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_PROD_002 - Tìm kiếm sản phẩm không tồn tại

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_002 |
| **Tiêu đề** | Tìm kiếm với từ khóa không có kết quả |
| **Điều kiện trước** | Hệ thống không có sản phẩm "xyz123abc" |
| **Các bước** | 1. Mở trang chủ<br>2. Nhập "xyz123abc" vào ô tìm kiếm<br>3. Click nút tìm kiếm |
| **Kết quả mong đợi** | - Hiển thị thông báo "Không tìm thấy sản phẩm"<br>- Gợi ý tìm kiếm khác |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_PROD_003 - Tìm kiếm với ô tìm kiếm trống

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_003 |
| **Tiêu đề** | Tìm kiếm khi không nhập từ khóa |
| **Điều kiện trước** | Trang chủ đã mở |
| **Các bước** | 1. Mở trang chủ<br>2. Để trống ô tìm kiếm<br>3. Click nút tìm kiếm |
| **Kết quả mong đợi** | - Hiển thị thông báo "Vui lòng nhập từ khóa tìm kiếm"<br>- Hoặc hiển thị tất cả sản phẩm |
| **Độ ưu tiên** | Low |
| **Loại test** | Boundary |

---

## TC_PROD_004 - Lọc sản phẩm theo giá (thấp đến cao)

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_004 |
| **Tiêu đề** | Lọc danh sách sản phẩm theo giá tăng dần |
| **Điều kiện trước** | Đang ở trang danh sách sản phẩm |
| **Các bước** | 1. Mở trang danh sách sản phẩm<br>2. Click dropdown "Sắp xếp"<br>3. Chọn "Giá: Thấp đến cao" |
| **Kết quả mong đợi** | - Sản phẩm được sắp xếp theo giá tăng dần<br>- Sản phẩm giá thấp nhất hiển thị đầu tiên |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_PROD_005 - Lọc sản phẩm theo khoảng giá

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_005 |
| **Tiêu đề** | Lọc sản phẩm trong khoảng giá 100k - 500k |
| **Điều kiện trước** | Đang ở trang danh sách sản phẩm |
| **Các bước** | 1. Mở trang danh sách sản phẩm<br>2. Nhập giá từ: 100000<br>3. Nhập giá đến: 500000<br>4. Click "Áp dụng" |
| **Kết quả mong đợi** | - Chỉ hiển thị sản phẩm có giá từ 100.000đ đến 500.000đ<br>- Hiển thị số lượng kết quả |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_PROD_006 - Lọc theo danh mục sản phẩm

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_006 |
| **Tiêu đề** | Lọc sản phẩm theo danh mục "Điện thoại" |
| **Điều kiện trước** | Danh mục "Điện thoại" có sản phẩm |
| **Các bước** | 1. Mở trang danh sách sản phẩm<br>2. Click vào danh mục "Điện thoại" ở sidebar |
| **Kết quả mong đợi** | - Chỉ hiển thị sản phẩm thuộc danh mục "Điện thoại"<br>- Breadcrumb hiển thị đúng danh mục |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_PROD_007 - Xem chi tiết sản phẩm

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_007 |
| **Tiêu đề** | Xem thông tin chi tiết sản phẩm |
| **Điều kiện trước** | Sản phẩm "iPhone 15" tồn tại |
| **Các bước** | 1. Mở trang danh sách sản phẩm<br>2. Click vào sản phẩm "iPhone 15" |
| **Kết quả mong đợi** | - Hiển thị trang chi tiết với:<br>  + Tên sản phẩm<br>  + Giá<br>  + Mô tả<br>  + Hình ảnh<br>  + Còn hàng/Hết hàng |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_PROD_008 - Xem sản phẩm không tồn tại (URL trực tiếp)

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_008 |
| **Tiêu đề** | Truy cập URL sản phẩm không tồn tại |
| **Điều kiện trước** | Sản phẩm ID=99999 không tồn tại |
| **Các bước** | 1. Truy cập trực tiếp URL: /product/99999 |
| **Kết quả mong đợi** | - Hiển thị trang 404<br>- Thông báo "Sản phẩm không tồn tại"<br>- Link quay về trang chủ |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_CART_001 - Thêm sản phẩm vào giỏ hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_001 |
| **Tiêu đề** | Thêm sản phẩm vào giỏ hàng từ trang chi tiết |
| **Điều kiện trước** | User đã đăng nhập, sản phẩm còn hàng |
| **Các bước** | 1. Mở trang chi tiết sản phẩm<br>2. Chọn số lượng: 1<br>3. Click nút "Thêm vào giỏ hàng" |
| **Kết quả mong đợi** | - Thông báo "Đã thêm vào giỏ hàng"<br>- Icon giỏ hàng cập nhật số lượng<br>- Sản phẩm xuất hiện trong giỏ |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CART_002 - Thêm sản phẩm từ danh sách (Quick Add)

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_002 |
| **Tiêu đề** | Thêm nhanh sản phẩm từ trang danh sách |
| **Điều kiện trước** | User đã đăng nhập |
| **Các bước** | 1. Mở trang danh sách sản phẩm<br>2. Hover vào sản phẩm<br>3. Click icon "Thêm giỏ hàng" |
| **Kết quả mong đợi** | - Thêm 1 sản phẩm vào giỏ<br>- Thông báo thành công |
| **Độ ưu tiên** | Medium |
| **Loại test** | Positive |

---

## TC_CART_003 - Thêm sản phẩm hết hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_003 |
| **Tiêu đề** | Thêm sản phẩm đã hết hàng vào giỏ |
| **Điều kiện trước** | Sản phẩm "SP hết hàng" có stock = 0 |
| **Các bước** | 1. Mở trang chi tiết sản phẩm hết hàng<br>2. Cố gắng click "Thêm vào giỏ hàng" |
| **Kết quả mong đợi** | - Nút "Thêm vào giỏ hàng" bị disable<br>- Hiển thị "Hết hàng" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_CART_004 - Thêm số lượng vượt quá tồn kho

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_004 |
| **Tiêu đề** | Thêm số lượng lớn hơn tồn kho |
| **Điều kiện trước** | Sản phẩm có stock = 5 |
| **Các bước** | 1. Mở trang chi tiết sản phẩm (stock=5)<br>2. Nhập số lượng: 10<br>3. Click "Thêm vào giỏ hàng" |
| **Kết quả mong đợi** | - Thông báo "Số lượng vượt quá tồn kho"<br>- Không thêm được vào giỏ |
| **Độ ưu tiên** | High |
| **Loại test** | Boundary |

---

## TC_CART_005 - Thêm số lượng âm

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_005 |
| **Tiêu đề** | Nhập số lượng âm khi thêm giỏ hàng |
| **Điều kiện trước** | Sản phẩm còn hàng |
| **Các bước** | 1. Mở trang chi tiết sản phẩm<br>2. Nhập số lượng: -1<br>3. Click "Thêm vào giỏ hàng" |
| **Kết quả mong đợi** | - Validation error<br>- Thông báo "Số lượng phải lớn hơn 0" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_CART_006 - Cập nhật số lượng trong giỏ hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_006 |
| **Tiêu đề** | Tăng số lượng sản phẩm trong giỏ |
| **Điều kiện trước** | Giỏ hàng có 1 sản phẩm với số lượng = 1 |
| **Các bước** | 1. Mở trang giỏ hàng<br>2. Click nút "+" để tăng số lượng thành 2<br>3. Đợi cập nhật |
| **Kết quả mong đợi** | - Số lượng cập nhật thành 2<br>- Tổng tiền được tính lại đúng |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CART_007 - Giảm số lượng về 0

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_007 |
| **Tiêu đề** | Giảm số lượng từ 1 về 0 |
| **Điều kiện trước** | Giỏ hàng có sản phẩm với số lượng = 1 |
| **Các bước** | 1. Mở trang giỏ hàng<br>2. Click nút "-" để giảm số lượng về 0 |
| **Kết quả mong đợi** | - Hiển thị xác nhận xóa sản phẩm<br>- Hoặc sản phẩm bị xóa khỏi giỏ |
| **Độ ưu tiên** | Medium |
| **Loại test** | Boundary |

---

## TC_CART_008 - Xóa sản phẩm khỏi giỏ hàng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_008 |
| **Tiêu đề** | Xóa sản phẩm khỏi giỏ hàng |
| **Điều kiện trước** | Giỏ hàng có ít nhất 1 sản phẩm |
| **Các bước** | 1. Mở trang giỏ hàng<br>2. Click icon "Xóa" bên cạnh sản phẩm<br>3. Xác nhận xóa |
| **Kết quả mong đợi** | - Sản phẩm bị xóa khỏi giỏ<br>- Tổng tiền được cập nhật<br>- Thông báo "Đã xóa sản phẩm" |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CART_009 - Xóa tất cả sản phẩm trong giỏ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_009 |
| **Tiêu đề** | Xóa tất cả sản phẩm trong giỏ hàng |
| **Điều kiện trước** | Giỏ hàng có nhiều sản phẩm |
| **Các bước** | 1. Mở trang giỏ hàng<br>2. Click "Xóa tất cả"<br>3. Xác nhận xóa |
| **Kết quả mong đợi** | - Giỏ hàng trống<br>- Hiển thị "Giỏ hàng trống"<br>- Link đến trang mua sắm |
| **Độ ưu tiên** | Medium |
| **Loại test** | Positive |

---

## TC_CART_010 - Xem giỏ hàng khi chưa đăng nhập

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_010 |
| **Tiêu đề** | Truy cập giỏ hàng khi chưa đăng nhập |
| **Điều kiện trước** | User chưa đăng nhập |
| **Các bước** | 1. Click icon giỏ hàng khi chưa đăng nhập |
| **Kết quả mong đợi** | - Chuyển hướng đến trang đăng nhập<br>- Hoặc hiển thị giỏ hàng trống với nút đăng nhập |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_PROD_009 - Lọc giá với giá trị không hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_PROD_009 |
| **Tiêu đề** | Lọc với giá từ lớn hơn giá đến |
| **Điều kiện trước** | Đang ở trang danh sách sản phẩm |
| **Các bước** | 1. Nhập giá từ: 500000<br>2. Nhập giá đến: 100000<br>3. Click "Áp dụng" |
| **Kết quả mong đợi** | - Thông báo lỗi "Giá từ phải nhỏ hơn giá đến"<br>- Không áp dụng filter |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_CART_011 - Persist giỏ hàng sau refresh

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_011 |
| **Tiêu đề** | Giữ giỏ hàng sau khi refresh trang |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng có sản phẩm |
| **Các bước** | 1. Thêm sản phẩm vào giỏ<br>2. Refresh trang (F5)<br>3. Kiểm tra giỏ hàng |
| **Kết quả mong đợi** | - Giỏ hàng vẫn giữ nguyên sản phẩm<br>- Số lượng và tổng tiền không thay đổi |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_CART_012 - Thêm cùng sản phẩm nhiều lần

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_CART_012 |
| **Tiêu đề** | Thêm cùng một sản phẩm 2 lần |
| **Điều kiện trước** | Đã đăng nhập, giỏ hàng trống |
| **Các bước** | 1. Thêm sản phẩm A vào giỏ (qty=1)<br>2. Thêm lại sản phẩm A (qty=1) |
| **Kết quả mong đợi** | - Sản phẩm A chỉ xuất hiện 1 lần trong giỏ<br>- Số lượng được cộng dồn thành 2 |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## Tổng kết Module Product & Cart

| Loại Test | Số lượng |
|-----------|----------|
| Positive | 12 |
| Negative | 5 |
| Boundary | 3 |
| **Tổng** | **20** |
