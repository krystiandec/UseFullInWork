package Services.training.interviewIssues.nameStatistics;

import Services.training.interviewIssues.nameStatistics.childs.Gender;

import java.io.IOException;
import java.nio.file.Path;

public class TestClass {
    public static void main(String[] args) {

        SolutionMethods methods = null;
        try {
            methods = new SolutionMethods(
                    Path.of("src/Services/training/interviewIssues/nameStatistics/Popular_Baby_Names_test.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        methods.displayMostPopularChildNames(10);
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("Najpopulatniejsze imię żeńskie:");
        methods.displayMostPopularChildNames(1,Gender.FEMALE);
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("Trzy najpopularniejsze litery na jakie zaczynają się imiona:");
        methods.theMostPopulatLetterName(3);
    }
}
