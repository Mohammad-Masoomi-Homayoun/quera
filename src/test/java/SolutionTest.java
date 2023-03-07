
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
        assertEquals( "ktan", solution.solve(new char[]{'k','a','t','a','n','a'}, new char[]{'y','e','k','t','a','n','e','h'}));
        assertEquals( "kmd", solution.solve(new char[]{'k','m','i','d'}, new char[]{'k','o','m','o','d'}));
        assertEquals( "abc", solution.solve(new char[]{'a','a','a','b','c'}, new char[]{'a','b','b','b','c'}));
        assertEquals( "ac", solution.solve(new char[]{'n','a','t','g','c'}, new char[]{'a','b','b','b','c'}));
        assertEquals( "a", solution.solve(new char[]{'n','a'}, new char[]{'a','b','b','b','c'}));

    }
}
