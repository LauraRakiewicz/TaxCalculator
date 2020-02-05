package com.company;

public class Taxes {

    // social taxes
    public static double t_pension = 0; // 9,76% of the income
    public static double t_disabled = 0; // 1,5% of the income
    public static double s_illness = 0; // 2,45% of the income

    // constant variables (values for ordinary type)
    public static double incomeCost = 111.25;
    public static double exemptedValue = 46.33; // reduced value 46,33 PLN

    // vars returned & used by functions
    private double sum;
    private double basis;
    private double health1;
    private double health2;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getBasis() {
        return basis;
    }

    public void setBasis(double basis) {
        this.basis = basis;
    }

    public double getHealth1() {
        return health1;
    }

    public void setHealth1(double health1) {
        this.health1 = health1;
    }

    public double getHealth2() {
        return health2;
    }

    public void setHealth2(double health2) {
        this.health2 = health2;
    }
}
