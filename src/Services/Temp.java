package Services;

import Services.fileService.FileSaveImpl;
import Services.fileService.ReadDataFromFile;

import java.io.IOException;

public class Temp {
    public static void main(String[] args) {
        String[] linie = {"419171003C2,419170200,02Y0039,419380400,419380200,419540000,419380300,419380100,419170100",
                "419171032C2,419170001C1",
                "419171104,419170200,419380400,419540000,419170100"};
/*        FileSaveImpl fileSave = new FileSaveImpl();
        try {
            fileSave.saveInFile("D:\\Praca\\Bierzace\\KZ\\20200520 - Karta zmian td20_td25_td40\\TXT",
                    "Numery", linie);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Niepoprawna ścieżka !!");
        }*/

        ReadDataFromFile reader = new ReadDataFromFile();
        try {
            System.out.println(reader.readValuersFromFile("D:\\Praca\\Bierzace\\KZ\\20200520 - Karta zmian td20_td25_td40\\TXT\\202007291353 - Numery.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}