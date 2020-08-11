package Services;

import Services.fileService.domain.services.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.ReadDataFromFile;
import Services.fileService.domain.services.WhereAreUsedChangedComponentsInSetOfAssemblies;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {


        Path path = Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt");

        var chippedTable = new ChippedTableVerticalToSquareMatrixFormat();
        chippedTable.rebuildFileFromCippedTableVerticalToSquareMatrix(path);

        var readFromFIle = new ReadDataFromFile();
        String string = readFromFIle.
                readValuersFromFileReadLineByLine(path);
        System.out.println(string);

        readFromFIle.takeDataFromFileAndCreateMap(path);

        var usages = new WhereAreUsedChangedComponentsInSetOfAssemblies();

        Map<String, List<String>>map = readFromFIle.takeDataFromFileAndCreateMap(path);
        usages.createTableOfUsagesValuesAsSetOfUnique(map);


        /*double oprDo10_000 = 0.002/12; // w skali mc
        double oprPow10_000 = 0.001/12; // w skali roku

        double zysk = 0;
        double stosunekZysku = 0;

        for (double d=9000.00;d<=10_800;d+=100){
            if (d-10_000<=0){
                zysk = d*oprDo10_000;
            }else {
                zysk = d*oprDo10_000 + (d-10_000)*oprPow10_000;
            }
            stosunekZysku = (d+zysk)/d;
            System.out.printf("dla kwory = %.0f \tZysk wyniusł=%.4f \tStosunek zysku do kapitału: %.8f \n",d,zysk,stosunekZysku);*/
        }

    }
