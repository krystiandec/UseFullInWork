package Services;

import Services.JFrameTrainings.Student;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Map<String,Set<String>> stringStringMap = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        String[] tab={"419171003C2","419170200","02Y0039","419380400","419380200",
                "419540000","419380300","419380100","419170100","419171032C2","419170001C1",
                "419171104","419170200","419380400","419540000","419170100"};
        for (String s:tab) {
            set1.add(s+"* ");
        }
        System.out.println(set1);
    }
}
