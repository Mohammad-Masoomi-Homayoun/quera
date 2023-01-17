
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
        for(int i=0; i<n; i++)
            arr[i] = in.nextLong();

        System.out.println(solve(n, arr));
    }

    public long solve(int n, long[] arr) {

        long arrSum = Arrays.stream(arr).sum();

        long min = Long.MAX_VALUE;
        for(int mask=1; mask< (1<<n) ; mask++) {
            long sum = 0;
            for(int j=0; j<n; j++) {
                if((mask & (1<<j)) != 0)
                   sum +=arr[j];
            }
            long res = Math.abs(arrSum - 2*sum);
            if(res < min)
                min = res;
        }
       return min;
    }

}