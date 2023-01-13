import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
    }

    public void solve(int n) {
        gray(n).forEach(str -> System.out.println(str));
    }

    public List<String> gray(int length) {

        if(length == 0) {
            List<String> start = new ArrayList<>();
            start.add("");
            return start;
        }

        List<String> s1 = gray(length -1);
        List<String> s2 = new ArrayList<>(s1);
        Collections.reverse(s2);

        for(int i=0; i<s1.size(); i++)
            s1.set(i, "0"+s1.get(i));
        for(int i=0; i<s2.size(); i++)
            s2.set(i, "1"+s2.get(i));

        s1.addAll(s2);
        return s1;
    }

}