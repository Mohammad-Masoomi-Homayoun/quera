
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        long[][] arr = new long[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = in.nextLong();
            }
        }
        System.out.println(solve(n, m, arr));
    }

    public long solve(int n, int m, long[][] arr) {

        long max = Long.MAX_VALUE;
        long[][][] dp = new long[n][m][2];

        for(int i=0; i<n; i++) {
            for(int j=m-1; j>=0; j--) {
                if(i==0 && j==0) {
                    dp[i][j][0] = arr[i][j];
                } else if(i==0) {
                    dp[i][j][0] = max;
                } else if(j==0) {
                    dp[i][j][0] = min(dp[i-1][j][1], dp[i-1][j][0],dp[i][j+1][0]) + arr[i][j];
                } else if(j+1==m) {
                    dp[i][j][0] = min(dp[i-1][j][1], dp[i-1][j][0],max) + arr[i][j];
                } else
                    dp[i][j][0] = min(dp[i - 1][j][1], dp[i - 1][j][0], dp[i][j + 1][0]) + arr[i][j];
            }
            for(int j=0; j<m; j++) {
                if(i==0 && j==0) {
                    dp[i][j][1] = arr[i][j];
                } else if(i==0) {
                    dp[i][j][1] = dp[i][j-1][1] + arr[i][j];
                } else if(j==0) {
                    dp[i][j][1] = min(dp[i-1][j][1], dp[i-1][j][0],max) + arr[i][j];
                } else if(j+1==m) {
                    dp[i][j][1] = min(dp[i-1][j][1], dp[i-1][j][0],dp[i][j-1][1]) + arr[i][j];
                } else
                    dp[i][j][1] = min(dp[i - 1][j][1], dp[i - 1][j][0], dp[i][j - 1][1]) + arr[i][j];
            }
        }

        return dp[n-1][m-1][1];
    }

    private long min(long a, long b, long c) {
        if(a <= b && a <= c) {
            return a;
        } else if(b<= a && b <=c) {
            return b;
        }
        return c;
    }
}