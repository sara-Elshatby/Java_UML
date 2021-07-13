package com.trial;

import java.util.function.BiPredicate;

public class Main {

    public static void main(String[] args) {

        // write your code here
        String stringa = "milk";
        String stringb = "coffee";
        String result = betterstring(stringa,stringb,(s1,s2)->s1.length()>s2.length());
        System.out.print(result +" is the answer");

    }
    public static String betterstring(String s1, String s2, BiPredicate<String,String>p){
        Boolean ans = p.test(s1,s2);
        if (s1.length()>s2.length())
            return s1;
        else;
        return s2;

    }

}

