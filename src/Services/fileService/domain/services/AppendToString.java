package Services.fileService.domain.services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendToString {
    public static List<String> appendStar(Path path){
        List<String> tempList = new ArrayList<>();
        StringBuilder sb;
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                sb = new StringBuilder(scanner.nextLine());
                sb.append('*');
                tempList.add(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("plik nie istnieje");
        }
        return tempList;
    }

}
