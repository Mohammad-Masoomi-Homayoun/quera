import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() throws IOException {

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("input10.txt");
//        Scanner in = new Scanner(is);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Node> nodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Node node = new Node(x, y);
            findAndSetNeighbors(node, nodes);
            nodes.put(x+"-"+y, node);
        }

        System.out.println(solve(nodes));
    }

    private void findAndSetNeighbors(Node current, Map<String, Node> nodes) {
        for(Node node : nodes.values()) {
            if(current.x == node.x || current.y == node.y) {
                current.neighbors.add(node);
                node.neighbors.add(current);
            }
        }
    }

    public int solve(Map<String, Node> nodes) {

        int countOfElements = 0;

        Node firstUnmark = null;
        while ((firstUnmark = getFirstUnmark(nodes)) != null ){
            countOfElements++;
            DFSsearch(firstUnmark);
        }
        return countOfElements-1;
    }

    private void DFSsearch(Node firstUnmark) {

        if(firstUnmark.mark)
            return;
        firstUnmark.mark = true;
        for(Node child : firstUnmark.neighbors) {
            DFSsearch(child);
        }
    }

    private Node getFirstUnmark(Map<String, Node> nodes) {
        for(Node node : nodes.values()) {
                if(!node.mark)
                    return node;
            }
        return null;
    }

    class Node {
        int x = -1;
        int y = -1;
        List<Node> neighbors = new ArrayList<>();
        boolean mark = false;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}