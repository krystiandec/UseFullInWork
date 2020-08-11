package Services.fileService.domain;

import java.util.ArrayList;
import java.util.List;

public class Counters {

    public static int columnCounter(String s) {
        int counter = 0;
        int index;
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("|") != -1) {
            index = sb.indexOf("|");
            sb.delete(0,index+1);
            counter++;
        }
        if (counter != 0) counter += 1;
        return counter;
    }
    public static List<Integer> positionOfSeparators(String s){
        List<Integer> listOfSeparatorPositions = new ArrayList<>();
        for (int i =0 ; i<s.length();i++){
            if (s.charAt(i)=='|'){
                listOfSeparatorPositions.add(i);
            }
        }
        return listOfSeparatorPositions;
    }
}
