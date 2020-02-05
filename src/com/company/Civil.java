package com.company;

import java.text.DecimalFormat;

import static com.company.Contract.*;

public class Civil extends Taxes implements Command {

    @Override
    public void execute() {
        civilPrint();
    }

    public void civilPrint() {
        System.out.println("CIVIL CONTRACT");
        System.out.println("Basis for taxes " + TaxCalculator.income);
        commonSet();
        Taxes.exemptedValue = 0;
        Taxes.incomeCost = (this.getBasis() * 20) / 100;
        System.out.println("TaxCalculator.income tax cost (constant) " + Taxes.incomeCost);
        double taxBasis0 = calculateTaxBasis(this.getBasis(), Taxes.incomeCost);
        System.out.println("Exempted value = " + Taxes.exemptedValue);
        double advanceTax0 = calculateAdvanceTax(taxBasis0, this.getHealth2(), Taxes.exemptedValue);
        double salary = calculateSalary(TaxCalculator.income, this.getSum(), this.getHealth1(), advanceTax0);
    }

    public void commonSet() {
        this.setSum(calculateSocialInsurance(TaxCalculator.income));
        this.setBasis(calculateHealthBasis(TaxCalculator.income, this.getSum()));
        this.setHealth1(calculateHealthTax1(this.getBasis()));
        this.setHealth2(calculateHealthTax2(this.getBasis()));
    }
}
