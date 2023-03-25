
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

        String[] result = new String[]{"2 3", "5 6", "4 7", "1 8"};
//        assertArrayEquals(result, solution.solve("(()(()))"));
        assertNull(solution.solve("()(())((()((((()(()))(((()))(()))())((((()))()))"));

    }
}
