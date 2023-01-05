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
        arr[0] = in.nextLong();
        for(int i=1; i<n; i++) {
            int input = in.nextInt();
            insetSorted(i, input, arr);
        }
        String result = solve(n, arr);
        System.out.println(result);

    }

    private void insetSorted(int index, long input, long[] arr) {
        int i=index;
        while( i>0 && arr[i-1] > input) {
            arr[i] = arr[i-1];
            i--;
        }
        arr[i] = input;
    }

    public String solve(int n ,long[] arr) {

        long M = 0;
        if(n % 2 ==0) {
            M = arr[(n / 2)-1];
        } else {
            M = arr[((n+1) / 2)-1];
        }
        long cost = 0;
        for(int i=0; i<n; i++)
            cost += Math.abs(arr[i]-M);

        return M + " " + cost;
    }
}