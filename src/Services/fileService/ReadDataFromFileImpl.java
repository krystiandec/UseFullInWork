package Services.fileService;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadDataFromFileImpl {

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


}