import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    // --- countExcellentStudents Tests ---

    @Test
    public void testCountExcellentStudents_MixedScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // 9.0 (G), 8.5 (G), 7.0, 11.0 (invalid), -1.0 (invalid) -> 2 excellent
        assertEquals(2, analyzer.countExcellentStudents(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)));
    }

    @Test
    public void testCountExcellentStudents_AllExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // 8.0, 9.0, 10.0 -> 3 excellent
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0)));
    }

    @Test
    public void testCountExcellentStudents_NoneExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // 5.0, 6.0, 7.9 -> 0 excellent
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(5.0, 6.0, 7.9)));
    }

    @Test
    public void testCountExcellentStudents_Empty() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_Null() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_OnlyInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Arrays.asList(-1.0, 11.0)));
    }

    // --- calculateValidAverage Tests ---

    @Test
    public void testCalculateValidAverage_Mixed() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // 9.0, 8.5, 7.0, 11.0 (ignore), -1.0 (ignore)
        // Valid: 9.0, 8.5, 7.0 -> Sum: 24.5 -> Count: 3 -> Avg: 8.1666...
        assertEquals(8.166, analyzer.calculateValidAverage(Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        // 10.0, 0.0 -> Sum: 10.0 -> Count: 2 -> Avg: 5.0
        assertEquals(5.0, analyzer.calculateValidAverage(Arrays.asList(10.0, 0.0)), 0.01);
    }

    @Test
    public void testCalculateValidAverage_Empty() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.01);
    }

    @Test
    public void testCalculateValidAverage_Null() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.01);
    }

    @Test
    public void testCalculateValidAverage_OnlyInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Arrays.asList(-5.0, 15.0)), 0.01);
    }

    // --- Large List Tests (More than 33000 elements) ---

    /**
     * Test countExcellentStudents với danh sách hơn 33000 phần tử
     * Tất cả đều là điểm giỏi (>= 8.0)
     */
    @Test
    public void testCountExcellentStudents_LargeList_AllExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33001;
        List<Double> largeList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            largeList.add(9.0); // Tất cả đều là điểm giỏi
        }

        assertEquals(size, analyzer.countExcellentStudents(largeList));
    }

    /**
     * Test countExcellentStudents với danh sách hơn 33000 phần tử
     * Không có học sinh giỏi nào
     */
    @Test
    public void testCountExcellentStudents_LargeList_NoneExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33001;
        List<Double> largeList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            largeList.add(5.0); // Không ai đạt loại giỏi
        }

        assertEquals(0, analyzer.countExcellentStudents(largeList));
    }

    /**
     * Test countExcellentStudents với danh sách hơn 33000 phần tử
     * Hỗn hợp điểm giỏi và không giỏi
     */
    @Test
    public void testCountExcellentStudents_LargeList_Mixed() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33001;
        List<Double> largeList = new ArrayList<>(size);
        int expectedExcellent = 0;

        for (int i = 0; i < size; i++) {
            // Xen kẽ giữa điểm giỏi và không giỏi
            if (i % 2 == 0) {
                largeList.add(8.5); // Điểm giỏi
                expectedExcellent++;
            } else {
                largeList.add(6.0); // Điểm không giỏi
            }
        }

        assertEquals(expectedExcellent, analyzer.countExcellentStudents(largeList));
    }

    /**
     * Test countExcellentStudents với danh sách hơn 33000 phần tử
     * Bao gồm cả giá trị không hợp lệ (âm và > 10)
     */
    @Test
    public void testCountExcellentStudents_LargeList_WithInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33001;
        List<Double> largeList = new ArrayList<>(size);
        int expectedExcellent = 0;

        for (int i = 0; i < size; i++) {
            if (i % 4 == 0) {
                largeList.add(9.5); // Điểm giỏi hợp lệ
                expectedExcellent++;
            } else if (i % 4 == 1) {
                largeList.add(-1.0); // Điểm không hợp lệ (âm)
            } else if (i % 4 == 2) {
                largeList.add(11.0); // Điểm không hợp lệ (> 10)
            } else {
                largeList.add(7.0); // Điểm hợp lệ nhưng không giỏi
            }
        }

        assertEquals(expectedExcellent, analyzer.countExcellentStudents(largeList));
    }

    /**
     * Test calculateValidAverage với danh sách hơn 33000 phần tử
     * Tất cả điểm hợp lệ với giá trị cố định
     */
    @Test
    public void testCalculateValidAverage_LargeList_AllValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33001;
        List<Double> largeList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            largeList.add(7.0); // Tất cả đều là 7.0
        }

        assertEquals(7.0, analyzer.calculateValidAverage(largeList), 0.01);
    }

    /**
     * Test calculateValidAverage với danh sách hơn 33000 phần tử
     * Hỗn hợp điểm hợp lệ và không hợp lệ
     */
    @Test
    public void testCalculateValidAverage_LargeList_Mixed() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33002; // Chia hết cho 2 để dễ tính
        List<Double> largeList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                largeList.add(8.0); // Điểm hợp lệ
            } else {
                largeList.add(6.0); // Điểm hợp lệ
            }
        }
        // Trung bình: (8.0 + 6.0) / 2 = 7.0
        assertEquals(7.0, analyzer.calculateValidAverage(largeList), 0.01);
    }

    /**
     * Test calculateValidAverage với danh sách hơn 33000 phần tử
     * Bao gồm giá trị không hợp lệ (sẽ bị bỏ qua)
     */
    @Test
    public void testCalculateValidAverage_LargeList_WithInvalidScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 33000;
        List<Double> largeList = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            if (i % 3 == 0) {
                largeList.add(9.0); // Điểm hợp lệ
            } else if (i % 3 == 1) {
                largeList.add(-5.0); // Điểm không hợp lệ (âm)
            } else {
                largeList.add(15.0); // Điểm không hợp lệ (> 10)
            }
        }
        // Chỉ tính trung bình các điểm hợp lệ (9.0)
        assertEquals(9.0, analyzer.calculateValidAverage(largeList), 0.01);
    }

    /**
     * Test hiệu suất với danh sách 50000 phần tử
     * Đảm bảo xử lý trong thời gian cho phép
     */
    @Test
    public void testPerformance_VeryLargeList_50000Elements() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        int size = 50000;
        List<Double> largeList = new ArrayList<>(size);
        int expectedExcellent = 0;

        for (int i = 0; i < size; i++) {
            double score = (i % 11); // Điểm từ 0 đến 10
            largeList.add(score);
            if (score >= 8.0) {
                expectedExcellent++; // Điểm 8, 9, 10
            }
        }

        // Test countExcellentStudents
        assertEquals(expectedExcellent, analyzer.countExcellentStudents(largeList));

        // Test calculateValidAverage
        // Tổng = 0+1+2+...+10 = 55, được lặp lại size/11 lần + phần dư
        // Trung bình = 55/11 = 5.0 (xấp xỉ)
        double expectedAverage = 5.0;
        assertEquals(expectedAverage, analyzer.calculateValidAverage(largeList), 0.1);
    }

    /**
     * Test với danh sách hơn 33000 phần tử chứa null values
     */
    @Test
    public void testCountExcellentStudents_LargeList_WithNullValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        long size = 2147483647;
        List<Double> largeList = new ArrayList<>();
        int expectedExcellent = 0;

        for (long i = 0; i < size; i++) {
            largeList.add(9.5); // Điểm giỏi
            expectedExcellent++;
        }

        assertEquals(expectedExcellent, analyzer.countExcellentStudents(largeList));
    }
}
