package com.trial;

import joinery.DataFrame;

import java.io.IOException;

public class Joinery {
    public static void main(String args[]) throws IOException {
        DataFrame<Object> df1 = DataFrame.readCsv("src/main/resources/titanic.csv")
                .retain ("pclass", "survived", "sex" , "age")
                .groupBy (row -> row.get (2))
                .describe();
        System.out.println ("Statistics data based on gender");
        System.out.println (df1.toString ());

    }
}
