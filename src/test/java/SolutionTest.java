
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

        String[] arr = new String[]{"insert h", "-", "-", "insert a",  "+", "+", "+", "+", "insert h"};

        assertEquals("ahh", solution.solve(9, arr));

    }
}
