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
        for(int i=0; i<n; i++) {
            arr[i] = in.nextLong();
        }
        long[] result = solve(n, arr);
        for(int i=0; i<n; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public long[] solve(int n, long[] arr) {

        for(int i=0; i<n; i++) {
            int minIndex = i;
            for(int j = i; j<n; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

    public void swap(long[] arr, int minIndex, int i) {
        long temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

}