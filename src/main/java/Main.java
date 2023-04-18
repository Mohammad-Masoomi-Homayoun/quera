import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[][] questions = new int[q][2];
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            questions[i][0] = x;
            questions[i][1] = y;
        }

        long[] result = solve(n, arr, q, questions);
        for(int i=0; i<result.length; i++)
            System.out.println(result[i]);
    }

    public long[] solve(int n, int[] arr, int q, int[][] questions) {

        long[] result = new long[q];
        int upper = (int) log2(n) + 1;
        int rmq[][] = new int[upper][n];

        for(int i=0; i<n; i++) {
            rmq[0][i] = arr[i];
        }

        for(int k=1; k<upper; k++) {
            int bound = (int) Math.pow(2, k-1);
            for (int i = 0; i < n; i++) {
                if(i + bound < n)
                    rmq[k][i] = Math.min(rmq[k-1][i], rmq[k-1][i+bound]);
                else
                    rmq[k][i] = rmq[k-1][i];
            }
        }

        for (int i = 0; i < q; i++) {
            int l = questions[i][0];
            int r = questions[i][1];
            int t = (int) Math.floor(log2(r-l));
            result[i] = Math.min(rmq[t][l], rmq[t][r - (int) Math.pow(2, t) + 1]);
        }

        return result;
    }


    public long log2(long n) {
        if(n == 0)
            return 0;
        return (long)(Math.log(n) / Math.log(2));
    }


}