
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class SolutionTest {

    private static Main solution;

    @BeforeAll
    public static void setUp() {
        solution = new Main();
    }

    @Test
    @DisplayName("test solution")
    public void test() {

        int n = 7;
        int q = 3;
        int[] arr = new int[]{2, 1, 5, 4, 10, 2, 0};
        int[][] questions = new int [][]{{0,6},{2,4},{4,4}};
        long[] result = new long[]{0, 4, 10};

        assertArrayEquals(result, solution.solve(n, arr, q, questions));

    }
}
