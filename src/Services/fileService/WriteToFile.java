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

    private void setSequenceProvider() {
        this.sequenceProvider = new DateSequenceProvider();
    }

    private void setPatchToFile(Path path) throws IOException {
        setSequenceProvider();
        if (path.toString() == "" || path == null) {
            throw new IOException("Sciezka nie moze byc pusta !! ");
        }else {
            var sb = new StringBuilder();
            sb.append(path.toString());
            sb.append("\\");
            sb.append(sequenceProvider.getSequence());
            sb.append("");
            sb.append(".txt");
            this.patchToFile = sb.toString();
        }
    }

    public void saveInFile(Path path, String txt) throws IOException {
        setPatchToFile(path);
        File file = new File(this.patchToFile);
        if (file.exists()){
            System.out.println("Plik nadpisano w: " + this.patchToFile);
        }else {
            System.out.println("Plik utworzono w: " + this.patchToFile);
        }
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,false);
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
