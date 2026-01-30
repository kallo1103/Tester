# CA KIỂM THỬ - MODULE XÁC THỰC (AUTHENTICATION)

## Tổng quan: 15 Test Cases

---

## TC_AUTH_001 - Đăng ký với email hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_001 |
| **Tiêu đề** | Đăng ký tài khoản với email hợp lệ |
| **Điều kiện trước** | User chưa có tài khoản, trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email hợp lệ: <newuser@example.com><br>3. Nhập mật khẩu: Test@1234<br>4. Nhập xác nhận mật khẩu: Test@1234<br>5. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thành công<br>- Hiển thị thông báo "Đăng ký thành công"<br>- Chuyển hướng đến trang đăng nhập |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_AUTH_002 - Đăng ký với email đã tồn tại

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_002 |
| **Tiêu đề** | Đăng ký với email đã có trong hệ thống |
| **Điều kiện trước** | Email <existing@example.com> đã đăng ký |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email: <existing@example.com><br>3. Nhập mật khẩu: Test@1234<br>4. Nhập xác nhận mật khẩu: Test@1234<br>5. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thất bại<br>- Hiển thị thông báo lỗi "Email đã được sử dụng" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_AUTH_003 - Đăng ký với email sai định dạng

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_003 |
| **Tiêu đề** | Đăng ký với email không đúng định dạng |
| **Điều kiện trước** | Trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email: invalidemail<br>3. Nhập mật khẩu: Test@1234<br>4. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thất bại<br>- Hiển thị thông báo "Email không đúng định dạng" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_AUTH_004 - Đăng ký với mật khẩu dưới 8 ký tự

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_004 |
| **Tiêu đề** | Đăng ký với mật khẩu chỉ 7 ký tự (Boundary) |
| **Điều kiện trước** | Trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email: <test@example.com><br>3. Nhập mật khẩu: Test@12 (7 ký tự)<br>4. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thất bại<br>- Hiển thị thông báo "Mật khẩu phải tối thiểu 8 ký tự" |
| **Độ ưu tiên** | High |
| **Loại test** | Boundary |

---

## TC_AUTH_005 - Đăng ký với mật khẩu đúng 8 ký tự

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_005 |
| **Tiêu đề** | Đăng ký với mật khẩu đúng 8 ký tự (Boundary) |
| **Điều kiện trước** | Trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email: <boundary@example.com><br>3. Nhập mật khẩu: Test@123 (8 ký tự)<br>4. Nhập xác nhận mật khẩu: Test@123<br>5. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thành công<br>- Mật khẩu 8 ký tự được chấp nhận |
| **Độ ưu tiên** | Medium |
| **Loại test** | Boundary |

---

## TC_AUTH_006 - Đăng nhập với thông tin hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_006 |
| **Tiêu đề** | Đăng nhập với email và mật khẩu đúng |
| **Điều kiện trước** | User đã có tài khoản: <user@example.com> / Test@1234 |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Nhập email: <user@example.com><br>3. Nhập mật khẩu: Test@1234<br>4. Click nút "Đăng nhập" |
| **Kết quả mong đợi** | - Đăng nhập thành công<br>- Chuyển hướng đến trang chủ<br>- Hiển thị tên user ở header |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_AUTH_007 - Đăng nhập với mật khẩu sai

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_007 |
| **Tiêu đề** | Đăng nhập với mật khẩu không đúng |
| **Điều kiện trước** | User đã có tài khoản: <user@example.com> / Test@1234 |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Nhập email: <user@example.com><br>3. Nhập mật khẩu: WrongPass<br>4. Click nút "Đăng nhập" |
| **Kết quả mong đợi** | - Đăng nhập thất bại<br>- Hiển thị thông báo "Email hoặc mật khẩu không đúng" |
| **Độ ưu tiên** | High |
| **Loại test** | Negative |

---

## TC_AUTH_008 - Đăng nhập với email không tồn tại

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_008 |
| **Tiêu đề** | Đăng nhập với email chưa đăng ký |
| **Điều kiện trước** | Email <notexist@example.com> chưa đăng ký |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Nhập email: <notexist@example.com><br>3. Nhập mật khẩu: Test@1234<br>4. Click nút "Đăng nhập" |
| **Kết quả mong đợi** | - Đăng nhập thất bại<br>- Hiển thị thông báo "Email hoặc mật khẩu không đúng" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_AUTH_009 - Đăng nhập với trường email trống

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_009 |
| **Tiêu đề** | Đăng nhập khi để trống email |
| **Điều kiện trước** | Trang đăng nhập đã mở |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Để trống trường email<br>3. Nhập mật khẩu: Test@1234<br>4. Click nút "Đăng nhập" |
| **Kết quả mong đợi** | - Đăng nhập thất bại<br>- Hiển thị thông báo "Vui lòng nhập email" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Validation |

