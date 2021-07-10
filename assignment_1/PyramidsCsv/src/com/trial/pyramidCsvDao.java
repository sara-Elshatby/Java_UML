package com.trial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class pyramidCsvDao implements pyramidinterface {

    public List<pyramid> readPyramidFromCSV(String filename)  {
        List<pyramid> pyramidsArraylist = new ArrayList<pyramid>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("C:\\pyramids.csv"));
            String line = br.readLine();



            do {
                line = br.readLine();
                if(line != null){
                    String[] attributes = line.split(",");
                    pyramid newPyramidObject = creatPyramid(attributes);
                    pyramidsArraylist.add(newPyramidObject);

                    for(String part : attributes){
                        System.out.println(part+" ");

                    }
                    System.out.println("");
                }
            }while (line != null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return pyramidsArraylist;
    }
    public pyramid creatPyramid(String[] metadata){
        String height = metadata[7];

        if (height.equals("")){
            height  = "0.0";
        }
        pyramid pr = new pyramid(metadata[0],metadata[2],metadata[4],Double.parseDouble(height)) ;

        return pr;
    }

}