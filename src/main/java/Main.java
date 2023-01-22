
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        System.out.println(solve(n));
    }

    public long solve(int n) {

        long mod = 1_000_000_007;

        long[] fib = new long[n+1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i=2; i<=n; i++)
            fib[i] = (fib[i-1] + fib[i-2]) % mod;
        return fib[n];
    }
}