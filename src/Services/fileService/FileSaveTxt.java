package Services.fileService;

import java.io.IOException;

public interface FileSaveTxt {
    void saveInFile(String filePath,String fileName,String[] txt) throws IOException;



}
