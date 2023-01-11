import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long result = solve(a, b);
        System.out.println(result);

    }

    public long solve2(long a, long b) {

        if(a <=1 || b <= 1)
            return 1;

        if(a > b) {
            if(a%b == 0)
                return b;
            else
                return solve(b, a-b);
        } else {
            if(b%a == 0)
                return a;
            else
                return solve(a, b-a);
        }
    }

    public long solve(long a, long b) {

        if(b == 0)
            return 1;

        if(a%b == 0)
            return b;
        return solve2(b, a%b);
    }



}