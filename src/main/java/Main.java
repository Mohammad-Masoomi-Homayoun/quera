

import java.io.FileNotFoundException;
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
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solve(n, k));
    }

    public int solve(int n, int k) {

        result = 0;
        permute("", n, k);
        return result;
    }

    int result = 0;

    private void permute(String perm, int n, int k) {

        if(perm.length() > n)
            return;

        if(hasDuplicated(perm) || hasMoreThanKMisplace(perm, k))
            return;

        if(perm.length() == n) {
            if(hasKMisplace(perm, k)) {
                result++;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            permute(perm + "" + i, n, k);
        }
        return;
    }

    private boolean hasMoreThanKMisplace(String perm, int k) {
        return countMisplace(perm) > k;
    }

    private boolean hasKMisplace(String perm, int k) {
        return countMisplace(perm) == k;
    }

    private int countMisplace(String perm) {

        if(perm.length() < 2)
            return 0;

        int[] members = new int[perm.length()];
        for(int i=0; i<perm.length(); i++) {
            members[i] = Integer.parseInt(perm.charAt(i)+"");
        }

        int count = 0;
        for(int i=0; i<perm.length(); i++) {
            for(int j=i+1; j<perm.length(); j++) {
                if(members[i] > members[j])
                    count++;
            }
        }
        return count;
    }

    private boolean hasDuplicated(String perm) {
        return perm.codePoints().distinct().count() != perm.length();
    }
}