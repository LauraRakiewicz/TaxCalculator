package com.company;

import java.text.DecimalFormat;

public class Output {
    
    public void ordinaryPrint() {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("Ordinary contract");
        System.out.println("basis for taxes " + TaxCalculator.income);
        double cBasis = Taxes.colculatedBasis(TaxCalculator.income);
        System.out.println("Pension tax basis " + df00.format(Taxes.t_pension));
        System.out.println("Disability tax basis " + df00.format(Taxes.t_disabled));
        System.out.println("Illness insurance basis  " + df00.format(Taxes.s_illness));
        System.out.println("Health insurance basis: " + cBasis);
        Taxes.calculateInsurance(cBasis);
        System.out.println("Health insutance: 9% = " + df00.format(Taxes.t_health1) + " 7,75% = " + df00.format(Taxes.t_health2));
        System.out.println("Constant TaxCalculator.income tax cost " + Taxes.incomeCost);
        double taxBasis = cBasis - Taxes.incomeCost;
        double taxBasis0 = Double.parseDouble(df.format(taxBasis));
        System.out.println("Tax basis " + taxBasis + " rounded " + df.format(taxBasis0));
        Taxes.calculateBasis(taxBasis0);
        System.out.println("Advance for TaxCalculator.income tax 18 % = " + Taxes.advanceTax);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double exemtedTax = Taxes.advanceTax - Taxes.exemptedValue;
        System.out.println("Exempted tax = " + df00.format(exemtedTax));
        Taxes.calculateAdvance();
        Taxes.advanceTaxOffice0 = Double.parseDouble(df.format(Taxes.advanceTaxOffice));
        System.out.println("Advance for the tax office = " + df00.format(Taxes.advanceTaxOffice) + " rounded = "
                + df.format(Taxes.advanceTaxOffice0));
        double salary = TaxCalculator.income - ((Taxes.t_pension + Taxes.t_disabled + Taxes.s_illness) + Taxes.t_health1 + Taxes.advanceTaxOffice0);
        System.out.println();
        System.out.println("Net salary = " + df00.format(salary));
    }

    public void civilPrint() {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("CIVIL CONTRACT");
        System.out.println("Basis for taxes " + TaxCalculator.income);
        double oBasis = Taxes.colculatedBasis(TaxCalculator.income);
        System.out.println("Pension tax " + df00.format(Taxes.t_pension));
        System.out.println("Disability tax " + df00.format(Taxes.t_disabled));
        System.out.println("Illness insurance tax  " + df00.format(Taxes.s_illness));
        System.out.println("Basis for the health tax: " + oBasis);
        Taxes.calculateInsurance(oBasis);
        System.out.println("Healt tax: 9% = " + df00.format(Taxes.t_health1) + " 7,75% = " + df00.format(Taxes.t_health2));
        Taxes.exemptedValue = 0;
        Taxes.incomeCost = (oBasis * 20) / 100;
        System.out.println("TaxCalculator.income tax cost (constant) " + Taxes.incomeCost);
        double basisTax = oBasis - Taxes.incomeCost;
        double basisTax0 = Double.parseDouble(df.format(basisTax));
        System.out.println("Basis tax " + basisTax + " rouded " + df.format(basisTax0));
        Taxes.calculateBasis(basisTax0);
        System.out.println("Advance for TaxCalculator.income tax 18 % = " + Taxes.advanceTax);
        double taxTaken = Taxes.advanceTax;
        System.out.println("Tax taken = " + df00.format(taxTaken));
        Taxes.calculateAdvance();
        Taxes.advanceTaxOffice0 = Double.parseDouble(df.format(Taxes.advanceTaxOffice));
        System.out.println("Advance for tax office = " + df00.format(Taxes.advanceTaxOffice) + " rounded = "
                + df.format(Taxes.advanceTaxOffice0));
        double salary = TaxCalculator.income - ((Taxes.t_pension + Taxes.t_disabled + Taxes.s_illness) + Taxes.t_health1 + Taxes.advanceTaxOffice0);
        System.out.println();
        System.out.println("Net salary = " + df00.format(salary));
    }
}
