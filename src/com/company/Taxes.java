package com.company;

public class Taxes {

    // social taxes
    public static double t_pension = 0; // 9,76% of the income
    public static double t_disabled = 0; // 1,5% of the income
    public static double s_illness = 0; // 2,45% of the income

    // health taxes
    public static double incomeCost = 111.25;
    public static double t_health1 = 0; // 9% of the incomeCost
    public static double t_health2 = 0; // 7,75 % of the incomeCost
    public static double advanceTax = 0; // income tax (18%) advance
    public static double exemptedValue = 46.33; // reduced value 46,33 PLN
    public static double advanceTaxOffice = 0;
    public static double advanceTaxOffice0 = 0;


    public static void calculateAdvance() {
        advanceTaxOffice = advanceTax - t_health2 - exemptedValue;
    }

    public static void calculateBasis(double basis) {
        advanceTax = (basis * 18) / 100;
    }

    public static double colculatedBasis(double basis) {
        t_pension = (basis * 9.76) / 100;
        t_disabled = (basis * 1.5) / 100;
        s_illness = (basis * 2.45) / 100;
        return (basis - t_pension - t_disabled - s_illness);
    }

    public static void calculateInsurance(double basis) {
        t_health1 = (basis * 9) / 100;
        t_health2 = (basis * 7.75) / 100;
    }
}
