package com.company;

public class Contract {


    public static void calculateAdvance() {
        Taxes.advanceTaxOffice = Taxes.advanceTax - Taxes.t_health2 - Taxes.exemptedValue;
    }

    public static void calculateBasis(double basis) {
        Taxes.advanceTax = (basis * 18) / 100;
    }

    public static double colculatedBasis(double basis) {
        Taxes.t_pension = (basis * 9.76) / 100;
        Taxes.t_disabled = (basis * 1.5) / 100;
        Taxes.s_illness = (basis * 2.45) / 100;
        return (basis - Taxes.t_pension - Taxes.t_disabled - Taxes.s_illness);
    }

    public static void calculateInsurance(double basis) {
        Taxes.t_health1 = (basis * 9) / 100;
        Taxes.t_health2 = (basis * 7.75) / 100;
    }
}
