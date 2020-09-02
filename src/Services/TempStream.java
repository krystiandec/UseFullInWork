package Services;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class TempStream {

    public static String transformTabsToTokenStream(Path path) {
        try {
            Scanner scanner = new Scanner(path);
            Stream<String> stream = scanner.nextLine().lines();
            return stream.toString();

        } catch (IOException e) {
            System.out.println("Plik nie istnieje");
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(transformTabsToTokenStream(Path.of("alice_in_wonderland.txt")));
        System.out.println("*");

    }
}
