\# BẢNG QUYẾT ĐỊNH (DECISION TABLE)

## Mục đích

Bảng quyết định giúp xác định tất cả các kết hợp điều kiện đầu vào và kết quả tương ứng, đảm bảo coverage đầy đủ cho testing.

---

## 1. Bảng quyết định - Đăng ký (Registration)

### Biểu đồ luồng quyết định

```mermaid
flowchart TD
    Start([Bắt đầu Đăng ký]) --> C1{C1: Email<br/>hợp lệ?}
    
    C1 -->|Không| A5[/"❌ Lỗi: Email không<br/>đúng định dạng"/]
    C1 -->|Có| C2{C2: Email<br/>chưa tồn tại?}
    
    C2 -->|Không| A4[/"❌ Lỗi: Email đã<br/>được sử dụng"/]
    C2 -->|Có| C3{C3: Mật khẩu<br/>>= 8 ký tự?}
    
    C3 -->|Không| A3[/"❌ Lỗi: Mật khẩu<br/>tối thiểu 8 ký tự"/]
    C3 -->|Có| C4{C4: Xác nhận<br/>mật khẩu khớp?}
    
    C4 -->|Không| A2[/"❌ Lỗi: Mật khẩu<br/>không khớp"/]
    C4 -->|Có| A1[/"✅ Đăng ký<br/>thành công"/]
    
    A1 --> End([Kết thúc])
    A2 --> End
    A3 --> End
    A4 --> End
    A5 --> End

    style Start fill:#4CAF50,color:#fff
    style End fill:#9E9E9E,color:#fff
    style A1 fill:#4CAF50,color:#fff
    style A2 fill:#f44336,color:#fff
    style A3 fill:#f44336,color:#fff
    style A4 fill:#f44336,color:#fff
    style A5 fill:#f44336,color:#fff
```

### Điều kiện đầu vào

| Điều kiện | Mô tả | Chi tiết | Giá trị hợp lệ | Giá trị không hợp lệ |
|-----------|-------|----------|----------------|----------------------|
| C1 | Email hợp lệ | Kiểm tra định dạng email theo RFC 5322, phải có `@` và domain | `user@gmail.com`, `test.user@mail.vn` | `invalid`, `@domain.com`, `user@`, `user@@gmail.com` |
| C2 | Email chưa tồn tại | Query database kiểm tra email chưa được đăng ký | Email mới chưa có trong DB | Email đã tồn tại trong DB |
| C3 | Mật khẩu >= 8 ký tự | Kiểm tra độ dài chuỗi password >= 8 | `password123`, `MyP@ss2024` | `pass`, `1234567`, `` (rỗng) |
| C4 | Xác nhận mật khẩu khớp | So sánh string password == confirm_password | Hai trường nhập giống nhau | Hai trường nhập khác nhau |

### Mối quan hệ giữa các biến

```mermaid
graph LR
    C1[C1: Email hợp lệ] -->|Phải đạt trước| C2[C2: Email chưa tồn tại]
    C2 -->|Độc lập| C3[C3: Mật khẩu >= 8 ký tự]
    C3 -->|Phải đạt trước| C4[C4: Xác nhận khớp]
    
    style C1 fill:#E8F5E9,stroke:#4CAF50
    style C2 fill:#E8F5E9,stroke:#4CAF50
    style C3 fill:#E3F2FD,stroke:#1976D2
    style C4 fill:#E3F2FD,stroke:#1976D2
```

> **Ghi chú**: C1→C2 là chuỗi kiểm tra email, C3→C4 là chuỗi kiểm tra mật khẩu. Hai chuỗi này có thể kiểm tra song song.

### Bảng quyết định

| Rule | R1 | R2 | R3 | R4 | R5 | R6 | R7 | R8 |
|------|----|----|----|----|----|----|----|----|
| **Điều kiện** | | | | | | | | |
| C1: Email hợp lệ | T | T | T | T | T | T | F | F |
| C2: Email chưa tồn tại | T | T | T | T | F | F | - | - |
| C3: Mật khẩu >= 8 ký tự | T | T | F | F | - | - | - | - |
| C4: Xác nhận mật khẩu khớp | T | F | - | - | - | - | - | - |
| **Hành động** | | | | | | | | |
| Đăng ký thành công | ✓ | | | | | | | |
| Lỗi: "Mật khẩu không khớp" | | ✓ | | | | | | |
| Lỗi: "Mật khẩu tối thiểu 8 ký tự" | | | ✓ | ✓ | | | | |
| Lỗi: "Email đã được sử dụng" | | | | | ✓ | ✓ | | |
| Lỗi: "Email không đúng định dạng" | | | | | | | ✓ | ✓ |

