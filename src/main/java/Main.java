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
            questions[i][0] = in.nextInt();
            questions[i][1] = in.nextInt();
        }

        long[] result = solve(n, arr, q, questions);
        Arrays.stream(result).forEach(System.out::println);
    }

    public long[] solve(int n, int[] arr, int q, int[][] questions) {

        long[] sums = new long[n+1];
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + arr[i-1];
        }

        long[] result = new long[q];
        for (int i = 0; i < q; i++) {
            if(questions[i][1] == 1000000)
                System.out.println();
            result[i] = sums[questions[i][1]+1] - sums[questions[i][0]];
        }

        return result;
    }


}