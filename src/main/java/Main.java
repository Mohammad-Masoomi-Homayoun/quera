import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve('A', 'B', 'C', n);
    }

    int count = 1;
    public void solve(char from, char to, char help, int n) {


        if(n == 1) {
            System.out.println(String.format("%d %c %c", count++, from, to));
            return;
        }

        solve(from, help, to, n-1);

        System.out.println(String.format("%d %c %c", count++, from, to));

        solve(help, to, from, n-1);

    }
}