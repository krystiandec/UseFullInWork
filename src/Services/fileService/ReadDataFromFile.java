package Services.fileService;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

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

    public Map<String, Set<String>> takeDataFromFileWhereIsChippedTableVertical(Path path) {
        List<String> keyList = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        String line;
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(getClass());
        }
        return map;
    }


}
