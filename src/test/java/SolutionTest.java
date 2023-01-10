
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
        assertEquals( 11, solution.solve(2, 5, new long[]{1, -3, 1}));
        assertEquals( 17, solution.solve(2, 2, new long[]{1, 2, 3}));
        assertEquals( 1000000005, solution.solve(1, -5, new long[]{-2, 0}));
    }
}
