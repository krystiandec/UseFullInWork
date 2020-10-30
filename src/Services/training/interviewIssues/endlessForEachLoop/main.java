package Services.training.interviewIssues.endlessForEachLoop;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Iterable<Integer> range = new Iterable<Integer>() {
            @NotNull
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public Integer next() {
                        return new Random().nextInt(101);
                    }
                };
            }
        };

        Iterable<Integer> range1 = () -> new Iterator<Integer>() {
            public boolean hasNext() {
                return true;
            }
            public Integer next() {
                return new Random().nextInt(101);
            }
        };

        for (Integer i : range1) {
            System.out.println(i);
        }

    }
}