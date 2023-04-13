
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


        int q = 3;
        int[] arr = new int [1000_000]; //{1000_000 ,1000_000, 1000_000, 1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,1000_000 ,1000_000, 1000_000,};
        for(int i = 0; i<1000_000; i++)
            arr[i] = 1000_000;
        int[][] questions = new int [][]{{0,999999},{1,1},{2,2}};
        long[] result = new long[]{1000000000000l ,1000_000, 1000_000};

        assertArrayEquals(result, solution.solve(1000_000, arr, q, questions));

    }
}
