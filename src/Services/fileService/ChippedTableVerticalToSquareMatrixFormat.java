package Services.fileService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Services.fileService.Counters.columnCounter;

public class ChippedTableVerticalToSquareMatrixFormat {

    private WriteToFile writeToFile = new WriteToFile();

    public void rebuildFileFromCippedTableVerticalToSquareMatrix(Path path) {
        transformTabsToToken(path);
        createFromSharpArrayOnSquareArrayNullFill(path);
    }

    public void transformTabsToToken(Path path) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                sb.append(transformTabsToTokenSingleRow(scanner.nextLine()));
                sb.append("\n");
            }
            writeToFile.saveInFile(path, sb.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("tutaj błędy stąd mnie wyszły: " + getClass());
        }
    }

    private String transformTabsToTokenSingleRow(String s) {
        StringBuilder sb = new StringBuilder(s);
        char tab = '\t';
        while (sb.toString().indexOf(tab) != -1) {
            int index = sb.toString().indexOf(tab);
            sb.replace(index, index + 1, "|");
        }
        return sb.toString();
    }

    private String createFromSharpArrayOnSquareArrayNullFill(Path path) {
        int sizeOfArray = 0;
        boolean firstRow = true;
        String line;
        StringBuffer sb = new StringBuffer();
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (firstRow) {
                    sizeOfArray = columnCounter(line);
                    firstRow = false;
                }
                if (sizeOfArray != 0) {
                    sb.append(formatedSharpArrrayFillToSquareArr(line, sizeOfArray) + "\n");
                } else {
                    System.out.println("Panie coś się zjebało z wielkością tablicy");
                    System.out.println("o tutaj się zepsuło" + getClass());
                }
            }
            writeToFile.saveInFile(path, sb.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String formatedSharpArrrayFillToSquareArr(String line, int sizeOfArray) {
        char separator = '|';
        int realSize = columnCounter(line);
        StringBuilder sb = new StringBuilder(line);
        List<Integer> whereIsTokenSep = new ArrayList<>();

        for (int i = 0; i < line.length(); i++)
            if (line.charAt(i) == separator) {
                whereIsTokenSep.add(i);
            }
        for (int i = whereIsTokenSep.size() - 1; i >= 0; i--) {
            if (i > 0 && whereIsTokenSep.get(i) - 1 == whereIsTokenSep.get(i - 1)) {
                sb.insert(whereIsTokenSep.get(i), "null");
            }
            if (whereIsTokenSep.get(i) == 0) {
                sb.insert(whereIsTokenSep.get(i), "null");
            }
        }
        while (realSize < sizeOfArray) {
            sb.append("|null");
            realSize = columnCounter(sb.toString());
        }
        return sb.toString();
    }

}
