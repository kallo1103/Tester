# CHỈ SỐ KIỂM THỬ (TEST METRICS)

## Hệ thống: E-commerce Website

---

## Thông tin tài liệu

| Thông tin | Chi tiết |
|-----------|----------|
| **Dự án** | E-commerce Website |
| **Phiên bản** | 1.0 |
| **Ngày báo cáo** | 30/01/2026 |
| **Giai đoạn** | Test Execution Round 1 |

---

## 1. Tỷ lệ thực thi Test (Test Execution Rate)

### 1.1 Công thức

```
Test Execution Rate = (Số TC đã thực thi / Tổng số TC) × 100%
```

### 1.2 Kết quả

| Chỉ số | Giá trị |
|--------|---------|
| Tổng số Test Cases | 45 |
| Test Cases đã thực thi | 45 |
| Test Cases chưa thực thi | 0 |
| **Test Execution Rate** | **100%** |

### 1.3 Chi tiết theo Module

| Module | Planned | Executed | Rate |
|--------|---------|----------|------|
| Authentication | 15 | 15 | 100% |
| Product & Cart | 20 | 20 | 100% |
| Checkout | 10 | 10 | 100% |
| **Tổng** | **45** | **45** | **100%** |

### 1.4 Biểu đồ tiến độ thực thi

```
Ngày 1: ████████████████████░░░░░░░░░░ 50% (23/45)
Ngày 2: ████████████████████████████░░ 89% (40/45)
Ngày 3: ██████████████████████████████ 100% (45/45)
```

---

## 2. Mật độ lỗi theo Module (Defect Density)

### 2.1 Công thức

```
Defect Density = Số bug / Số test cases của module
```

### 2.2 Kết quả

| Module | Test Cases | Bugs Found | Defect Density |
|--------|------------|------------|----------------|
| Authentication | 15 | 2 | 0.13 bugs/TC |
| Product | 8 | 2 | 0.25 bugs/TC |
| Cart | 12 | 3 | 0.25 bugs/TC |
| Checkout | 10 | 2 | 0.20 bugs/TC |
| **Tổng/Trung bình** | **45** | **10** | **0.22 bugs/TC** |

### 2.3 Biểu đồ so sánh

```
Authentication:  ██░░░░░░░░ 0.13 (Low)
Product:         ███░░░░░░░ 0.25 (Medium)
Cart:            ███░░░░░░░ 0.25 (Medium)  ⚠️ Highest
Checkout:        ██░░░░░░░░ 0.20 (Medium)

Benchmark: < 0.15 = Good | 0.15-0.30 = Acceptable | > 0.30 = High
```

### 2.4 Phân tích

- **Product & Cart** có mật độ lỗi cao nhất (0.25), cần review code kỹ hơn
- **Authentication** có mật độ thấp nhất (0.13), nhưng có 1 bug Critical
- Mật độ trung bình 0.22 nằm trong ngưỡng chấp nhận được

---

## 3. Phân bố mức độ nghiêm trọng (Severity Distribution)

### 3.1 Số liệu

| Severity | Số lượng | Tỷ lệ | Trạng thái |
|----------|----------|-------|------------|
| 🔴 Critical | 2 | 20% | Open |
| 🟠 Major | 4 | 40% | Open |
| 🟡 Minor | 4 | 40% | Open |
| **Tổng** | **10** | **100%** | |

### 3.2 Biểu đồ phân bố

```
Critical: ██████████░░░░░░░░░░░░░░░░░░░░ 20% (2)
Major:    ████████████████████░░░░░░░░░░ 40% (4)
Minor:    ████████████████████░░░░░░░░░░ 40% (4)
```

### 3.3 Phân bố theo Module và Severity

| Module | Critical | Major | Minor | Tổng |
|--------|----------|-------|-------|------|
| Authentication | 1 | 0 | 1 | 2 |
| Product | 0 | 0 | 2 | 2 |
| Cart | 0 | 3 | 0 | 3 |
| Checkout | 1 | 1 | 0 | 2 |
| UI | 0 | 0 | 1 | 1 |

### 3.4 Nhận xét

- ⚠️ **20% bug là Critical** - Tỷ lệ cao, cần ưu tiên fix ngay
- Module **Cart** tập trung nhiều bug Major → Logic business phức tạp
- Module **Product** chỉ có bug Minor → Chất lượng tốt

---

## 4. Độ bao phủ yêu cầu (Requirement Coverage)

### 4.1 Công thức

```
Requirement Coverage = (Số Req được cover / Tổng số Req) × 100%
```

### 4.2 Kết quả

