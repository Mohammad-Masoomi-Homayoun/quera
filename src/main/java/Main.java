
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = in.nextInt();

        System.out.println(solve(n, k, arr));
        in.close();
    }

    public int solve(int n, int k, int[] arr) {

        if(k == 1)
            return Arrays.stream(arr).max().getAsInt();

        if(k > 2)
            return Arrays.stream(arr).min().getAsInt();

        int min = Integer.MAX_VALUE;

        for(int i=1; i< arr.length ; i++) {
            int[] sub1 = sub(0, i, arr);
            int[] sub2 = sub(i, arr.length, arr);
            int tmp = min(max(sub1), max(sub2));
            if(tmp < min)
                min = tmp;
        }
       return min;

    }

    public int[] sub(int start, int end, int[] arr) {
        int[] res = new int[end-start];
        for(int i=0; end > start; i++, start++) {
            res[i] = arr[start];
        }
        return res;
    }

    public int max(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    public int min (int a, int b) {
        if(a<b)
            return a;
        return b;
    }

}