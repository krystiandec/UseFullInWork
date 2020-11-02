package Services.training.interviewIssues.reflection;

import java.lang.reflect.Constructor;

public class Runner {
    public static void main(String[] args) {
        System.out.println();
        try {
            Class<?> cl = Class.forName("Services.training.interviewIssues.reflection.Tricky");
            Constructor<?> cons = cl.getDeclaredConstructor();

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
