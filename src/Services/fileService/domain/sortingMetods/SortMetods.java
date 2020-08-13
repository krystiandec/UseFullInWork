package Services.fileService.domain.sortingMetods;

import java.util.*;

public class SortMetods {

    public static Set<String> setSort (Set<String> set){
        Set<String> sortedSet;
        List<String> sortList = new ArrayList<>(set);
        Collections.sort(sortList);
        sortedSet = new TreeSet<>(sortList);
        return sortedSet;
    }


}
