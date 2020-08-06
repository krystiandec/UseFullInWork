package Services;

import Services.fileService.WriteToFile;

import java.nio.file.Path;

public class Temp {

    public static void main(String[] args) {
/*        String[] linie = {"419171003C2,419170200,02Y0039,419380400,419380200,419540000,419380300,419380100,419170100",
                "419171032C2,419170001C1",
                "419171104,419170200,419380400,419540000,419170100"};
        Map<String, Set<String>> map2 = new HashMap<>();
        for (String str:linie) {
            int pointerPosition = str.indexOf(',');

            int nextPointerPosition;
            System.out.println("przecinek jest na pozycji :" + pointerPosition);
        }*/

        var wtf = new WriteToFile();
        wtf.takePastedDataFromExcelCellToTXT(Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt"));


/*

        String[] test = {"je", "6ea", "bea", "i","8432"};
        Arrays.sort(test,(o1, o2) -> o1.length()-o2.length());
        System.out.println(Arrays.toString(test));
        Scanner scanner = new Scanner(System.in);
        System.currentTimeMillis();
        System.out.println("Jest godzina" + Instant.ofEpochMilli(System.currentTimeMillis()));


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Test.txt"));
            bufferedReader.readLine();
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
*/

    }
}