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
        assertEquals(2, solution.solve(1, new int[]{1,3,5}));
    }
}
