import java.util.ArrayList;
import java.util.List;

public class Node {
    int value = -1;
    List<Node> neighbors = new ArrayList<>();
    boolean mark = false;
    boolean hasFriend = false;
    int length = 0;
    public Node(int value) {
        this.value = value;
    }
}