package com.trial;

import java.io.IOException;
import java.util.*;

import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        pyramidCsvDao pDao = new pyramidCsvDao();
        List<pyramid> pyramids = pDao.readPyramidFromCSV("C:\\pyramids.csv");
        List<String> countingsite = new ArrayList<>();
        List<Double> heightMedian = new ArrayList<>();
        int i = 0;
        Collections.sort(pyramids,new sortingclass());

        for (pyramid p : pyramids) {
            System.out.println("#" + (i++) + p);
        }
        for (pyramid S : pyramids){
            countingsite.add(S.getSite());


        }
        Map <String,Integer> counts = (Map<String, Integer>) countingsite.parallelStream()

        .collect(Collectors.toConcurrentMap(w->w,w->1,Integer::sum));

        System.out.print(counts);



    }




}
