import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] lineArray = line.split(" ");
        int[] days = new int[Integer.parseInt(lineArray[1])];
        String[] peopleToleranceStr = in.nextLine().split(" ");
        int[] peopleTolerance = new int[peopleToleranceStr.length];
        for(int i = 0; i < days.length; i++) {
            days[i] = Integer.parseInt(in.nextLine());
        }
        for(int i = 0; i < peopleToleranceStr.length; i++) {
            peopleTolerance[i] = Integer.parseInt(peopleToleranceStr[i]);
        }
//        long startTime = System.currentTimeMillis();
        int[] result = solution(peopleTolerance, days);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time: "+ (endTime-startTime));
    }

    public static int[] solution(int[] peopleTolerance, int[] daysTemperature) {
        int[] sadPeopleCount = new int[daysTemperature.length];
        int[] sortedDaysTemperature = Arrays.copyOf(daysTemperature, daysTemperature.length);
        Arrays.sort(sortedDaysTemperature);
        List<Integer> remainingPeople = Arrays.stream(peopleTolerance).boxed().collect(Collectors.toList());
        Map<Integer, Integer> sadPeoplePerTemperature = new HashMap<>();
        for (int i = 0; i < sortedDaysTemperature.length; i++) {
            ListIterator<Integer> iter = remainingPeople.listIterator();
            while(iter.hasNext()){
                int peopleTolerate = iter.next();
                if(peopleTolerate < sortedDaysTemperature[i]){
                    sadPeoplePerTemperature.put(sortedDaysTemperature[i], sadPeoplePerTemperature.getOrDefault(sortedDaysTemperature[i], 0) + 1);
                    iter.remove();
                }
            }
            if(i > 0) {
                sadPeoplePerTemperature.put(sortedDaysTemperature[i], sadPeoplePerTemperature.getOrDefault(sortedDaysTemperature[i-1], 0) + sadPeoplePerTemperature.getOrDefault(sortedDaysTemperature[i], 0));
            }
        }
        for(int i = 0; i < sadPeopleCount.length; i++) {
            sadPeopleCount[i] = sadPeoplePerTemperature.getOrDefault(daysTemperature[i], 0);
        }
        return sadPeopleCount;
    }
}
