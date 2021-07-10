package com.trial;

import java.util.Arrays;
import java.util.Comparator;

public class sortingclass implements Comparator<pyramid>{
   public int compare(pyramid a,pyramid b){
       return(int) (a.Height-b.Height);
   }
}
