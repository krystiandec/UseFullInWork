package Services.training.interviewIssues.FizzBuzz;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzzImplClassic implements FizzBuzz {
    private Map<Integer, String> integerStringMap = new HashMap<>();

    public void setIntegerStringMap(int from, int to) {
        String f = "Fizz";
        String b = "Buzz";
        if (from < to) {
            for (int i = from; i <= to; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    integerStringMap.put(i, f + b);
                    System.out.println(i + "-" + f + b);
                    continue;
                } else if (i % 3 == 0) {
                    integerStringMap.put(i, f);
                    System.out.println(i + "-" + f);
                    continue;
                } else if (i % 5 == 0) {
                    integerStringMap.put(i, b);
                    System.out.println(i + "-" + b);
                    continue;
                }
            }
        } else {
            System.out.println("niepoprawny zakres");
        }
    }

    @Override
    public void print(int from, int to) {
        setIntegerStringMap(from, to);

    }
}
