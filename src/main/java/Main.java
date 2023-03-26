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
            a.getNeighbors().add(b);
            b.getNeighbors().add(a);
        }

        if(solve(from, to, nodes)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public boolean solve(int from, int to, Map<Integer, Node> nodes) {

        found = false;
        Node fromNode = get(from, nodes);
        Node toNode = get(to, nodes);
        DFSsearch(fromNode, toNode, nodes);
        return found;
    }

    boolean found = false;

    private void DFSsearch(Node current, Node goal, Map<Integer, Node> nodes) {
        if(current.getNo() == goal.getNo()) {
            found = true;
            return;
        }

        if(current.mark)
            return;

        current.mark = true;

        for(Node node : current.getNeighbors()) {
            DFSsearch(node, goal, nodes);
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
        int no;
        List<Node> neighbors = new ArrayList<>();
        boolean mark;

        public Node(int no) {
            this.no = no;
        }

        public Node(int no, List<Node> neighbors) {
            this.no = no;
            this.neighbors.addAll(neighbors);
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public List<Node> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Node> neighbors) {
            this.neighbors = neighbors;
        }

        public boolean isMark() {
            return mark;
        }

        public void setMark(boolean mark) {
            this.mark = mark;
        }
    }

}