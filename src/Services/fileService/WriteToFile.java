package Services.fileService;

import Services.sequenceGenerator.DateSequenceProvider;
import Services.sequenceGenerator.SequenceProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.*;

public class WriteToFile {

    private String patchToFile;
    private SequenceProvider sequenceProvider;

    /*Settery*/
    private void setSequenceProvider() {
        this.sequenceProvider = new DateSequenceProvider();
    }

    private void setPatchToFile(Path path) throws IOException {
        setSequenceProvider();
        if (path.toString().equals("")) {
            throw new IOException("Sciezka nie moze byc pusta !! ");
        } else {
            StringBuilder sb = new StringBuilder(path.toString());
            sb.insert(path.toString().lastIndexOf('\\') + 1, sequenceProvider.getSequence());
            this.patchToFile = sb.toString();
        }
    }

    /*Metody*/

    /**
     * nowy kod implementacja
     */
    public Map<String, Set<String>> takeAndSortDataFromTokenFile(Path path) {
        Map<String, Set<String>> map = new HashMap<>();

        try {
            Scanner scanner = new Scanner(path);

            while (scanner.hasNextLine()) {

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(getClass());
        }
        return map;
    }

    public void takePastedDataFromExcelCellToTXT(Path path) {
        transformTabsToToken(path);
        createFromSharpArrayOnSquareArrayNullFill(path);

    }

    private void transformTabsToToken(Path path) {
        StringBuilder sb = new StringBuilder();
        int columnCount;
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                sb.append(transformTabsToTokenSingleRow(scanner.nextLine()));
                sb.append("\n");
            }
            saveInFile(path, sb.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
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

    private void createFromSharpArrayOnSquareArrayNullFill(Path path) {
        int sizeOfArray;
        try {
            Scanner scanner = new Scanner(path);
            sizeOfArray = columnCounter(path);
            while (scanner.hasNextLine()) {
                formatedSharpArrrayFillToSquareArr(scanner.nextLine(), sizeOfArray);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(getClass());
        }
    }

    private int columnCounter(Path path) {
        int counter = 0;
        int index;
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(path);
            sb.append(scanner.nextLine());
            while (sb.toString().indexOf('|') != -1) {
                index = sb.toString().indexOf('|');
                sb.deleteCharAt(index);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (counter != 0) counter += 1;
        return counter;
    }


    private String formatedSharpArrrayFillToSquareArr(String line, int sizeOfArray) {
        StringBuilder sb = new StringBuilder(line);
        char separator = '|';
        List<Integer> whereIsTokenSep = new ArrayList<>();
        for (int i = 0; i < line.length(); i++)
            if (line.charAt(i) == separator) {
                whereIsTokenSep.add(i);
            }
        for (int i=0; i < whereIsTokenSep.size(); i++) {

        }

        return null;
    }

    /**
     * nowy kod implementacja koniec
     */
    public void saveInFile(Path path, String txt, boolean createUniqueSerialNo) throws IOException {
        File file = null;
        if (createUniqueSerialNo) {
            setPatchToFile(path);
            file = new File(this.patchToFile);
            System.out.println("Plik utworzono w: " + this.patchToFile);
        } else {
            file = new File(path.toString());
            System.out.println("Plik nadpisano w: " + path.toString());
        }
        try (FileWriter fileWriter = new FileWriter(file, false); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
