package Services;

import Services.fileService.domain.services.ChippedTableVerticalToSquareMatrixFormat;
import Services.fileService.ReadDataFromFile;
import Services.fileService.domain.services.WhereAreUsedChangedComponentsInSetOfAssemblies;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Temp {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        List<String> list1 = new ArrayList<>();
        list.add("dsadsad");
        list.add("dfa");
        list.add("gtrhg");
        list.add("ktfyf");
        list.add("eryr");
        Collections.unmodifiableList(list);
//        list1 = Collections.checkedList(list,String.class);

        try {
            String string = new String(Files.readAllBytes(Path.of("D:\\Java\\Projekty\\UseFullInWork\\alice_in_wonderland.txt")));
            List<String> counter = Arrays.asList(string.split("\\PL+"));
            long words = counter.stream().filter(w->w.length()>6 && w.length()<12).count();
            System.out.println("Words each length is grater than 12: " + words);
        } catch (IOException e) {
            System.out.println("File do not exist");
            e.printStackTrace();
        }

        Arrays.stream(list.toArray(),3,5).forEach(e-> list1.add(e+"asa"));
        list1.stream().forEach(e->System.out.println(e));
        Stream<String> song = Stream.of("lalalalalala","lololo","hohoohoh","trolololololo","hehehe");
        


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
