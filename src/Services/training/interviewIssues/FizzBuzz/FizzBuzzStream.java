package Services.training.interviewIssues.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzStream implements FizzBuzz {

    @Override
    public void print(int from, int to) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        List<Integer> array = new ArrayList<>();
        if (from < to) {
            for (int i = from; i <= to; i++) {
                array.add(i);
            }
            array.stream()
                    .filter(e->e%3==0 || e%5==0)
                    .map(e -> String.valueOf(e) + "-" + (e % 3 == 0 ? fizz : "") + (e % 5 == 0 ? buzz : ""))
                    .forEach(System.out::println);
        } else {
            System.out.println("niepoprawny zakres");
        }
        /**
         * uwaga: Strumienie w java są leniwe i dopóki na końcu strumienia nie wywołamy metody
         * collect albo forEach to nie będzie on przetwarzany.
         * zapis w postaci :
         * stream.forEach(Main::check); - oznacza : dla każdego elementu strumienia odwołaj się do metody
         * metoda rangeClosed - można wykorzystać do stworzenia strumienia liczb. a następnie go zapisać
         * do tablicy - listy albo po prostu dalej jako strumień przetwarzać*/
    }
}
