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

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i+1;
        }

        for (int i = 0; i < q; i++) {
            int command = in.nextInt();
            if(command == 1) {
                int a = in.nextInt() -1;
                int b = in.nextInt() -1;
                pushElements(arr[a], arr[b]);
            } else if(command == 2) {
                int c = in.nextInt() -1;
                printLength(arr[c]);
            } else if(command == 3) {
                int d = in.nextInt() -1;
                printElements(arr[d]);
            }
        }
    }

    private void printElements(int[] d) {
        int[] tmp = d.clone();
        Arrays.sort(tmp);
        tmp = Arrays.stream(tmp).filter(x->x!=0).toArray();
        if(tmp.length == 0) {
            System.out.println("-1");
            return;
        }
        for( int i =0; i< tmp.length ; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
    }

    private void printLength(int[] c) {
        int counter = 0;
        while (counter < c.length && c[counter] != 0) {
            counter++;
        }
        System.out.println(counter);
    }

    private void pushElements(int[] a, int[] b) {
        int counter = 0;
        while (counter < b.length && b[counter] != 0) {
           counter++;
        }
        int startIndex = counter;
        counter = 0;
        while (counter < a.length && a[counter] != 0) {
            b[startIndex++] = a[counter];
            a[counter] = 0;
            counter++;
        }
    }

    public long[] solve(int n, int[] arr, int q, int[][] questions) {

        return new long[1];
    }


}