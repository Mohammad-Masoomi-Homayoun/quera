
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() throws FileNotFoundException {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input10.txt");
        Scanner in = new Scanner(inputStream);
        int n = in.nextInt();
        int s = in.nextInt();

        Input[] inputs = new Input[n+1];

        for(int i=0; i<n; i++) {
            int length = in.nextInt();
            List<Integer> weights = new ArrayList<>();
            for(int j=0; j<length; j++) {
                weights.add(in.nextInt());
            }
            inputs[i] = makeInput(length, weights);
        }
        inputs[n] = null;
        System.out.println(solve(n, s, inputs));
    }

    public String solve(int n, int s, Input[] inputs) {

        int[][] dp = new int[n+1][s+1];
        String[][] par = new String[n+1][s+1];
        int[] w = new int[n+1];

        for(int j=0; j<=n; j++) {
            w[j] = calculateWeight(s, inputs[j]);
        }
        for(int j=0; j<s; j++) {
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++) {
            int count = catchableCount(w[i-1], inputs[i-1]);
            for(int j=0; j<=s; j++) {
                dp[i][j] = dp[i - 1][j];
                par[i][j] = "0";
                if(j - w[i-1] >= 0 && dp[i - 1][j - w[i-1]] + count > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j - w[i-1]] + count;
                    par[i][j] = (count == inputs[i-1].length && inputs[i-1].length > 1) ? "2" : "1";
                }
            }

        }

        StringBuilder result = new StringBuilder();
        int remainS = s;
        for(int i=n; i>0; i--) {

            if(!par[i][remainS].equalsIgnoreCase("0")) {
                result.insert(0, par[i][remainS]);
                remainS -= w[i-1];
            } else {
                result.insert(0, par[i][remainS]);
            }
        }

        System.out.println(dp[n][s]);
        return result.toString();
    }

    private int calculateWeight(int s, Input input) {

        if(input == null)
            return 0;

        if(s >= input.sum())
            return input.sum();

        if(s >= input.min())
            return input.min();

        return 0;
    }

    private int catchableWeight(int s, Input input) {
        if(s >= input.sum())
            return input.sum();

        if(s >= input.min())
            return input.min();

        return 0;
    }

    private int catchableCount(int s, Input input) {

        if(input == null)
            return 0;

        if(s >= input.sum())
            return input.length;

        if(s >= input.min())
            return 1;

        return 0;
    }

    private String calculateCost(int s, Input input) {

        if(s >= input.sum())
            return "2";

        if(s >= input.min())
            return "1";

        return "0";
    }

    class Input {
        int length = 0;
        List<Integer> list = new ArrayList<>();

        public int sum() {
            return this.list.stream().mapToInt(i -> i.intValue()).sum();
        }

        public int min() {
            return this.list.stream().mapToInt(i ->i.intValue()).min().getAsInt();
        }


        public Input(int length, List<Integer> list) {
            this.length = length;
            this.list = list;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }
    }

    public Input makeInput(int i, List<Integer> integers) {
        return new Input(i, integers);
    }
}