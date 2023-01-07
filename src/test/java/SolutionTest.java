
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
        assertEquals(4, solution.solve(6, new long[]{-7, 3, -1, 2, -4, 3}));
        assertEquals(-1, solution.solve(3, new long[]{-1, -2, -3}));

    }
}
