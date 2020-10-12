package Services.training.interviewIssues.nameStatistics;

import Services.training.interviewIssues.nameStatistics.childs.Child;
import Services.training.interviewIssues.nameStatistics.childs.Gender;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class SolutionMethods {
    private List<Child> listOfChild = new ArrayList<>();

    public List<Child> getListOfChild() {
        return listOfChild;
    }

    private void setListOfChild(Path path) {
        loadDataFromFIle(path);
    }

    private void loadDataFromFIle(Path path) {
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
        return new Child(year, gender, ethnicity, name);
    }

    public void display10MostPopularChildNames() {
        Map<Integer, List<String>> map = countOfRepeatOfTheName(mapOfNamesAndCountOfTimes());
        int top = map.keySet().stream().max(Comparator.naturalOrder()).get();
        int counter = 0;
        int position = 1;
        for (int i = top; i >= 1; i--) {
            if (map.keySet().contains(i)) {
                System.out.print(position + ".\tcounts: " + i + "->");
                position++;
                counter = counter + map.get(i).size();
                System.out.println(map.get(i).toString());
                if (counter >= 10) {
                    break;
                }
            }
        }
    }

    public void display10MostPopularChildNames(Gender gender) {
        Map<Integer, List<String>> map = countOfRepeatOfTheName(mapOfNamesAndCountOfTimes(gender));
        int top = map.keySet().stream().max(Comparator.naturalOrder()).get();
        int counter = 0;
        int position = 1;
        for (int i = top; i >= 1; i--) {
            if (map.keySet().contains(i)) {
                System.out.print(position + ".\tcounts: " + i + "->");
                position++;
                counter = counter + map.get(i).size();
                System.out.println(map.get(i).toString());
                if (counter >= 1) {
                    break;
                }
            }
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
            if (nameAndCountOfTimes.containsKey(child.getName())) {
                int counter = nameAndCountOfTimes.get(child.getName()).intValue();
                counter++;
                nameAndCountOfTimes.put(child.getName(), counter);
            }
            nameAndCountOfTimes.putIfAbsent(child.getName(), 1);
        }
        return nameAndCountOfTimes;
    }

    private Map<String, Integer> mapOfNamesAndCountOfTimes(Gender gander) {
        Map<String, Integer> nameAndCountOfTimes = new HashMap<>();
        for (Child child : this.listOfChild) {
            if (child.getGender().equals(gander) &&
                    nameAndCountOfTimes.keySet().contains(child.getName())) {
                int counter = nameAndCountOfTimes.get(child.getName()).intValue();
                counter++;
                nameAndCountOfTimes.put(child.getName(), counter);
            } else if (child.getGender().equals(gander)) {
                nameAndCountOfTimes.putIfAbsent(child.getName(), 1);
            }
        }
        return nameAndCountOfTimes;
    }

    public void theMostPopulatLetterName() {
        Map<String, Integer> tempMap = mapOfNamesAndCountOfTimes();
        Map<String, Integer> letterAndCountValue = new HashMap<>();
        String firstLetterOfName;
        for (String name : tempMap.keySet()) {
            firstLetterOfName = name.substring(0, 1).toUpperCase();
            if (letterAndCountValue.containsKey(firstLetterOfName)) {
                int counter = tempMap.get(name);
                counter += letterAndCountValue.get(firstLetterOfName);
                letterAndCountValue.put(firstLetterOfName, counter);
            } else {
                letterAndCountValue.put(firstLetterOfName, tempMap.get(name));
            }
        }

        for(String s :treeTopKeys(letterAndCountValue)){
            System.out.print(s + " - występuje:  " + letterAndCountValue.get(s) +"\t");
            System.out.println("Pojawia się w imionach:");
            for (String name : tempMap.keySet()) {
                firstLetterOfName = name.substring(0, 1).toUpperCase();
                if (firstLetterOfName.equals(s)) {
                    System.out.print("["+name+"],");
                }
            }
            System.out.println();
        }
    }

    private List<String> treeTopKeys(Map<String, Integer> incomeMap) {
        List<String> treeTopValues = new ArrayList<>();
        List<Integer> listOfValuesFromMap = new ArrayList<>();
        incomeMap.values().stream().sorted((o1, o2) -> o2 - o1)
                .forEach(integer -> listOfValuesFromMap.add(integer));
        listOfValuesFromMap.removeIf(integer -> integer < listOfValuesFromMap.get(2));
        for (String s : incomeMap.keySet()) {
                if (incomeMap.get(s) >= listOfValuesFromMap.get(2)) {
                    treeTopValues.add(s);
                    if (treeTopValues.size()==3) break;
            }
        }
        return treeTopValues;
    }

    public SolutionMethods(Path patchToDataFile) {
        setListOfChild(patchToDataFile);
    }


}
