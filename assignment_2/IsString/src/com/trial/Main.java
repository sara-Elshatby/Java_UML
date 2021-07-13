package com.trial;

public class Main {

    public static void main(String[] args) {

        // write your code here
        String str1 = "summer";
        System.out.println("answer : " + isSTRINGG(str1));

        String str2 = "su11mer";
        System.out.println("answer : " + isSTRINGG(str2));

        String str3 = null;
        System.out.println("answer : " + isSTRINGG(str3));

    }

    private static Boolean isSTRINGG(String str) {
        return ((str != null) && (!str.equals(""))) && str.chars().allMatch(Character::isLetter);
    }
}
