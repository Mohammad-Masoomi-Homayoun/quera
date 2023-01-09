import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        long x = in.nextLong();
        long[] arr = new long[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextLong();
        }
        long result = solve(n, arr);
        System.out.println(result);

    }

    public long solve(int n, long[] arr) {

        long remain = 0;
        long maxsum = arr[0];

        long ans = arr[0];
        for(int i=1; i<=n; i++) {
            maxsum = max(arr[i], arr[i] + maxsum);
            ans = max(ans, maxsum);
        }
        return remain;
    }

    public long max(long a, long b) {
        if(a >= b)
            return a;
        return b;
    }

}