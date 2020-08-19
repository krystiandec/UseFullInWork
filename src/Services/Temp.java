package Services;

import Services.fileService.domain.services.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.ReadDataFromFile;
import Services.fileService.domain.services.WhereAreUsedChangedComponentsInSetOfAssemblies;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Temp {

    public static void main(String[] args) {


/*        Path path = Path.of("D:\\Java\\Projekty\\UseFullInWork\\Test.txt");

        var chippedTable = new ChippedTableVerticalToSquareMatrixFormat();
        chippedTable.rebuildFileFromCippedTableVerticalToSquareMatrix(path);

        var readFromFile = new ReadDataFromFile();

        var usages = new WhereAreUsedChangedComponentsInSetOfAssemblies();
        usages.createTableOfUsagesValuesAsSetOfUnique(path);
        System.out.println();

        try {
            FileReader fr = new FileReader(path.toFile());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*var list = new LinkedList<String>();
        list.add("Kamil");
        list.add("Jurek");
        list.add("Daniel");
        System.out.println(list.listIterator(2));
        Iterator<String> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        list.forEach(e-> System.out.println(e));*/

/*
        var a = new LinkedList<String>();
        a.add("Ania");
        a.add("Karol");
        a.add("Eryk");
        var b = new LinkedList<String>();
        b.add("Bartek");
        b.add("Daniel");
        b.add("Franek");
        b.add("Gosia");
        System.out.println(a);
        System.out.println(b);
// Scalenie list a i b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        while (bIter.hasNext())
        {
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);
// Usunięcie co drugiego słowa z listy b
        bIter = b.iterator();
        while (bIter.hasNext())
        {
            bIter.next(); // Opuszczenie jednego elementu
            if (bIter.hasNext())
            {
                bIter.next(); // Opuszczenie następnego elementu
                bIter.remove(); // Usunięcie elementu
            }
        }
        System.out.println(b);
// Usunięcie wszystkich słów znajdujących się w liście b z listy a
        a.removeAll(b);
        System.out.println(a);
*/

        /*        List<Integer> numbers = Arrays.asList(6, 5, 3, 47, 5, 3, 2, 1);
        int sum = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        long sdsa = numbers.stream()
                .sorted()
                .count();
        System.out.println(sum);
        System.out.println(sdsa);*/

    }
}
