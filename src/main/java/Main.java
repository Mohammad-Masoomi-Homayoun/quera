import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = solve(n);
        System.out.println(result);
    }

    public int solve(int n) {

        int count = 0;
        for (int a = 1;  a < n; a++) {
            for(int b=a; b <=n-a ; b++) {
                int c = n - a - b;
                if(a + b > c && c >=b) {
                    count++;
                }
            }
        }

        return count;
    }
}