| Chỉ số | Giá trị |
|--------|---------|
| Tổng số Requirements | 16 |
| Requirements được cover | 16 |
| Requirements chưa cover | 0 |
| **Requirement Coverage** | **100%** |

### 4.3 Chi tiết theo Module

| Module | Requirements | Covered | Coverage |
|--------|--------------|---------|----------|
| Authentication (R1-R6) | 6 | 6 | 100% |
| Product & Cart (R7-R12) | 6 | 6 | 100% |
| Checkout (R13-R16) | 4 | 4 | 100% |
| **Tổng** | **16** | **16** | **100%** |

### 4.4 Phân bố Test Case per Requirement

| TC/Requirement | Số Req | Tỷ lệ |
|----------------|--------|-------|
| 2 TCs | 7 | 43.75% |
| 3 TCs | 6 | 37.50% |
| 4 TCs | 3 | 18.75% |
| **Trung bình** | **2.75** | - |

### 4.5 Nhận xét

- ✅ **100% requirements được bao phủ** - Đạt yêu cầu
- ✅ Mỗi requirement có ít nhất 2 test cases
- ✅ Các requirement quan trọng (R10, R14) có 4 TCs

---

## 5. Các chỉ số bổ sung

### 5.1 Pass Rate

```
Pass Rate = (Passed TCs / Executed TCs) × 100%
          = (35 / 45) × 100%
          = 77.8%
```

| Kết quả | Số lượng | Tỷ lệ |
|---------|----------|-------|
| ✅ Passed | 35 | 77.8% |
| ❌ Failed | 8 | 17.8% |
| 🔒 Blocked | 2 | 4.4% |

**Đánh giá**: ❌ Chưa đạt (yêu cầu ≥ 95%)

### 5.2 Fail Rate by Module

| Module | Fail Rate | Status |
|--------|-----------|--------|
| Authentication | 13.3% | ⚠️ |
| Product & Cart | 15.0% | ⚠️ |
| Checkout | 30.0% | ❌ Cao |

### 5.3 Bug Find Rate

```
Bug Find Rate = Bugs Found / Executed TCs
              = 10 / 45
              = 0.22 bugs/TC
```

---

## 6. Tổng hợp Dashboard

```
┌─────────────────────────────────────────────────────────────┐
│                    TEST METRICS DASHBOARD                    │
├─────────────────────────────────────────────────────────────┤
│                                                              │
│   EXECUTION RATE          PASS RATE            COVERAGE      │
│   ┌─────────────┐        ┌─────────────┐     ┌─────────────┐│
│   │    100%     │        │    77.8%    │     │    100%     ││
│   │     ✅      │        │      ❌     │     │     ✅      ││
│   └─────────────┘        └─────────────┘     └─────────────┘│
│                                                              │
│   BUGS BY SEVERITY                                           │
│   Critical: ██░░░░ 2 (20%)                                   │
│   Major:    ████░░ 4 (40%)                                   │
│   Minor:    ████░░ 4 (40%)                                   │
│                                                              │
│   DEFECT DENSITY BY MODULE                                   │
│   Auth:     █░░░░ 0.13                                       │
│   Product:  ██░░░ 0.25                                       │
│   Cart:     ██░░░ 0.25  ← Highest                            │
│   Checkout: ██░░░ 0.20                                       │
│                                                              │
│   STATUS: ⛔ NO-RELEASE (2 Critical bugs open)               │
│                                                              │
└─────────────────────────────────────────────────────────────┘
```

---

## 7. Kết luận và Đề xuất

### 7.1 Điểm đạt

- ✅ Test Execution Rate: 100%
- ✅ Requirement Coverage: 100%
- ✅ Mỗi requirement có ≥ 2 TCs

### 7.2 Điểm chưa đạt

- ❌ Pass Rate: 77.8% (< 95%)
- ❌ Còn 2 bug Critical
- ❌ Còn 4 bug Major

### 7.3 Đề xuất cải tiến

1. **Tăng cường testing module Checkout** - Fail rate cao nhất (30%)
2. **Review code module Cart** - Defect density cao (0.25)
3. **Fix all Critical & Major bugs** trước khi regression test
4. **Target Pass Rate ≥ 95%** cho Round 2

---

## Phụ lục: Định nghĩa chỉ số

| Chỉ số | Định nghĩa | Ngưỡng tốt |
|--------|------------|------------|
| Test Execution Rate | % TCs đã thực thi | ≥ 95% |
| Pass Rate | % TCs passed | ≥ 95% |
| Defect Density | Bugs/TCs | < 0.15 |
| Requirement Coverage | % Req có TC | 100% |
| Bug Critical % | % Critical bugs | < 10% |
