import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        int[][] table = new int[9][9];
        for(int i = 0; i<9; i++)
            for(int j = 0; j<9; j++)
                table[i][j] = in.nextInt();

        int[][] solved = solve(table);

        if(solved == null) {
            System.out.println("No solution exists");
            return;
        }
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter writer = new BufferedWriter(out);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(solved[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        writer.write(stringBuilder.toString());
        writer.flush();
    }

    int[][] result;
    boolean hasResult = false;

    public int[][] solve(int[][] table) {

        hasResult = false;
        result = new int[9][9];
        sudoku(table);
        if(hasResult)
            return result;
        return null;
    }

    public void sudoku(int[][] table) {

        if(hasResult)
            return;

        if (isCompleteSimple(table) /*&& isCorrect(table)*/) {
            copyToResult(table);
            return;
        }

        int freeIndexI = 0, freeIndexJ = 0;
        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if(table[i][j] == 0) {
                    freeIndexI = i;
                    freeIndexJ = j;
                    i = 9;
                    j = 9;
                }
            }
        }

        for(int k = 1; k<=9; k++) {
            table[freeIndexI][freeIndexJ] = k;
            if(isCorrect(table, freeIndexI, freeIndexJ)) {
                sudoku(table);
            }
            table[freeIndexI][freeIndexJ] = 0;
        }
        return;
    }

    private void copyToResult(int[][] table) {
        hasResult = true;
        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = table[i][j];
            }
        }
    }

    private boolean isCorrect(int[][] table, int i, int j) {
        int[] batch = new int[9];
        for (int k = 0; k < 9; k++) {
            batch[k] = table[i][k];
        }
        if(hasDuplicate(batch))
            return false;

        for (int k = 0; k < 9; k++) {
            batch[k] = table[k][j];
        }
        if(hasDuplicate(batch))
            return false;

        int indexI= (i/3)*3;
        int indexJ = (j/3)*3;
        batch[0] = table[indexI][indexJ];
        batch[1] = table[indexI+1][indexJ];
        batch[2] = table[indexI+2][indexJ];
        batch[3] = table[indexI][indexJ+1];
        batch[4] = table[indexI+1][indexJ+1];
        batch[5] = table[indexI+2][indexJ+1];
        batch[6] = table[indexI][indexJ+2];
        batch[7] = table[indexI+1][indexJ+2];
        batch[8] = table[indexI+2][indexJ+2];
        if(hasDuplicate(batch))
            return false;

        return true;
    }


    private boolean hasDuplicateSimple(int[] batch) {

        Set<Integer> allBatch = new HashSet<>();
        int counter = 0;
        for(int i=0; i<batch.length; i++) {
            if(batch[i] != 0) {
                allBatch.add(batch[i]);
                counter++;
            }
        }
        return counter != allBatch.size();
    }

    private boolean isCompleteSimple(int[][] table) {
        int count = 0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(table[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private boolean hasDuplicate(int[] batch) {
        boolean simple = hasDuplicateSimple(batch);
       long all = Arrays.stream(batch).filter(x-> x!=0).count();
       long distinct = Arrays.stream(batch).filter(x-> x!=0).distinct().count();
        boolean advance = all != distinct;

        if(simple != advance) {
            System.out.println("Diff");
            hasDuplicateSimple(batch);
        }

        return advance;
    }

    private boolean isComplete(int[][] table) {
        return Arrays.stream(table)
                .flatMapToInt(Arrays::stream)
                .filter(x -> x == 0).count() == 0;
    }
}