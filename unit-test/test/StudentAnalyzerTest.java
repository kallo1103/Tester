import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
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
}
