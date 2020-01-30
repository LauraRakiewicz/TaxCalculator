package com.company;


class TaxCalculator {

    public static double income = 0;
    public static char contractType = ' ';

    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();
        input.test();
        test();
    }

    public static void test() {
        if (contractType == 'O') {
            printContract(new Ordinary());
        } else if (contractType == 'C') {
            printContract(new Civil());
        } else {
            System.out.println("Unknown contract!");
        }
    }

    public static void printContract(Command command) {
        command.execute();
    }
}