### Mapping với Test Cases

| Rule | Test Case ID |
|------|--------------|
| R1 | TC_AUTH_001, TC_AUTH_005 |
| R2 | TC_AUTH_015 |
| R3, R4 | TC_AUTH_004 |
| R5, R6 | TC_AUTH_002 |
| R7, R8 | TC_AUTH_003 |

---

## 2. Bảng quyết định - Đăng nhập (Login)

### Biểu đồ luồng quyết định

```mermaid
flowchart TD
    Start([Bắt đầu Đăng nhập]) --> C1{C1: Email<br/>đã nhập?}
    
    C1 -->|Không| A3[/"❌ Lỗi: Vui lòng<br/>nhập email"/]
    C1 -->|Có| C2{C2: Mật khẩu<br/>đã nhập?}
    
    C2 -->|Không| A4[/"❌ Lỗi: Vui lòng<br/>nhập mật khẩu"/]
    C2 -->|Có| C3{C3: Email<br/>tồn tại?}
    
    C3 -->|Không| A2[/"❌ Lỗi: Email/mật khẩu<br/>không đúng"/]
    C3 -->|Có| C4{C4: Mật khẩu<br/>đúng?}
    
    C4 -->|Không| A2
    C4 -->|Có| A1[/"✅ Đăng nhập<br/>thành công"/]
    
    A1 --> End([Kết thúc])
    A2 --> End
    A3 --> End
    A4 --> End

    style Start fill:#2196F3,color:#fff
    style End fill:#9E9E9E,color:#fff
    style A1 fill:#4CAF50,color:#fff
    style A2 fill:#f44336,color:#fff
    style A3 fill:#f44336,color:#fff
    style A4 fill:#f44336,color:#fff
```

### Điều kiện đầu vào

| Điều kiện | Mô tả | Chi tiết | Giá trị hợp lệ | Giá trị không hợp lệ |
|-----------|-------|----------|----------------|----------------------|
| C1 | Email đã nhập | Kiểm tra trường email không rỗng và không chỉ có whitespace | `user@gmail.com`, bất kỳ chuỗi không rỗng | `` (rỗng), `   ` (chỉ whitespace) |
| C2 | Mật khẩu đã nhập | Kiểm tra trường password không rỗng | Bất kỳ chuỗi không rỗng | `` (rỗng) |
| C3 | Email tồn tại | Query database kiểm tra email đã đăng ký | Email có trong bảng users | Email không có trong DB |
| C4 | Mật khẩu đúng | Hash password nhập vào và so sánh với hash trong DB | Hash khớp với DB | Hash không khớp |

### Mối quan hệ giữa các biến

```mermaid
graph LR
    C1[C1: Email đã nhập] -->|Độc lập| C2[C2: Mật khẩu đã nhập]
    C1 -->|Phải đạt trước| C3[C3: Email tồn tại]
    C2 -->|Phải đạt trước| C4[C4: Mật khẩu đúng]
    C3 -->|Phải đạt trước| C4
    
    style C1 fill:#FFF3E0,stroke:#FF9800
    style C2 fill:#FFF3E0,stroke:#FF9800
    style C3 fill:#E3F2FD,stroke:#1976D2
    style C4 fill:#E3F2FD,stroke:#1976D2
```

> **Ghi chú**: C1 và C2 kiểm tra input cơ bản (độc lập). C3 và C4 kiểm tra logic nghiệp vụ (phụ thuộc tuần tự).

### Bảng quyết định

| Rule | R1 | R2 | R3 | R4 | R5 | R6 |
|------|----|----|----|----|----|----|
| **Điều kiện** | | | | | | |
| C1: Email đã nhập | T | T | T | T | F | T |
| C2: Mật khẩu đã nhập | T | T | T | T | T | F |
| C3: Email tồn tại | T | T | F | F | - | - |
| C4: Mật khẩu đúng | T | F | - | - | - | - |
| **Hành động** | | | | | | |
| Đăng nhập thành công | ✓ | | | | | |
| Lỗi: "Email/mật khẩu không đúng" | | ✓ | ✓ | ✓ | | |
| Lỗi: "Vui lòng nhập email" | | | | | ✓ | |
| Lỗi: "Vui lòng nhập mật khẩu" | | | | | | ✓ |

