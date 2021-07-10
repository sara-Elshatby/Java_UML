package lab2;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String enterdata ="";
        while(true) {

            System.out.print("Enter data :");
            enterdata = scanner.next();
            System.out.println("dats is :" + enterdata);
            if (enterdata.equals("stop") ) {
                break;
            }
        }

    }


}
