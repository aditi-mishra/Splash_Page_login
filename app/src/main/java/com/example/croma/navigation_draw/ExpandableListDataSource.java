package com.example.croma.navigation_draw;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Croma on 14-02-2018.
 */

public class ExpandableListDataSource {
    public static Map<String, List<String>> getData(){
        Map<String,List<String>> expandanbleListData = new TreeMap<>();
        List<String> exp = Arrays.asList("Experiment 1", "Experiment 2","Experiment 3","Experiment 4");
        List<String> sub = Arrays.asList("Introduction","Schematic","Code");
        expandanbleListData.put(exp.get(0),sub);
        expandanbleListData.put(exp.get(1),sub);
        expandanbleListData.put(exp.get(2),sub);
        expandanbleListData.put(exp.get(3),sub);
        return expandanbleListData;

    }
}
