package Services;


import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
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

    /*private  static class InnerClass{
        public <E> E lalala (Optional<E> optional){
            List<E> lalaList = Collections.emptyList();
            optional.ifPresent(e -> lalaList.add(e));
            optional.ifPresent(e -> System.out.println(e));
            return lalaList.get(0);
        }
    }*/

    public static void main(String[] args) {
        String fizz="Fizz";
        String buzz="Buzz";
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i <= 150; i++) {
            array.add(i);
        }
        array.stream()
                .map(e -> String.valueOf(e) + "." + (e % 3 == 0 ? fizz : "") + (e % 5 == 0 ? buzz : ""))
                .filter(e -> e.contains(fizz)||e.contains(buzz))
                .forEach(System.out::println);
    }
}
