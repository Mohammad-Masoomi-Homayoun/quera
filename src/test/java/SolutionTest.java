import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Main solution;

    @Before
    public void setUp() {
        solution = new Main();
    }

    @Test
    public void test() {
        assertEquals(1, solution.solve(5));
        assertEquals(3, solution.solve(12));
    }
}