### Mapping với Test Cases

| Rule | Test Case ID |
|------|--------------|
| R1 | TC_AUTH_006 |
| R2 | TC_AUTH_007 |
| R3, R4 | TC_AUTH_008 |
| R5 | TC_AUTH_009 |

---

## 3. Bảng quyết định - Quên mật khẩu (Forgot Password)

### Biểu đồ luồng quyết định

```mermaid
flowchart TD
    Start([Bắt đầu Quên MK]) --> C1{C1: Email<br/>hợp lệ?}
    
    C1 -->|Không| A4[/"❌ Lỗi: Email không<br/>đúng định dạng"/]
    C1 -->|Có| C2{C2: Email<br/>tồn tại?}
    
    C2 -->|Không| A3[/"❌ Lỗi: Email không<br/>tồn tại trong hệ thống"/]
    C2 -->|Có| C3{C3: Số lần yêu cầu<br/>< giới hạn?}
    
    C3 -->|Không| A2[/"❌ Lỗi: Quá nhiều<br/>yêu cầu, thử lại sau"/]
    C3 -->|Có| A1[/"✅ Gửi email reset<br/>thành công"/]
    
    A1 --> End([Kết thúc])
    A2 --> End
    A3 --> End
    A4 --> End

    style Start fill:#FF9800,color:#fff
    style End fill:#9E9E9E,color:#fff
    style A1 fill:#4CAF50,color:#fff
    style A2 fill:#f44336,color:#fff
    style A3 fill:#f44336,color:#fff
    style A4 fill:#f44336,color:#fff
```

### Điều kiện đầu vào

| Điều kiện | Mô tả | Chi tiết | Giá trị hợp lệ | Giá trị không hợp lệ |
|-----------|-------|----------|----------------|----------------------|
| C1 | Email hợp lệ | Kiểm tra định dạng email theo RFC 5322 | `user@domain.com`, `test.user@mail.vn` | `invalid`, `@domain.com`, `user@` |
| C2 | Email tồn tại | Kiểm tra email đã đăng ký trong database | Email đã đăng ký tài khoản | Email chưa từng đăng ký |
| C3 | Giới hạn yêu cầu | Số lần request reset trong 24h < 5 lần | 0-4 lần yêu cầu | >= 5 lần yêu cầu |

### Mối quan hệ giữa các biến

```mermaid
graph LR
    C1[C1: Email hợp lệ] -->|Phải đạt trước| C2[C2: Email tồn tại]
    C2 -->|Phải đạt trước| C3[C3: Rate limit]
    
    style C1 fill:#E3F2FD,stroke:#1976D2
    style C2 fill:#E3F2FD,stroke:#1976D2
    style C3 fill:#E3F2FD,stroke:#1976D2
```

> **Ghi chú**: Các điều kiện có quan hệ phụ thuộc tuần tự. C2 chỉ được kiểm tra khi C1=True, C3 chỉ được kiểm tra khi C2=True.

### Bảng quyết định

| Rule | R1 | R2 | R3 | R4 | R5 | R6 |
|------|----|----|----|----|----|----|
| **Điều kiện** | | | | | | |
| C1: Email hợp lệ | T | T | T | T | F | F |
| C2: Email tồn tại | T | T | F | F | - | - |
| C3: Số lần < 5 | T | F | - | - | - | - |
| **Hành động** | | | | | | |
| Gửi email reset thành công | ✓ | | | | | |
| Lỗi: "Quá nhiều yêu cầu" | | ✓ | | | | |
| Lỗi: "Email không tồn tại" | | | ✓ | ✓ | | |
| Lỗi: "Email không đúng định dạng" | | | | | ✓ | ✓ |

### Mapping với Test Cases

| Rule | Test Case ID | Mô tả |
|------|--------------|-------|
| R1 | TC_AUTH_010 | Reset mật khẩu thành công |
| R2 | TC_AUTH_016 | Vượt quá giới hạn yêu cầu |
| R3, R4 | TC_AUTH_011 | Email không tồn tại |
| R5, R6 | TC_AUTH_017 | Email không đúng định dạng |

---

## 4. Bảng quyết định - Security Testing

### Biểu đồ luồng quyết định

