package Services.training.interviewIssues.nameStatistics;

import Services.training.interviewIssues.nameStatistics.childs.Gender;

import java.nio.file.Path;

public class TestClass {
    public static void main(String[] args) {

        SolutionMethods methods = new SolutionMethods(
                Path.of("src/Services/training/interviewIssues/nameStatistics/Popular_Baby_Names.csv"));

        methods.display10MostPopularChildNames();
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("Najpopulatniejsze imię żeńskie:");
        methods.display10MostPopularChildNames(Gender.FEMALE);
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("Trzy najpopularniejsze litery na jakie zaczynają się imiona:");
        methods.theMostPopulatLetterName();
    }
}
