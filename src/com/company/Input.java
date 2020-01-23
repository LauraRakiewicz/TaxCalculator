package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Input {
    public void test() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.print("Provide income: ");
            TaxCalculator.income = Double.parseDouble(br.readLine());

            System.out.print("Contract type: (O)rdinary, (C)ivil: ");
            TaxCalculator.contractType = br.readLine().charAt(0);

        } catch (Exception ex) {
            System.out.println("Incorrect value");
            System.err.println(ex);
            return;
        }
    }
}
