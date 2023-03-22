
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

        int[][] unsolved = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        int[][] expected = new int[][]{{3, 1, 6, 5, 7, 8, 4, 9, 2},
                {5, 2, 9, 1, 3, 4, 7, 6, 8},
                {4, 8, 7, 6, 2, 9, 5, 3, 1},
                {2, 6, 3, 4, 1, 5, 9, 8, 7},
                {9, 7, 4, 8, 6, 3, 1, 2, 5},
                {8, 5, 1, 7, 9, 2, 6, 4, 3},
                {1, 3, 8, 9, 4, 7, 2, 5, 6},
                {6, 9, 2, 3, 5, 1, 8, 7, 4},
                {7, 4, 5, 2, 8, 6, 3, 1, 9}};
        assertArrayEquals(expected, solution.solve(unsolved));

        unsolved = new int[][]{{4, 0, 0, 5, 0, 2, 9, 0, 8},
                {9, 0, 1, 0, 8, 7, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 4, 2, 0, 9, 8, 0, 0},
                {0, 0, 2, 1, 5, 4, 3, 9, 0},
                {0, 0, 9, 0, 6, 3, 0, 5, 2},
                {2, 4, 0, 0, 0, 0, 0, 8, 9},
                {1, 0, 0, 3, 7, 0, 0, 2, 0},
                {3, 9, 0, 4, 0, 5, 1, 0, 0}};
        assertEquals(null, solution.solve(unsolved));

    }
}
