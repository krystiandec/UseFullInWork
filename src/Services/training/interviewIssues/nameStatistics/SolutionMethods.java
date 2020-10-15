package Services.training.interviewIssues.nameStatistics;

import Services.training.interviewIssues.nameStatistics.childs.Child;
import Services.training.interviewIssues.nameStatistics.childs.Gender;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionMethods {

    private List<Child> listOfChild = new ArrayList<>();

    public List<Child> getListOfChild() {
        return listOfChild;
    }

    private void setListOfChild(Path path) throws IOException {
        loadDataFromFIle(path);
    }

    private void loadDataFromFIle(Path path) throws IOException {
        try {
            Scanner scanner = new Scanner(path);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                this.listOfChild.add(readLineOfTokens(scanner.nextLine()));
            }
        } catch (IOException e) {
            System.out.println("Plik nie istnieje");
            e.printStackTrace();
        }
    }

    private Child readLineOfTokens(String line) {
        StringTokenizer token = new StringTokenizer(line, ",");
        int year = Integer.valueOf(token.nextToken());
        String gender = token.nextToken().toUpperCase();
        String ethnicity = token.nextToken().toUpperCase();
        String name = token.nextToken().toUpperCase();
        Integer count = Integer.valueOf(token.nextToken());
        return new Child(year, gender, ethnicity, name, count);
    }

    public void displayMostPopularChildNames(int countOfNamesToDisplay) {
        Map<Integer, List<String>> map = countOfRepeatOfTheName
                (mapOfNamesAndCountOfTimes());
        List<Integer> valuesOfKeysSorted = map.keySet().stream()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        int position = 1;
        for (Integer counter : valuesOfKeysSorted) {
            System.out.print(position + ".\tcounts: " + counter + "->");
            System.out.println(map.get(counter).toString());
            position++;
            if (position > countOfNamesToDisplay) break;
        }
    }

    public void displayMostPopularChildNames(int countOfNamesToDisplay, Gender gender) {
        Map<Integer, List<String>> map = countOfRepeatOfTheName
                (mapOfNamesAndCountOfTimes(gender));
        List<Integer> valuesOfKeysSorted = map.keySet().stream()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        int position = 1;
        for (Integer counter : valuesOfKeysSorted) {
            System.out.print(position + ".\tcounts: " + counter + "->");
            System.out.println(map.get(counter).toString());
            position++;
            if (position > countOfNamesToDisplay) break;
        }
    }

    private Map<Integer, List<String>> countOfRepeatOfTheName(Map<String, Integer> incomeMap) {
        Map<Integer, List<String>> integerListMap = new HashMap<>();
        for (String name : incomeMap.keySet()) {
            int i = incomeMap.get(name);
            if (integerListMap.containsKey(i)) {
                integerListMap.get(i).add(name);
            } else {
                integerListMap.put(incomeMap.get(name), new ArrayList<>());
                integerListMap.get(i).add(name);
            }
        }
        return integerListMap;
    }

    private Map<String, Integer> mapOfNamesAndCountOfTimes() {
        Map<String, Integer> nameAndCountOfTimes = new HashMap<>();
        for (Child child : this.listOfChild) {
            nameAndCountOfTimes.merge(child.getName(), child.getCount(), Integer::sum);
        }
        return nameAndCountOfTimes;
    }

    private Map<String, Integer> mapOfNamesAndCountOfTimes(Gender gander) {
        Map<String, Integer> nameAndCountOfTimes = new HashMap<>();
        for (Child child : this.listOfChild) {
            if (child.getGender().equals(gander)) {
                nameAndCountOfTimes.merge(child.getName(), child.getCount(), Integer::sum);
            }
        }
        return nameAndCountOfTimes;
    }

    public void theMostPopulatLetterName(int countOfTheMostPopulatLetters) {
        Map<String, Integer> tempMap = mapOfNamesAndCountOfTimes();
        Map<String, Integer> letterAndCountValue = new HashMap<>();
        String firstLetterOfName;
        for (String name : tempMap.keySet()) {
            firstLetterOfName = name.substring(0, 1).toUpperCase();
            letterAndCountValue.merge(firstLetterOfName, tempMap.get(name), Integer::sum);
        }
        List<String> val = mostPopularKeysInMap(letterAndCountValue, countOfTheMostPopulatLetters);
        for (String s : val) {
            System.out.print(s + " - występuje:  " + letterAndCountValue.get(s) + "\t");
            System.out.println("Pojawia się w imionach:");
            for (String name : tempMap.keySet()) {
                firstLetterOfName = name.substring(0, 1).toUpperCase();
                if (firstLetterOfName.equals(s)) {
                    System.out.print("[" + name + "],");
                }
            }
            System.out.println();
        }
    }

    private List<String> mostPopularKeysInMap(Map<String, Integer> incomeMap, int count) {
        List<String> topValues = new ArrayList<>();
        List<Integer> listOfValuesFromMap = new ArrayList<>();
        incomeMap.values().stream().sorted((o1, o2) -> o2 - o1)
                .forEach(integer -> listOfValuesFromMap.add(integer));
        listOfValuesFromMap.removeIf(integer -> integer < listOfValuesFromMap.get(count - 1));

        for (int i : listOfValuesFromMap) {
            for (String s : incomeMap.keySet()) {
                if (i == incomeMap.get(s)) topValues.add(s);
            }
        }

        return topValues;
    }

    public SolutionMethods(Path patchToDataFile) throws IOException {
        setListOfChild(patchToDataFile);
    }


}
