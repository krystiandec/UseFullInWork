package Services.training.interviewIssues.numberPairsMaxMin;

import java.util.*;

public class Pairs {
    private static void maxMinNextNumbers(int[] array) {
        Set<Integer> eachSum = new HashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            eachSum.add(array[i] + array[i + 1]);
        }
        int maxVal = eachSum.stream().max(Integer::compareTo).get();
        int minVal = eachSum.stream().min(Integer::compareTo).get();
        Set<List<Integer>> maxSet = new HashSet<>();
        Set<List<Integer>> minSet = new HashSet<>();
/*        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(1, integer -> new ArrayList<>());
        map.computeIfPresent(1, (integer, integers) ->
                {
                    integers.add(maxVal);
                    return integers;
                }
        );*/
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + array[i + 1] >= maxVal) {
                List<Integer> maxList = new ArrayList<>();
                maxList.add(array[i]);
                maxList.add(array[i + 1]);
                maxSet.add(maxList);
            } else if (array[i] <= minVal && (array[i] + array[i + 1] == minVal)) {
                List<Integer> minList = new ArrayList<>();
                minList.add(array[i]);
                minList.add(array[i + 1]);
                minSet.add(minList);
            }
        }
        System.out.println("Pary kolejnych liczb dających największą sumę:");
        for (List<Integer> i : maxSet) {
            System.out.println(i.toString());
        }
        System.out.println("Pary kolejnych liczb dających najmniejszą sumę:");
        for (List<Integer> i : minSet) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args) {
        int[] income = {2, 0, 0, 2, 0, 1, -1, -0, 2};
        maxMinNextNumbers(income);
    }
}
