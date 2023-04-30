import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long k = in.nextLong();

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextLong();
            arr[i][1] = in.nextLong();
        }

        System.out.println(solve(n, k, arr));
    }

    public long solve(int n, long k, long[][] arr) {


        mergeSort(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            long a = arr[i][0];
            long b = arr[i][1];
            if (k - a >= 0 && b > a) {
                k -= a;
                k += b;
            }
        }
        return k;
    }

    public void mergeSort(long[][] arr, int l, int r) {
        if(l<r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l , m, r);
        }
    }

    private void merge(long[][] arr, int l,int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        long[][] L = new long[n1][2];
        long[][] R = new long[n2][2];

        for (int i = 0; i < n1; ++i) {
            L[i][0] = arr[l + i][0];
            L[i][1] = arr[l + i][1];
        }

        for (int i = 0; i < n2; ++i) {
            R[i][0] = arr[m + i + 1][0];
            R[i][1] = arr[m + i + 1][1];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if(L[i][0] <= R[j][0]) {
                arr[k][0] = L[i][0];
                arr[k][1] = L[i][1];
                i++;
            } else {
                arr[k][0] = R[j][0];
                arr[k][1] = R[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k][0] = L[i][0];
            arr[k][1] = L[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k][0] = R[j][0];
            arr[k][1] = R[j][1];
            j++;
            k++;
        }

    }


    private void quickSort(long[][] arr, int begin, int end) {

        if(begin< end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(long[][] arr, int begin, int end) {
        long pivot = arr[end][0];
        int i = begin -1;
        for (int j = begin; j < end; j++) {
            if(arr[j][0] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, end);
        return i+1;
    }

    private void swap(long[][] arr, int i, int j) {
        long a = arr[i][0];
        long b = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = a;
        arr[j][1] = b;
    }


}