---

## TC_AUTH_010 - Quên mật khẩu với email hợp lệ

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_010 |
| **Tiêu đề** | Yêu cầu đặt lại mật khẩu với email đã đăng ký |
| **Điều kiện trước** | User đã có tài khoản: <user@example.com> |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Click link "Quên mật khẩu"<br>3. Nhập email: <user@example.com><br>4. Click nút "Gửi email đặt lại" |
| **Kết quả mong đợi** | - Hiển thị thông báo "Email đặt lại mật khẩu đã được gửi"<br>- Email được gửi đến <user@example.com> |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_AUTH_011 - Quên mật khẩu với email không tồn tại

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_011 |
| **Tiêu đề** | Yêu cầu đặt lại mật khẩu với email chưa đăng ký |
| **Điều kiện trước** | Email <notexist@example.com> chưa đăng ký |
| **Các bước** | 1. Mở trang quên mật khẩu<br>2. Nhập email: <notexist@example.com><br>3. Click nút "Gửi email đặt lại" |
| **Kết quả mong đợi** | - Hiển thị thông báo lỗi "Email không tồn tại trong hệ thống" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Negative |

---

## TC_AUTH_012 - Đăng xuất thành công

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_012 |
| **Tiêu đề** | Đăng xuất khi đang đăng nhập |
| **Điều kiện trước** | User đã đăng nhập thành công |
| **Các bước** | 1. Đảm bảo đã đăng nhập<br>2. Click vào icon user ở header<br>3. Click nút "Đăng xuất" |
| **Kết quả mong đợi** | - Đăng xuất thành công<br>- Chuyển hướng đến trang đăng nhập<br>- Session bị xóa |
| **Độ ưu tiên** | High |
| **Loại test** | Positive |

---

## TC_AUTH_013 - SQL Injection trong form đăng nhập

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_013 |
| **Tiêu đề** | Kiểm tra SQL Injection trong trường email |
| **Điều kiện trước** | Trang đăng nhập đã mở |
| **Các bước** | 1. Mở trang đăng nhập<br>2. Nhập email: ' OR '1'='1<br>3. Nhập mật khẩu: anything<br>4. Click nút "Đăng nhập" |
| **Kết quả mong đợi** | - Đăng nhập thất bại<br>- Không có lỗi hệ thống<br>- Hiển thị thông báo validation thông thường |
| **Độ ưu tiên** | High |
| **Loại test** | Security |

---

## TC_AUTH_014 - XSS trong form đăng ký

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_014 |
| **Tiêu đề** | Kiểm tra XSS trong trường tên người dùng |
| **Điều kiện trước** | Trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập tên: `<script>alert('XSS')</script>`<br>3. Nhập email: <test@example.com><br>4. Nhập mật khẩu: Test@1234<br>5. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Script không được thực thi<br>- Input được escape/sanitize đúng cách |
| **Độ ưu tiên** | High |
| **Loại test** | Security |

---

## TC_AUTH_015 - Đăng ký với mật khẩu không khớp

| Trường | Nội dung |
|--------|----------|
| **TC_ID** | TC_AUTH_015 |
| **Tiêu đề** | Đăng ký khi xác nhận mật khẩu không khớp |
| **Điều kiện trước** | Trang đăng ký đã mở |
| **Các bước** | 1. Mở trang đăng ký<br>2. Nhập email: <mismatch@example.com><br>3. Nhập mật khẩu: Test@1234<br>4. Nhập xác nhận mật khẩu: DifferentPass<br>5. Click nút "Đăng ký" |
| **Kết quả mong đợi** | - Đăng ký thất bại<br>- Hiển thị thông báo "Mật khẩu xác nhận không khớp" |
| **Độ ưu tiên** | Medium |
| **Loại test** | Validation |

---

## Tổng kết Module Authentication

| Loại Test | Số lượng |
|-----------|----------|
| Positive | 5 |
| Negative | 5 |
| Boundary | 2 |
| Validation | 2 |
| Security | 2 |
| **Tổng** | **15** |
