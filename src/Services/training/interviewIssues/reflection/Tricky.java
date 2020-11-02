package Services.training.interviewIssues.reflection;

public class Tricky  {
    private String field;

    private Tricky(String field) {
        this.field = field;
    }

    void show() {
        System.out.println(field);
    }
}
