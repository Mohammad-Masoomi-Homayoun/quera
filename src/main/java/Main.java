import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] lineArray = line.split(" ");

        int n = Integer.parseInt(lineArray[0]);
        int k = Integer.parseInt(lineArray[1]);

        int[] array = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        long startTime = System.currentTimeMillis();
        int result = solve(k, array);
        System.out.println(result);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time: "+ (endTime-startTime));
    }

    public int solve(int k, int[] array) {
        int max = 50000000;
        int[] result = new int[2 * max + 1];
        int cost;
        for (int a0 = -max; a0 <= max; a0++) {
            cost = 0;
            for (int i = 1; i <= array.length; i++) {
                cost += Math.abs(a0 + (i - 1) * k - array[i - 1]);
            }
            result[a0 + max] = cost;
        }
        return Arrays.stream(result).min().getAsInt();
    }
}