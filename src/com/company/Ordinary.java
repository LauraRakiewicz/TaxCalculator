package com.company;

import java.text.DecimalFormat;

public class Ordinary implements Command {

    @Override
    public void execute() {
        ordinaryPrint();
    }

    public void ordinaryPrint() {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("Ordinary contract");
        System.out.println("basis for taxes " + TaxCalculator.income);
        double cBasis = Contract.colculatedBasis(TaxCalculator.income);
        System.out.println("Pension tax basis " + df00.format(Taxes.t_pension));
        System.out.println("Disability tax basis " + df00.format(Taxes.t_disabled));
        System.out.println("Illness insurance basis  " + df00.format(Taxes.s_illness));
        System.out.println("Health insurance basis: " + cBasis);
        Contract.calculateInsurance(cBasis);
        System.out.println("Health insutance: 9% = " + df00.format(Taxes.t_health1) + " 7,75% = " + df00.format(Taxes.t_health2));
        System.out.println("Constant TaxCalculator.income tax cost " + Taxes.incomeCost);
        double taxBasis = cBasis - Taxes.incomeCost;
        double taxBasis0 = Double.parseDouble(df.format(taxBasis));
        System.out.println("Tax basis " + taxBasis + " rounded " + df.format(taxBasis0));
        Contract.calculateBasis(taxBasis0);
        System.out.println("Advance for TaxCalculator.income tax 18 % = " + Taxes.advanceTax);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double exemtedTax = Taxes.advanceTax - Taxes.exemptedValue;
        System.out.println("Exempted tax = " + df00.format(exemtedTax));
        Contract.calculateAdvance();
        Taxes.advanceTaxOffice0 = Double.parseDouble(df.format(Taxes.advanceTaxOffice));
        System.out.println("Advance for the tax office = " + df00.format(Taxes.advanceTaxOffice) + " rounded = "
                + df.format(Taxes.advanceTaxOffice0));
        double salary = TaxCalculator.income - ((Taxes.t_pension + Taxes.t_disabled + Taxes.s_illness) + Taxes.t_health1 + Taxes.advanceTaxOffice0);
        System.out.println();
        System.out.println("Net salary = " + df00.format(salary));
    }
}
