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
                    .map(e -> String.valueOf(e) + "-" + (e % 3 == 0 ? fizz : "") + (e % 5 == 0 ? buzz : ""))
                    .filter(e -> e.contains(fizz) || e.contains(buzz))
                    .forEach(System.out::println);
        } else {
            System.out.println("niepoprawny zakres");
        }
    }
}
