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
        String gender = token.nextToken();
        String ethnicity = token.nextToken();
        String name = token.nextToken();
        return new Child(year, gender, ethnicity, name);
    }

    public void display10MostPopularChildNames() {
        Map<Integer, List<String>> map = countOfRepeatOfTheName();
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

    private Map<Integer, List<String>> countOfRepeatOfTheName() {
        Map<String, Integer> tempList = mapOfNamesAndCountOfTimes();
        Map<Integer, List<String>> integerListMap = new HashMap<>();

        for (String name : tempList.keySet()) {
            int i = tempList.get(name);
            if (integerListMap.keySet().contains(i)) {
                integerListMap.get(i).add(name);
            } else {
                integerListMap.put(tempList.get(name), new ArrayList<>());
                integerListMap.get(i).add(name);
            }
        }
//        usunięcie unikatów
        integerListMap.remove(1);
        return integerListMap;
    }

    private Map<String, Integer> mapOfNamesAndCountOfTimes() {
        Map<String, Integer> nameAndCountOfTimes = new HashMap<>();
        for (Child child : this.listOfChild) {
            if (nameAndCountOfTimes.keySet().contains(child.getName())) {
                int counter = nameAndCountOfTimes.get(child.getName()).intValue();
                counter++;
                nameAndCountOfTimes.put(child.getName(), counter);
            }
            nameAndCountOfTimes.putIfAbsent(child.getName(), 1);
        }
        return nameAndCountOfTimes;
    }


    public SolutionMethods(Path patchToDataFile) {
        setListOfChild(patchToDataFile);
    }


}
