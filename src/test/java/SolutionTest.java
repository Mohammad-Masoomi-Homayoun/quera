
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
        long max = Long.MAX_VALUE;
        assertEquals( 7, solution.solve(4, 4, new long[][]{{1,1,9,1},{9,1,9,9},{1,1,1,9},{1,1,1,1}}));
        assertEquals( 10, solution.solve(5, 4, new long[][]{{1,1,9,1},{9,1,9,9},{1,1,1,9},{1,9,9,9},{1,1,1,1}}));
        assertEquals( 1, solution.solve(1, 1, new long[][]{{1}}));
    }
}
