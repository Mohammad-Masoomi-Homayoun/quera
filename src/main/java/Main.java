

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {


//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("input10.txt");
//        Scanner in = new Scanner(is);

        Scanner in = new Scanner(System.in);
        String Sstr = in.nextLine();
        String Pstr = in.nextLine();
        char[] s = new char[Sstr.length()];
        char[] p = new char[Pstr.length()];

        for(int i=0; i<s.length; i++) {
            s[i] = Sstr.charAt(i);
        }

        for(int i=0; i<p.length; i++) {
            p[i] = Pstr.charAt(i);
        }

        System.out.println(solve(s, p));
    }

    public String solve(char[] s, char[] p) {

        int sLen = s.length + 1;
        int pLen = p.length + 1;
        int[][] dp = new int[pLen][sLen];
        char[][] dpLetters = new char[pLen][sLen]; // d: diagonal - u: up - l: left

        for(int i=1; i<pLen; i++) {
            for(int j=1; j<sLen; j++) {
                if(dp[i-1][j] >= dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j];
                    dpLetters[i][j] = 'u';
                } else {
                    dp[i][j] = dp[i][j-1];
                    dpLetters[i][j] = 'l';
                }
                if(p[i-1] == s[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    dpLetters[i][j] = 'd';
                }
            }
        }
        int i = pLen-1;
        int j = sLen-1;
        StringBuilder result = new StringBuilder();

        while (i>0 && j>0) {
            if(dpLetters[i][j] == 'd') {
                result.insert(0, s[j-1]);
                i -= 1;
                j -= 1;
            } else if(dpLetters[i][j] == 'l') {
                j -= 1;
            } else {
                i -=1;
            }
        }

        System.out.println(dp[pLen-1][sLen-1]);
        return result.toString();
    }
}