```mermaid
flowchart TD
    Start([Nhận Input]) --> Check{Input chứa<br/>mã độc?}
    
    Check -->|SQL Injection| S1[Sanitize SQL]
    Check -->|XSS Script| S2[Escape HTML]
    Check -->|Cả hai| S3[Sanitize All]
    Check -->|Không| S4[Xử lý bình thường]
    
    S1 --> V1{Validate<br/>thành công?}
    S2 --> V1
    S3 --> V1
    S4 --> A1[/"✅ Xử lý request<br/>thành công"/]
    
    V1 -->|Không| A2[/"❌ Hiển thị lỗi<br/>validation"/]
    V1 -->|Có| A3[/"⚠️ Input được<br/>làm sạch"/]
    
    A1 --> End([Kết thúc])
    A2 --> End
    A3 --> End

    style Start fill:#9C27B0,color:#fff
    style End fill:#9E9E9E,color:#fff
    style A1 fill:#4CAF50,color:#fff
    style A2 fill:#f44336,color:#fff
    style A3 fill:#FF9800,color:#fff
    style S1 fill:#E3F2FD,color:#333
    style S2 fill:#E3F2FD,color:#333
    style S3 fill:#E3F2FD,color:#333
```

### Điều kiện đầu vào

| Điều kiện | Mô tả | Chi tiết | Giá trị hợp lệ (Có tấn công) | Giá trị không hợp lệ (Không tấn công) |
|-----------|-------|----------|------------------------------|--------------------------------------|
| C1 | SQL Injection | Input chứa các SQL keywords như `SELECT`, `DROP`, `OR 1=1`, `--` comment | `' OR 1=1 --`, `'; DROP TABLE users;--`, `admin'--` | `normaluser`, `john.doe@email.com` |
| C2 | XSS Script | Input chứa JavaScript code hoặc HTML tags nguy hiểm | `<script>alert('XSS')</script>`, `<img onerror="alert(1)">`, `javascript:void(0)` | `Hello World`, `<b>Bold text</b>` |
| C3 | Đã Sanitize | Hệ thống xử lý escape/encode input trước khi sử dụng | Input đã được làm sạch | Input chưa xử lý (raw) |

### Mối quan hệ giữa các biến

```mermaid
graph TD
    Input[User Input] --> C1{C1: SQL Injection?}
    Input --> C2{C2: XSS Script?}
    
    C1 -->|Detected| S1[SQL Sanitization]
    C2 -->|Detected| S2[XSS Sanitization]
    
    S1 --> C3{C3: Sanitized?}
    S2 --> C3
    
    C3 -->|Yes| Safe[✅ Safe to Process]
    C3 -->|No| Block[❌ Block Request]
    
    style C1 fill:#FFEBEE,stroke:#f44336
    style C2 fill:#FFEBEE,stroke:#f44336
    style C3 fill:#E8F5E9,stroke:#4CAF50
```

> **Ghi chú**: C1 và C2 là kiểm tra độc lập (OR logic). C3 là kết quả của quá trình sanitization, phụ thuộc vào việc phát hiện C1 hoặc C2.

### Bảng quyết định

| Rule | R1 | R2 | R3 | R4 |
|------|----|----|----|----|
| **Điều kiện** | | | | |
| C1: SQL Injection | T | F | T | F |
| C2: XSS script | F | T | T | F |
| C3: Được sanitize | T | T | T | T |
| **Hành động** | | | | |
| Hiển thị lỗi validation | ✓ | ✓ | ✓ | |
| Script không thực thi | ✓ | ✓ | ✓ | ✓ |
| Không lỗi hệ thống | ✓ | ✓ | ✓ | ✓ |

### Mapping với Test Cases

| Rule | Test Case ID |
|------|--------------|
| R1 | TC_AUTH_013 |
| R2 | TC_AUTH_014 |

---

## Ghi chú

| Ký hiệu | Ý nghĩa |
|---------|---------|
| T | True - Điều kiện đúng |
| F | False - Điều kiện sai |
| - | Don't Care - Không ảnh hưởng |
| ✓ | Hành động được thực hiện |
| (trống) | Hành động không thực hiện |

---

## Tổng kết

| Chức năng | Số biến đầu vào | Số Rules | Test Cases Ánh xạ |
|-----------|-----------------|----------|-------------------|
| Đăng ký | 4 | 8 | 5 TCs |
| Đăng nhập | 4 | 6 | 4 TCs |
| Quên mật khẩu | 3 | 6 | 4 TCs |
| Security | 3 | 4 | 2 TCs |
| **Tổng** | **14** | **24** | **15 TCs** |
