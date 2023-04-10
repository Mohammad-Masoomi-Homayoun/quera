import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLine();
        }

        System.out.println(solve(n, arr));
    }

    public String solve(int n, String[] arr) {

        Node start = new Node("");
        Node current = start;
        for (int i = 0; i < n; i++) {
            if(isForward(arr[i])) {
                if(current.next != null)
                    current = current.next;
            } else if(isBackward(arr[i])) {
                if(current.previous != null)
                    current = current.previous;
            } else if(current != null) {
                Node tmp = new Node(extract(arr[i]));
                if (current.next != null) {
                    tmp.next = current.next;
                    current.next.previous = tmp;
                }
                current.next = tmp;
                tmp.previous = current;
                current = tmp;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (start != null) {
            stringBuilder.append(start.value);
            start = start.next;
        }
        return stringBuilder.toString();
    }

    private String extract(String s) {
        return s.charAt(s.length()-1)+"";
    }

    private boolean isBackward(String s) {
        return s.equals("-");
    }

    private boolean isForward(String s) {
        return s.equals("+");
    }

    class Node {
        String value;
        Node next;
        Node previous;
        public Node(String value) {
            this.value = value;
        }
    }

}