package com.company;


class TaxCalculator {

    public static double income = 0;
    public static char contractType = ' ';


    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        input.test();

        if (contractType == 'O') {
            output.ordinaryPrint();
        } else if (contractType == 'C') {
            output.civilPrint();
        } else {
            System.out.println("Unknown contract!");
        }
    }
}
