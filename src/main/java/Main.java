import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[] arr = new long[n];
        for(int i=0; i < n; i++)
            arr[i] = in.nextLong();
        long result = solve(k, arr);
        System.out.println(result);

    }

    public long solve(long k,long[] arr) {

        long M = 0;
        int length = arr.length;
        long[] b = new long[length];

        for(int i=0; i<length; i++)
            b[i] = arr[i] - (((long)i) *k);
        Arrays.sort(b);
        if(length % 2 ==0) {
            M = b[(length / 2)-1];
        } else {
            M = b[((length+1) / 2)-1];
        }
        long cost = 0;
        for(int i=0; i<length; i++)
            cost += Math.abs(b[i]-M);

        return cost;
    }
}