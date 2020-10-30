package Services.training.interviewIssues.switchExpressions;

public class Task {

    private String taskName;
    private Priority priority;

    public Task(String taskName, Priority priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
