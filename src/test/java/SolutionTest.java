
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertEquals( 1, solution.solve(3, new String[]{"KGB", "Central Intelligence Agency", "Central Intelligence Agency 2"},
                6, new String[]{"KGB", "Central Intelligence Agency", "Central Intelligence Agency", "Central Intelligence Agency 2",
                "Central Intelligence Agency 2", "KGB"}));
    }
}
