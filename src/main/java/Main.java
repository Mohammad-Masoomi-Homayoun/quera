import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for(int i=0; i < n; i++)
            arr[i] = in.nextLong();
        long result = solve(n, arr);
        System.out.println(result);

    }

    public long solve(long n,long[] arr) {

        long max = -1 * Long.MAX_VALUE;

        int l, r;

        long sum = 0;
        for(r=0; r<n; r++) {
            for(l=0; l<=r; l++) {
                for(int j =l; j<=r; j++) {
                    sum += arr[j];
                }
                if(sum > max) {
                    max = sum;
                }
                sum =0;
            }
        }

        return max;
    }
}