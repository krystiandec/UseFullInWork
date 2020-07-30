package Services.fileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ReadDataFromFile implements FileGetValues {
    @Override
    public String readValuersFromFile(String filePath) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder sb = new StringBuilder();
        String dataFromFile = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null ) {
                sb.append(bufferedReader.readLine());
            }
            dataFromFile = sb.toString();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return dataFromFile;
    }
}
