
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    private static Main solution;

    @BeforeAll
    public static void setUp() {
        solution = new Main();
    }

    @Test
    @DisplayName("test solution")
    public void test() {
        assertArrayEquals(new long[]{1, 2, 2, 2, 3, 4, 5, 7, 9, 12}, solution.solve(10, new long[]{2, 1, 7, 12, 3, 4, 5, 2, 2, 9}));
        assertArrayEquals(new long[]{1, 2, 3}, solution.solve(3, new long[]{3, 2, 1}));
    }
}
