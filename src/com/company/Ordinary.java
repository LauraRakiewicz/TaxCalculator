package com.company;

import java.text.DecimalFormat;

import static com.company.Contract.*;

public class Ordinary implements Command {

    @Override
    public void execute() {
        ordinaryPrint();
    }

    public void ordinaryPrint() {
        System.out.println("Ordinary contract");
        System.out.println("basis for taxes " + TaxCalculator.income);
        double sum = calculateSocialInsurance(TaxCalculator.income);
        double oBasis = calculateHealthBasis(TaxCalculator.income, sum);
        double health1 = calculateHealthTax1(oBasis);
        double health2 = calculateHealthTax2(oBasis);
        System.out.println("Constant TaxCalculator.income tax cost " + Taxes.incomeCost);
        double taxBasis0 = calculateTaxBasis(oBasis, Taxes.incomeCost);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double advanceTax0 = calculateAdvanceTax(taxBasis0, health2, Taxes.exemptedValue);
        double salary = calculateSalary(TaxCalculator.income, sum, health1, advanceTax0);
    }
}
