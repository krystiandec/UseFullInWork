package Services.fileService;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

import static Services.fileService.Counters.columnCounter;
import static Services.fileService.Counters.positionOfSeparators;

public class ReadDataFromFile {

    public String readValuersFromFileReadLineByLine(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine() + "\n");
            }
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("wyjebało błęda");
            System.out.println(getClass());
        }
        return sb.toString();
    }

    public Map<String, List<String>> takeDataFromFileWhereIsChippedTableVertical(Path path) {
        List<String> keyList = new ArrayList<>();
        List<String> values = new ArrayList<>();
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
            line = scanner.nextLine();
            for (String s : keyList) {
                map.put(s,new ArrayList<>());
            }
            //mam już klucze tutaj.
            while (scanner.hasNextLine()) {
                positions = positionOfSeparators(line);
                for (int i = 0; i <= positions.size(); i++) {
                    if (i == 0) {
                        map.get(keyList.get(i)).add(line.substring(i, positions.get(i)));
                    } else if (i == positions.size()) {
                        map.get(keyList.get(i)).add(line.substring(positions.get(i - 1) + 1, line.length()));
                    } else {
                        map.get(keyList.get(i)).add(line.substring(positions.get(i - 1) + 1, positions.get(i)));
                    }
                }
                values.clear();
                line = scanner.nextLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(getClass());
        }
        return map;
    }


}
