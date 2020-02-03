package com.company;

import java.text.DecimalFormat;

public class Contract {
    public static double calculateSocialInsurance(double basis) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        Taxes.t_pension = (basis * 9.76) / 100;
        Taxes.t_disabled = (basis * 1.5) / 100;
        Taxes.s_illness = (basis * 2.45) / 100;
        System.out.println("Pension tax basis " + df00.format(Taxes.t_pension));
        System.out.println("Disability tax basis " + df00.format(Taxes.t_disabled));
        System.out.println("Illness insurance basis  " + df00.format(Taxes.s_illness));
        return Taxes.t_pension + Taxes.t_disabled + Taxes.s_illness;
    }

    public static double calculateHealthBasis(double basis, double sum) {
        double healthBasis = basis - sum;
        System.out.println("Health insurance basis: " + healthBasis);
        return healthBasis;
    }

    public static double calculateHealthTax1(double basis) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        double t_health1 = (basis * 9) / 100;
        System.out.println("Health insurance: 9% = " + df00.format(t_health1));
        return t_health1;
    }

    public static double calculateHealthTax2(double basis) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        double t_health2 = (basis * 7.75) / 100;
        System.out.println("Health insurance: 7,75% = " + df00.format(t_health2));
        return t_health2;
    }
    public static double calculateTaxBasis(double basis, double incomeCost) {
        DecimalFormat df = new DecimalFormat("#");
        double taxBasis = basis - incomeCost;
        double taxBasis0 = Double.parseDouble(df.format(taxBasis));
        System.out.println("Tax basis " + taxBasis + " rounded " + df.format(taxBasis0));
        return taxBasis0;
    }
    public static double calculateAdvanceTax(double basis, double health2, double exemptedValue) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");
        double advanceBasis = (basis * 18) / 100;
        System.out.println("Advance for income tax 18 % = " + advanceBasis);
        double advanceTax = advanceBasis - health2 - exemptedValue;
        double exemptedTax = advanceBasis - exemptedValue;
        System.out.println("Exempted tax = " + df00.format(exemptedTax));
        double advanceTax0 = Double.parseDouble(df.format(advanceTax));
        System.out.println("Advance for the tax office = " + df00.format(advanceTax) + " rounded = "
                + df.format(advanceTax0));
        return advanceTax0;
    }

    public static double calculateSalary(double income, double sum, double health1, double advanceTax0) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        double salary = income - (sum + health1 + advanceTax0);
        System.out.println();
        System.out.println("Net salary = " + df00.format(salary));
        return salary;
    }


}
