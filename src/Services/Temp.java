package Services;

import Services.fileService.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.Counters;
import Services.fileService.ReadDataFromFile;
import Services.fileService.WriteToFile;

import java.io.IOException;
import java.nio.file.Path;

public class Temp {

    public static void main(String[] args) {

        Path path = Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt");

        var chippedTable = new ChippedTableVerticalToSquareMatrixFormat();
        chippedTable.rebuildFileFromCippedTableVerticalToSquareMatrix(path);

        var readFromFIle = new ReadDataFromFile();
        String string = readFromFIle.
                readValuersFromFileReadLineByLine(path);
        System.out.println(string);

        readFromFIle.takeDataFromFileWhereIsChippedTableVertical(path);
    }
}