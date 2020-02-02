package com.company;

import java.text.DecimalFormat;

import static com.company.Contract.*;

public class Civil implements Command {

    @Override
    public void execute() {
        civilPrint();
    }

    public void civilPrint() {
        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        System.out.println("CIVIL CONTRACT");
        System.out.println("Basis for taxes " + TaxCalculator.income);
        double sum = calculateSocialInsurance(TaxCalculator.income);
        double oBasis = calculateHealthBasis(TaxCalculator.income, sum);
        double health1 = calculateHealthTax1(oBasis);
        double health2 = calculateHealthTax2(oBasis);
        Taxes.exemptedValue = 0;
        Taxes.incomeCost = (oBasis * 20) / 100;
        System.out.println("TaxCalculator.income tax cost (constant) " + Taxes.incomeCost);
        double taxBasis0 = calculateTaxBasis(oBasis, Taxes.incomeCost);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double advanceTax0 = calculateAdvanceTax(taxBasis0, health2, Taxes.exemptedValue);
        calculateSalary(TaxCalculator.income, sum, health1, advanceTax0);

    }
}
