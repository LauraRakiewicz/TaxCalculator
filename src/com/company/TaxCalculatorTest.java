package com.company;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    private final Contract contract = new Contract();

    @org.junit.jupiter.api.Test
    void calculateSocialInsuranceTest() {
        assertEquals(137.10, Contract.calculateSocialInsurance(1000));
    }

    @org.junit.jupiter.api.Test
    void calculateHealthBasisTest() {
        assertEquals(862.90, Contract.calculateHealthBasis(1000, 137.10));
    }

    @org.junit.jupiter.api.Test
    void calculateHealthTax1Test() {
        assertEquals(77.661, Contract.calculateHealthTax1(862.90));
    }

    @org.junit.jupiter.api.Test
    void calculateHealthTax2Test() {
        assertEquals(66.87474999999999, Contract.calculateHealthTax2(862.9));
    }

    @org.junit.jupiter.api.Test
    void calculateTaxBasisTest() {
        assertEquals(752.0, Contract.calculateTaxBasis(862.9, 111.25));
        assertEquals(690.0, Contract.calculateTaxBasis(862.9, 172.58));
    }

    @org.junit.jupiter.api.Test
    void calculateAdvanceTaxTest() {
        assertEquals(22.0, Contract.calculateAdvanceTax(752.0,66.87474999999999, 46.33));
        assertEquals(57.0, Contract.calculateAdvanceTax(690.0, 66.87474999999999, 0));
    }

    @org.junit.jupiter.api.Test
    void calculateSalaryTest() {
        assertEquals(763.239, Contract.calculateSalary(1000, 137.1, 77.661, 22.0));
        assertEquals(728.239, Contract.calculateSalary(1000, 137.1, 77.661, 57.0));
    }
}