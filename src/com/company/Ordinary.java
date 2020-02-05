package com.company;

import static com.company.Contract.*;

public class Ordinary extends Taxes implements Command {

    @Override
    public void execute() {
        ordinaryPrint();
    }

    public void ordinaryPrint() {
        System.out.println("Ordinary contract");
        System.out.println("basis for taxes " + TaxCalculator.income);
        commonSet();
        System.out.println("Constant TaxCalculator.income tax cost " + Taxes.incomeCost);
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
