package Services;

import Services.fileService.FileSaveImpl;

public class Temp {
    public static void main(String[] args) {
        String[] linie = {"Pierwsza linia tekstu do zapisania", "druga linia - kilka liczb: 12, 23, 44", "trzecia linia"};
        FileSaveImpl fileSave = new FileSaveImpl();
        try {
            fileSave.saveInFile("D:\\Praca\\Bierzace\\KZ\\20200520 - Karta zmian td20_td25_td40\\TXT",
                    "Numery", linie);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Niepoprawna ścieżka !!");
        }
    }
}