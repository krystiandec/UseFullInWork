package Services.fileService;

import java.io.IOException;

public interface FileGetValues {
    String readValuersFromFile(String filePath)throws IOException;
}
