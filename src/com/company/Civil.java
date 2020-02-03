package com.company;

import java.text.DecimalFormat;

import static com.company.Contract.*;

public class Civil implements Command {
    double sum;
    double cBasis;
    double health1;
    double health2;

    @Override
    public void execute() {
        civilPrint();
    }

    public void civilPrint() {
        System.out.println("CIVIL CONTRACT");
        System.out.println("Basis for taxes " + TaxCalculator.income);
        double sum = calculateSocialInsurance(TaxCalculator.income);
        double cBasis = calculateHealthBasis(TaxCalculator.income, sum);
        double health1 = calculateHealthTax1(cBasis);
        double health2 = calculateHealthTax2(cBasis);
        Taxes.exemptedValue = 0;
        Taxes.incomeCost = (cBasis * 20) / 100;
        System.out.println("TaxCalculator.income tax cost (constant) " + Taxes.incomeCost);
        double taxBasis0 = calculateTaxBasis(cBasis, Taxes.incomeCost);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double advanceTax0 = calculateAdvanceTax(taxBasis0, health2, Taxes.exemptedValue);
        double salary = calculateSalary(TaxCalculator.income, sum, health1, advanceTax0);
    }
}
