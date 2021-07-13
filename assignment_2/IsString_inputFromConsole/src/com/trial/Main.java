package com.trial;


import java.util.Scanner;


public class Main {



    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String test= scanner.nextLine();              //reads string
        String test2 = null;
        System.out.print("contain all Alphabet: "+ alphabetonly(test));



    }

    private static boolean alphabetonly(String test) {
        return ((test != null) &&(!test.equals(""))  && test.chars().allMatch(Character:: isLetter) );
    }



}