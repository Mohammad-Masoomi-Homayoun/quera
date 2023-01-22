
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++)
            arr[i] = in.nextLine();

        int q = Integer.parseInt(in.nextLine());
        String[] days = new String[q];
        for(int i=0; i<q; i++)
            days[i] = in.nextLine();
        System.out.println(solve(n, arr, q, days));
    }

    public int solve(int n, String[] arr, int q, String[] days) {

        int steps = 0;

        String currentOrgan = findLatestOccurence(0, q, new ArrayList<>(Arrays.asList(arr)), days);
        for(int i=0; i<q; i++) {
            if(days[i].equalsIgnoreCase(currentOrgan))  {
                steps++;
                currentOrgan = findLatestOccurence(i, q, new ArrayList<>(Arrays.asList(arr)), days);
            }
        }
        return steps;
    }

    private String findLatestOccurence(int current, int q, List<String> orgs, String[] days) {

        String lateOccurredOrgan = "";
        for(int i=current; i<q; i++) {
            if(orgs.contains(days[i])) {
                orgs.remove(days[i]);
                if(orgs.size() <2) {
                    lateOccurredOrgan = orgs.get(0);
                    break;
                }
            }
        }
        return lateOccurredOrgan;
    }

}