package Services.fileService;

import Services.sequenceGenerator.DateSequenceProvider;
import Services.sequenceGenerator.SequenceProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileSaveImpl implements FileSaveTxt {
    private String name;
    private SequenceProvider sequenceProvider;

    private void setSequenceProvider() {
        this.sequenceProvider = new DateSequenceProvider();
    }

    private void setName(String filePath,String fileName) throws IOException {
        if (filePath == "" || filePath == null) {
            throw new IOException("Sciezka nie moze byc pusta !! ");
        }else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(filePath + "\\");
            stringBuilder.append(sequenceProvider.getSequence());
            stringBuilder.append(fileName);
            stringBuilder.append(".txt");
            this.name = stringBuilder.toString();
        }
    }

    @Override
    public void saveInFile(String filePath,String fileName, String[] txt) throws IOException {
        setName(filePath,fileName);
        File file = new File(this.name);
        if (file.exists()){
            System.out.println("Plik nadpisano w: " + this.name);
        }else {
            System.out.println("Plik utworzono w: " + this.name);
        }
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < txt.length; i++) {
                bufferedWriter.write(txt[i]);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public FileSaveImpl() {
        setSequenceProvider();
    }
}
