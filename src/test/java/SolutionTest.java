
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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

//        Map<String, Node> nodes = new HashMap<>();
//        Node node1 = new Node(1, 1);
//        Node node2 = new Node(3, 1);
//        Node node3 = new Node(3, 3);
//        Node node4 = new Node(1, 3);
//        node1.neighbors.addAll(Arrays.asList(node4, node2));
//        node2.neighbors.addAll(Arrays.asList(node1, node3));
//        node3.neighbors.addAll(Arrays.asList(node2, node4));
//        node4.neighbors.addAll(Arrays.asList(node1, node3));
//
//        nodes.put("1-1", node1);
//        nodes.put("3-1", node1);
//        nodes.put("3-3", node1);
//        nodes.put("1-3", node1);
//
//        assertEquals(0, solution.solve(nodes));

    }
}
