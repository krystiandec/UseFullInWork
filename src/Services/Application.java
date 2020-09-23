package Services;

import Services.fileService.domain.services.AppendToString;

import java.nio.file.Path;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        for (String s: AppendToString.appendStar(Path.of("D:\\Java\\Projekty\\UseFullInWork\\Numery"))) {
            System.out.println(s);
        }
    }
}
