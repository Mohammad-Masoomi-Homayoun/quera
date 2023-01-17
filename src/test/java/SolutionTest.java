
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
        assertEquals( 3, solution.solve(3, 2, new int[]{3, 2, 3}));
        assertEquals( 2, solution.solve(6, 2, new int[]{3, 2, 3, 1, 2,2}));
        assertEquals( 1, solution.solve(10, 2, new int[]{1, 2, 3,4,4,4,4,1,2,3}));
        assertEquals( 1, solution.solve(5, 2, new int[]{3, 2, 3, 1, 1}));
        assertEquals( 2, solution.solve(5, 3, new int[]{5, 4, 3, 2, 2}));
        assertEquals( 4, solution.solve(4, 1, new int[]{1, 3, 4, 2}));
    }
}
