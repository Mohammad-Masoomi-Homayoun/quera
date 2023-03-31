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
        int m = in.nextInt();

        int from = in.nextInt();
        int to = in.nextInt();

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int fromPoint = in.nextInt();
            int toPoint = in.nextInt();
            Node a = get(fromPoint, nodes);
            Node b = get(toPoint, nodes);
            a.neighbors.add(b);
            b.neighbors.add(a);
        }

        solve(from, to, nodes);
    }

    private boolean found = false;
    private StringBuilder foundPath = new StringBuilder();
    private int pathCount = 0;
    public String solve(int from, int to, Map<Integer, Node> nodes) {

        Node fromNode = get(from, nodes);
        fromNode.mark = true;
        Node toNode = get(to, nodes);
        Queue<Node> nodesQueue = new ArrayDeque<>();
        nodesQueue.add(fromNode);
        found = false;
        BFSsearch(nodesQueue, toNode);
        if(found) {
            System.out.println(pathCount);
            System.out.println(foundPath);
            return foundPath.toString();
        }
        System.out.println("-1");
        return "-1";
    }

    public void BFSsearch(Queue<Node> nodesQueue, Node goal) {

        while (nodesQueue.size() > 0) {
            Node current = nodesQueue.remove();
            if(current.no == goal.no) {
                found = true;
                Node way = current;
                while(way.parent != null) {
                    foundPath.insert(0, way.no);
                    foundPath.insert(0, " ");
                    pathCount ++;
                    way = way.parent;
                }
                foundPath.insert(0, way.no);
                return;
            }

            for (Node node : current.neighbors) {
                if(node.mark)
                    continue;
                node.parent = current;
                node.mark = true;
                nodesQueue.add(node);
            }

        }
    }

    Node get(int no, Map<Integer, Node> nodes) {
        if (nodes == null)
            return null;
        Node node = nodes.get(no);
        if(node == null) {
            node = new Node(no);
            nodes.put(no, node);
        }
        return node;
    }

    class Node {
        int no = 0;
        List<Node> neighbors = new ArrayList<>();
        boolean mark = false;
        Node parent = null;

        public Node(int no) {
            this.no = no;
        }
    }

}