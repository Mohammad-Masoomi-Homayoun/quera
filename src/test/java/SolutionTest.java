
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
    @DisplayName("test the solution")
    public void test() {

        int n = 4;
        long k = 1;
        long[][] arr = new long[][] {{1, 1},{0, 1},{4, 0},{5, 1}};

        assertEquals(2, solution.solve(n, k, arr));

//        solution.mergeSort(arr, 0, 3);
//        System.out.println("check result");

    }
}
