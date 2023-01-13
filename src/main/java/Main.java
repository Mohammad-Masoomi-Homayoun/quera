import java.io.OutputStream;
import java.io.PrintWriter;
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
        List<StringBuilder> result = dictionary(n, 0);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        for(StringBuilder sb: result)
            out.println(sb.toString());
        out.close();
    }

    private List<StringBuilder> dictionary(int n, int depth) {
        if(depth >= n) {
            List<StringBuilder> first = new ArrayList<>();
            first.add(new StringBuilder());
            return first;
        }

        depth++;
        List<StringBuilder> result = new ArrayList<>();
        int counter = 1;
        while(counter <= n) {
            List<StringBuilder> response = dictionary(n, depth);
            for(int j=0; j<response.size(); j++)
                response.set(j, response.get(j).insert(0, " ").insert(0, counter));
            result.addAll(response);
            counter++;
        }
        return result;
    }

}