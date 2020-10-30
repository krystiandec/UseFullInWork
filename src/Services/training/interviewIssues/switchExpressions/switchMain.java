package Services.training.interviewIssues.switchExpressions;


import java.util.ArrayList;
import java.util.List;

import static Services.training.interviewIssues.switchExpressions.Priority.*;

public class switchMain {

    public static void displayOnConsole(Task task) {
        String priority = switch (task.getPriority()) {
            case LOW -> "Niski";
            case MEDIUM -> "Średni";
            case HIGH, URGENT -> "Pilne!";
//            default -> "Nieznany priorytet"; - potrzebne kiedy switch expression przechodzi
//            przez na przykład po stringach.
        };
        System.out.println(
                "Zadanie:\t\"" + task.getTaskName() + "\"\tma priorytet: " + priority + ".");
    }

    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Zmywanie naczyń", HIGH));
        taskList.add(new Task("Pościel łóżko", LOW));
        taskList.add(new Task("Odkurzyć", MEDIUM));
        taskList.add(new Task("Zrobić pranie", URGENT));

        taskList.forEach(task -> displayOnConsole(task));
        //Consumer jako sygnaturka - objekt do wyrażenia lambda
        //to funkcj przyjmująca jakąś wartość ale nie zwracająca nic (void)
        //np sout.
    }
}
