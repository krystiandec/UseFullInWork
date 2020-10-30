package Services.training.interviewIssues.FizzBuzz;

public class FizzBuzzMain {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz1 = new FizzBuzzImplClassic();
        FizzBuzz fizzBuzz2 = new FizzBuzzImprovedFor();
        FizzBuzz fizzBuzz3 = new FizzBuzzStream();
/*        fizzBuzz1.print(0,15);
        System.out.println("@@@@@@@@@@@@@@@@@");
        fizzBuzz2.print(0,15);
        System.out.println("@@@@@@@@@@@@@@@@@");*/
        fizzBuzz3.print(0,15);

//        aby uzupełnić tablicę kolejnymi liczbami jest taka metoda w klasie Arrays.setAll(przesyłamy albo tworzymy listę , podajemy algorytm
//        który ma uzupełnić tablicę no i->i+1) -> Arrays.setAll(new int[rozmiar], i->i+1).
    }
}
