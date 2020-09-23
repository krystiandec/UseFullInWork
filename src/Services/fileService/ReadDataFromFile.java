package Services.fileService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static Services.fileService.domain.services.Counters.positionOfSeparators;

public class ReadDataFromFile {

    public String readValuersFromFileReadLineByLine(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(path);
            scanner.tokens();
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
    public String readLineByLineAppendStar(Path path) throws IOException{
        String str = new String(Files.readAllBytes(path));
        List<String> stringList = Arrays.asList(str.split("\\PL+"));
        return null;
    }
}