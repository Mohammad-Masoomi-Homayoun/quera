
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Main.Input[] inputs = new Main.Input[4];
        inputs[0] = solution.makeInput(1, Arrays.asList(100));
        inputs[1] = solution.makeInput(3, Arrays.asList(1,2,3));
        inputs[2] = solution.makeInput(2, Arrays.asList(2,10));
        inputs[3] = null;
        assertEquals( "021", solution.solve(3, 11, inputs));

        inputs = new Main.Input[4];
        inputs[0] = solution.makeInput(3, Arrays.asList(1,1,1));
        inputs[1] = solution.makeInput(3, Arrays.asList(1,1,1));
        inputs[2] = solution.makeInput(3, Arrays.asList(1,1,1));
        inputs[3] = null;
        assertEquals( "200", solution.solve(3, 3, inputs));

        inputs = new Main.Input[4];
        inputs[0] = solution.makeInput(1, Arrays.asList(12));
        inputs[1] = solution.makeInput(1, Arrays.asList(12));
        inputs[2] = solution.makeInput(1, Arrays.asList(12));
        inputs[3] = null;
        assertEquals( "000", solution.solve(3, 11, inputs));

        inputs = new Main.Input[4];
        inputs[0] = solution.makeInput(3, Arrays.asList(1, 19, 10));
        inputs[1] = solution.makeInput(6, Arrays.asList(1,1,1,1,1,1));
        inputs[2] = solution.makeInput(1, Arrays.asList(12));
        inputs[3] = null;
        assertEquals( "020", solution.solve(3, 6, inputs));

        inputs = new Main.Input[4];
        inputs[0] = solution.makeInput(3, Arrays.asList(1, 19, 10));
        inputs[1] = solution.makeInput(4, Arrays.asList(1,1,1,1));
        inputs[2] = solution.makeInput(6, Arrays.asList(1,1,1,1,1,1));
        inputs[3] = null;
        assertEquals( "002", solution.solve(3, 6, inputs));
    }
}
