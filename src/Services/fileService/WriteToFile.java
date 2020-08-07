package Services.fileService;

import Services.sequenceGenerator.DateSequenceProvider;
import Services.sequenceGenerator.SequenceProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;

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
