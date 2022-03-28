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

        int[] array = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        long startTime = System.currentTimeMillis();
        String result = solve(array);
        System.out.println(result);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time: "+ (endTime-startTime));
    }

    public String solve(int[] array) {

        int rampCount = 0;
        int rampValue = 0;
        for (int i = 1; i < array.length; i++) {
            int newRampValue = array[i] - array[i-1];
            if (rampValue * newRampValue < 0) {
                rampCount++;
                newRampValue = 0;
            }
            rampValue = newRampValue;
        }

        return rampCount == 2 ? "YES" : "NO";
    }
}