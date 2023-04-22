
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

        int n = 5;
        int[] arr = new int[]{ 1, 3, 1, 2,3};

        assertEquals(3, solution.solve(n, arr));

        n = 7;
        arr = new int[]{5 ,7 ,3 ,3 ,7 ,5 ,3};
        assertEquals(7, solution.solve(n, arr));

    }
}
