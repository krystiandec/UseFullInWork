package Services.fileService.domain.services;

import Services.fileService.domain.sortingMetods.SortMetods;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.*;

import static Services.fileService.domain.services.Counters.positionOfSeparators;

public class WhereAreUsedChangedComponentsInSetOfAssemblies {

    public void createTableOfUsagesValuesAsSetOfUnique(Path path) {
        Map<String, List<String>> map = takeDataFromFileAndCreateMap(path);
        Set<String> uniqueValues = new TreeSet<>();
        for (String s : map.keySet()) {
            for (String stringList : map.get(s)) {
                uniqueValues.add(stringList);
            }
        }
        // TODO: 12-08-20 dodawać najpierw do listy nastepnie posortowac i dopiero wyciagnac unikaty.
        uniqueValues = SortMetods.setSort(uniqueValues);
        uniqueValues.remove("null");
        System.out.print("\t");
        for (String s : uniqueValues) {
            System.out.print(s + "\t");
        }
        System.out.println();
        for (String s : map.keySet()) {
            System.out.print(s + "\t");
            for (String str :uniqueValues) {
                if (map.get(s).contains(str)) {
                    System.out.print("+\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println("");
        }
    }

    private Map<String, List<String>> takeDataFromFileAndCreateMap(Path path) {
        List<String> keyList = new ArrayList<>();
        Map<String, List<String>> map = new TreeMap<>();
        String line;
        List<Integer> positions;
        try {
            Scanner scanner = new Scanner(path);
            line = scanner.nextLine();
            positions = positionOfSeparators(line);
            for (int i = 0; i <= positions.size(); i++) {
                if (i == 0) {
                    keyList.add(line.substring(i, positions.get(i)));
                } else if (i == positions.size()) {
                    keyList.add(line.substring(positions.get(i - 1) + 1, line.length()));
                } else {
                    keyList.add(line.substring(positions.get(i - 1) + 1, positions.get(i)));
                }
            }
            for (String s : keyList) {
                map.put(s, new ArrayList<>());
            }
            line = scanner.nextLine();
            positions = positionOfSeparators(line);
            while (scanner.hasNextLine()) {
                for (int i = 0; i <= positions.size(); i++) {
                    if (i == 0) {
                        map.get(keyList.get(i)).add(line.substring(i, positions.get(i)));
                    } else if (i == positions.size()) {
                        map.get(keyList.get(i)).add(line.substring(positions.get(i - 1) + 1, line.length()));
                    } else {
                        map.get(keyList.get(i)).add(line.substring(positions.get(i - 1) + 1, positions.get(i)));
                    }
                }
                line = scanner.nextLine();
                positions = positionOfSeparators(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(getClass());
        }
        return map;
    }
}
