package Services.fileService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WhereAreUsedChangedComponentsInSetOfAssemblies {

    private void showATableOfUsages(Map<String,List<String>> map){
        Set<String> uniqueValues = new HashSet<>();
        for (String s: map.keySet()) {
            for (String stringList: map.get(s)) {
                uniqueValues.add(stringList);
            }


        }
    }
}
