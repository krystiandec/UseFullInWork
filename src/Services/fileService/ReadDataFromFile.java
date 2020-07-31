package Services.fileService;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class ReadDataFromFile implements FileGetValues {
    @Override
    public String readValuersFromFile(String filePath) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        BufferedInputStream bufferedInputStream = null;
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

                sb.append(bufferedReader.readLine());


        } catch (IOException e) {
            e.getMessage();
        } finally {
            fileReader.close();
            bufferedReader.close();
        }
        return sb.toString();
    }
}
