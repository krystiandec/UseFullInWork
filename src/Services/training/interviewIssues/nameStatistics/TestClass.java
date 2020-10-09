package Services.training.interviewIssues.nameStatistics;

import Services.training.interviewIssues.nameStatistics.childs.Gender;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {

        /*SolutionMethods methods = new SolutionMethods(
                Path.of("src/Services/training/interviewIssues/nameStatistics/Popular_Baby_Names - Kopia.csv"));*/
        SolutionMethods methods = new SolutionMethods(
                Path.of("src/Services/training/interviewIssues/nameStatistics/Popular_Baby_Names.csv"));
        methods.display10MostPopularChildNames();
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        methods.display10MostPopularChildNames(Gender.FEMALE);
    }
}
