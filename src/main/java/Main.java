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
        Map<Integer, Node> nodes = new HashMap<>();

        int n = in.nextInt();

        for (int i = 0; i < n-1; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            Node fromNode = get(from, nodes);
            Node toNode = get(to, nodes);
            setNeighbors(fromNode, toNode, nodes);
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int hasFriend = in.nextInt();
            nodes.get(hasFriend).hasFriend = true;
        }

        solve(nodes);
    }

    public Node get(int value, Map<Integer, Node> nodes) {
        Node node = nodes.get(value);
        if(node == null) {
            node = new Node(value);
            nodes.put(value, node);
        }
        return node;
    }

    private void setNeighbors(Node node1, Node node2, Map<Integer, Node> nodes) {
        nodes.get(node1.value).neighbors.add(node2);
        nodes.get(node2.value).neighbors.add(node1);
    }

    public int solve(Map<Integer, Node> nodes) {


        Node first = nodes.get(1);
        DFS(first, 1);
        friends.sort((n1, n2) -> (n1.value < n2.value ? -1 : 1));
        friends.sort((n1, n2) -> (n1.length < n2.length ? -1 : 1));
        System.out.println(friends.get(0).value);
        return friends.get(0).value;
//        Queue<Node> nodesQueue = new ArrayDeque<>();
//        nodesQueue.add(nodes.get(1));
//
//        Node friend = BFSsearch(nodesQueue);
//        if(friend != null) {
//            System.out.println(friend.value);
//            return friend.value;
//        }
//        return -1;
    }

    private Node BFSsearch(Queue<Node> nodeQueue) {

        Node friend = null;

        while(nodeQueue.size() > 0) {
            Node current = nodeQueue.poll();
            if(current.hasFriend)  {
                if(friend == null) friend = current;
                if(current.value < friend.value) friend = current;
            }
            if(current.mark) continue;
            current.mark = true;
            for(Node neighbor : current.neighbors)
                nodeQueue.add(neighbor);
        }
        return friend;
    }

    List<Node> friends = new ArrayList<>();

    public void DFS(Node current, int depth) {

        if(current.mark) return;
        if(current.hasFriend)  {
            current.length = depth;
            friends.add(current);
        }
        current.mark = true;
        depth += 1;
        for(Node neighbor : current.neighbors)
            DFS(neighbor, depth);

    }

    class Node {
        int value = -1;
        List<Node> neighbors = new ArrayList<>();
        boolean mark = false;
        boolean hasFriend = false;
        int length = 0;
        public Node(int value) {
            this.value = value;
        }
    }

}