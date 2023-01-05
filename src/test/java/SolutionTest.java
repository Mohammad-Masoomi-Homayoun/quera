
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    private static Main solution;

    @BeforeAll
    public static void setUp() {
        solution = new Main();
    }

    @Test
    @DisplayName("test solution")
    public void test() {
        assertEquals(2, solution.solve(1, new long[]{1, 3, 5}));
        assertEquals(8, solution.solve(3, new long[]{1, 2, 3, 4}));
        assertEquals(505, solution.solve(10, new long[]{-93, -73, 23, 43 ,91, -70, 96, 78, -21}));
    }
}
