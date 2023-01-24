
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.nextLine());
        int[][] arr = new int[q][2];
        int maxN = -1, maxR = -1;
        for(int i=0; i<q; i++) {
            int n = in.nextInt();
            arr[i][0] = n;
            if(n > maxN)
               maxN = n;
            int r = in.nextInt();
            arr[i][1] = r;
            if(r > maxR)
                maxR = r;
        }
        long[][] resultTable = makeResultTable(maxN+1, maxR+1);
        Arrays.stream(solve(q ,resultTable, arr)).forEach(System.out::println);
    }

    public long[] solve(int q,long[][] resultTable, int[][] arr) {

        long[] result = new long[q];

        for(int i=0; i<q; i++) {
            result[i] = resultTable[arr[i][0]][arr[i][1]];
        }
        return result;
    }

    long[][] makeResultTable(int maxN, int maxR) {

        long mod = 1000_000_007;
        long[][] result = new long[maxN][maxR];
        for(int n = 0; n<maxN; n++) {
            for(int r=0; r<maxR; r++) {
                if(r==0) {
                    result[n][r] = 1;
                } else if(n == r) {
                    result[n][r] = 1;
                } else if(r > n) {
                    result[n][r] = 0;
                } else {
                    result[n][r] = (result[n - 1][r] + result[n - 1][r - 1]) % mod;
                    if (result[n][r] < 0)
                        result[n][r] += mod;
                }
            }
        }

        return result;
    }

}