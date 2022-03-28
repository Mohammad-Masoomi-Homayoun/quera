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
        assertEquals("YES", solution.solve(new int[]{5, 2, 3, 4, 1}));
        assertEquals("NO", solution.solve( new int[]{1,2,4,5,3}));
    }
}
