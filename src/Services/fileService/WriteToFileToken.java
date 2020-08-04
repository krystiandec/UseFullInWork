package Services.fileService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class WriteToFileToken {

    public void formatExistFileForTokensConvertTabForVerticalLine(Path path) {
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                for (char ch: line.toCharArray()) {
                    if(ch!='\t')sb.append(ch);
                    else sb.append('|');
                }
                sb.append("\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
