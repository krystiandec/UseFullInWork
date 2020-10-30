package Services.training.interviewIssues.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzImprovedFor implements FizzBuzz{

    private List<Integer> exampleList;

    public void setExampleList(int from, int to) {
        List<Integer> exampleList = new ArrayList<>();
        if (from < to) {
            for (int i = from; i <= to; i++) {
                exampleList.add(i);
            }
            this.exampleList = exampleList;
        } else {
            System.out.println("niepoprawny zakres");
            this.exampleList = null;
        }
    }

    @Override
    public void print(int from, int to) {
        setExampleList(from,to);
        String f = "Fizz";
        String b = "Buzz";
    }
}
