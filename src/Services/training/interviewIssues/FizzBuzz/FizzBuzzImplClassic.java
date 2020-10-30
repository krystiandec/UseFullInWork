package Services.training.interviewIssues.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzImplClassic implements FizzBuzz {
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
        setExampleList(from, to);
        String f = "Fizz";
        String b = "Buzz";
        if (this.exampleList != null) {
            for (int i = 0; i < exampleList.size(); i++) {
                int current = exampleList.get(i);
                if (current % 3 == 0 && current % 5 == 0) {
                    System.out.println(current + "-" + f + b);
                    continue;
                }else if(current%3==0){
                    System.out.println(current + "-" + f);
                    continue;
                }else if(current%5==0){
                    System.out.println(current + "-" + b);
                    continue;
                }
            }
        } else {
            System.out.println("Popraw zakres");
        }
    }
}
