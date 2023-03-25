import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        solution.readAndSolve();
    }

    public void readAndSolve() throws IOException {

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("input10.txt");
//        Scanner in = new Scanner(is);

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] solved = solve(input);

        if(solved == null) {
            System.out.println("-1");
            return;
        }
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter writer = new BufferedWriter(out);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i<solved.length; i++) {
            stringBuilder.append(solved[i] + "\n");
        }
        writer.write(stringBuilder.toString());
        writer.flush();
    }

    public String[] solve(String input) {
        if(input == null || input.length() < 2 || input.startsWith(")") || input.length() % 2 != 0)
            return null;

        String[] result = new String[input.length() / 2];
        Stack<Integer> myStack = new Stack<>();
        int counter = 0;

        for(int i=0; i< input.length(); i++) {
            if(input.charAt(i) == '(') {
                myStack.push(i+1);
            } else if(input.charAt(i) == ')') {
                if(myStack.size() < 1)
                    return null;

                Integer num = myStack.pop();
                result[counter] = num + " " + (i+1);
                counter++;
            }
        }

        if(input.length() / 2 != counter)
            return null;
        return result;
    }
}