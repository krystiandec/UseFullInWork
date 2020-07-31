package Services;

import Services.fileService.FileSaveImpl;
import Services.fileService.ReadDataFromFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        String[] linie = {"419171003C2,419170200,02Y0039,419380400,419380200,419540000,419380300,419380100,419170100",
                "419171032C2,419170001C1",
                "419171104,419170200,419380400,419540000,419170100"};
/*        FileSaveImpl fileSave = new FileSaveImpl();
        try {
            fileSave.saveInFile("D:\\Java\\Projekty\\UseFullInWork\\src",
                    "Numery", linie);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Niepoprawna ścieżka !!");
        }*/

        /*ReadDataFromFile reader = new ReadDataFromFile();
        try {
            System.out.println(reader.readValuersFromFile("202007291353 - Numery.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        StringBuilder sb = new StringBuilder();
        String path = "D:\\Java\\Projekty\\UseFullInWork\\Test.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.append(scanner.next());
        sb.append(scanner.nextLine());
        sb.append(scanner.nextLine());
        sb.append(scanner.nextLine());
        sb.append(scanner.nextLine());
        sb.append(scanner.nextLine());
        System.out.println(sb.toString());

    }
}