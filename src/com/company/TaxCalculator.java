package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class TaxCalculator {

    public static double income = 0;
    public static char contractType = ' ';


    public static void main(String[] args) {
        Output output = new Output();

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Provide income: ");
            income = Double.parseDouble(br.readLine());

            System.out.print("Contract type: (O)rdinary, (C)ivil: ");
            contractType = br.readLine().charAt(0);


        } catch (Exception ex) {
            System.out.println("Incorrect value");
            System.err.println(ex);
            return;
        }

        if (contractType == 'O') {
            output.ordinaryPrint();
        } else if (contractType == 'C') {
            output.civilPrint();
        } else {
            System.out.println("Unknown contract!");
        }
    }


}
