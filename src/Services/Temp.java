package Services;

import Services.fileService.domain.services.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.ReadDataFromFile;
import Services.fileService.domain.services.WhereAreUsedChangedComponentsInSetOfAssemblies;

import java.awt.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {


        Path path = Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt");

        var chippedTable = new ChippedTableVerticalToSquareMatrixFormat();
        chippedTable.rebuildFileFromCippedTableVerticalToSquareMatrix(path);

        var readFromFile = new ReadDataFromFile();

        var usages = new WhereAreUsedChangedComponentsInSetOfAssemblies();
        usages.createTableOfUsagesValuesAsSetOfUnique(path);
        System.out.println();

/*        List<Integer> numbers = Arrays.asList(6, 5, 3, 47, 5, 3, 2, 1);
        int sum = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        long sdsa = numbers.stream()
                .sorted()
                .count();
        System.out.println(sum);
        System.out.println(sdsa);*/


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
