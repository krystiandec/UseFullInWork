package Services;

import Services.fileService.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.WriteToFile;

import java.io.IOException;
import java.nio.file.Path;

public class Temp {

    public static void main(String[] args) {

        var chippedTable = new ChippedTableVerticalToSquareMatrixFormat();
        chippedTable.rebuildFileFromCippedTableVerticalToSquareMatrix
                (Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt"));


    }
}