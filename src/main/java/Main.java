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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solve(n, arr));
    }

    public int solve(int n, int[] arr) {

        int result = 0;

        arr = Arrays.stream(arr).sorted().toArray();

        int currentTime = 1;
        for (int i = 0; i < n; i++) {
            if(currentTime <= arr[i] ) {
                result++;
                currentTime++;
            }
        }
        return result;
    }




}