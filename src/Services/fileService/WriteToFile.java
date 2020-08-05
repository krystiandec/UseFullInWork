package Services.fileService;

import Services.sequenceGenerator.DateSequenceProvider;
import Services.sequenceGenerator.SequenceProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {

    private String patchToFile;
    private SequenceProvider sequenceProvider;

    private void setSequenceProvider() {
        this.sequenceProvider = new DateSequenceProvider();
    }

    private void setPatchToFile(Path path) throws IOException {
        setSequenceProvider();
        if (path.toString() == "" || path == null) {
            throw new IOException("Sciezka nie moze byc pusta !! ");
        } else {
            StringBuilder sb = new StringBuilder(path.toString());
            sb.insert(path.toString().lastIndexOf('\\') + 1, sequenceProvider.getSequence());
            this.patchToFile = sb.toString();
        }
    }

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


    public void reformatDocToTokenSeparators(Path path) {
        StringBuilder sb = new StringBuilder();
        int columnCount;
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                sb.append(removeTabsAndSeparateThem(scanner.nextLine()));
                sb.append("\n");
            }
            saveInFile(path, sb.toString(), false);
            System.out.println(scanner.hasNextLine());
            scanner = new Scanner(path);
            System.out.println(scanner.hasNextLine());
            columnCount = columnCounter(scanner.nextLine());
            System.out.println(columnCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String removeTabsAndSeparateThem(String s) {
        StringBuilder sb = new StringBuilder(s);
        char tab = '\t';
        while (sb.toString().indexOf(tab) != -1) {
            int index = sb.toString().indexOf(tab);
            sb.replace(index, index + 1, "|");
        }
        return sb.toString();
    }

    private int columnCounter(String s) {
        int counter=0;
        int index;
        StringBuilder sb = new StringBuilder(s);
        while (sb.toString().indexOf('|') != -1) {
            index = sb.toString().indexOf('|');
            sb.deleteCharAt(index);
            counter++;
        }
        if (counter!=0) counter+=1;
        return counter;
    }

    private void createFromSharpArrayOnSquareNullFill(){

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
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

}
