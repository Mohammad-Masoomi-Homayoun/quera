
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

        Map<Integer, Node> nodes = new HashMap<>();
        Node node1 = new Node( 1);
        Node node2 = new Node( 2);
        Node node3 = new Node( 3);
        node3.hasFriend = true;
        Node node4 = new Node(4);
        node4.hasFriend = true;
        Node node5 = new Node(5);
        node5.hasFriend = true;
        Node node6 = new Node(6);
        node6.hasFriend = true;
        node1.neighbors.addAll(Arrays.asList(node4,node3, node2));
        node2.neighbors.addAll(Arrays.asList(node5, node6));

        nodes.put(1, node1);
        nodes.put(2, node2);
        nodes.put(3, node3);
        nodes.put(4, node4);
        nodes.put(5, node5);
        nodes.put(6, node6);

        assertEquals(3, solution.solve(nodes));

    }
}
