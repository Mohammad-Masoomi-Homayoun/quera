import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextLong();
        long[] arr = new long[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = in.nextLong();
        }
        long result = solve(n, x, arr);
        System.out.println(result);

    }

    public long solve(int n, long x, long[] arr) {

        long remain = 0;
        long mod = 1000_000_000 + 7;

        for(int i=n; i>=0; i--) {
            remain = (remain * x + arr[i]) % mod;
        }

        if(remain < 0)
            return remain + mod;
        return remain;
    }

}