import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);

    }

    public long solve(long n) {

        long triangleCount = 0;
        for(int a = 1; a <= n/3; a++) {
            triangleCount += ((n-(3*a))/2) - (max(0, ((n/2)-(2*a)+1))) + 1;
        }
        return triangleCount;
    }

    private long max(long a, long b) {
        if(a >= b)
            return a;
        return b;
    }
}