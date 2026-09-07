package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayrollCalculatorTest {
    private static final double TOLERANCE = 0.0001;

    PayrollCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new PayrollCalculator();
    }

    @Test
    public void testZeroHoursRegularPay() {
        assertEquals(0.00, calculator.calculateRegularPay(0), TOLERANCE);
    }

    @Test
    public void testOneHourRegularPay() {
        assertEquals(16.78, calculator.calculateRegularPay(1), TOLERANCE);
    }

    @Test
    public void testThirtyHoursRegularPay() {
        assertEquals(503.40, calculator.calculateRegularPay(30), TOLERANCE);
    }

    @Test
    public void testFortyHoursRegularPay() {
        assertEquals(671.20, calculator.calculateRegularPay(40), TOLERANCE);
    }

    @Test
    public void testRegularPayStopsAtFortyHours() {
        assertEquals(671.20, calculator.calculateRegularPay(41), TOLERANCE);
    }

    @Test
    public void testNegativeHoursForRegularPay() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateRegularPay(-1));
    }

    @Test
    public void testZeroHoursOvertimePay() {
        assertEquals(0.00, calculator.calculateOvertimePay(0), TOLERANCE);
    }

    @Test
    public void testOneHourOvertimePay() {
        assertEquals(0.00, calculator.calculateOvertimePay(1), TOLERANCE);
    }

    @Test
    public void testFortyHoursOvertimePay() {
        assertEquals(0.00, calculator.calculateOvertimePay(40), TOLERANCE);
    }

    @Test
    public void testFortyOneHoursOvertimePay() {
        assertEquals(25.17, calculator.calculateOvertimePay(41), TOLERANCE);
    }

    @Test
    public void testFortyFiveHoursOvertimePay() {
        assertEquals(125.85, calculator.calculateOvertimePay(45), TOLERANCE);
    }

    @Test
    public void testNegativeHoursForOvertimePay() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateOvertimePay(-1));
    }

    @Test
    public void testZeroHoursGrossPay() {
        assertEquals(0.00, calculator.calculateGrossPay(0), TOLERANCE);
    }

    @Test
    public void testOneHourGrossPay() {
        assertEquals(16.78, calculator.calculateGrossPay(1), TOLERANCE);
    }

    @Test
    public void testThirtyHoursGrossPay() {
        assertEquals(503.40, calculator.calculateGrossPay(30), TOLERANCE);
    }

    @Test
    public void testFortyHoursGrossPay() {
        assertEquals(671.20, calculator.calculateGrossPay(40), TOLERANCE);
    }

    @Test
    public void testFortyFiveHoursGrossPay() {
        assertEquals(797.05, calculator.calculateGrossPay(45), TOLERANCE);
    }

    @Test
    public void testNegativeHoursForGrossPay() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateGrossPay(-1));
    }

    @Test
    public void testZeroGrossPaySocialSecurityTax() {
        assertEquals(0.00, calculator.calculateSocialSecurityTax(0), TOLERANCE);
    }

    @Test
    public void testOneDollarGrossPaySocialSecurityTax() {
        assertEquals(0.06, calculator.calculateSocialSecurityTax(1), TOLERANCE);
    }

    @Test
    public void testOneHundredDollarGrossPaySocialSecurityTax() {
        assertEquals(6.00, calculator.calculateSocialSecurityTax(100), TOLERANCE);
    }

    @Test
    public void testNegativeGrossPaySocialSecurityTax() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateSocialSecurityTax(-1));
    }

    @Test
    public void testZeroGrossPayFederalIncomeTax() {
        assertEquals(0.00, calculator.calculateFederalIncomeTax(0), TOLERANCE);
    }

    @Test
    public void testOneDollarGrossPayFederalIncomeTax() {
        assertEquals(0.14, calculator.calculateFederalIncomeTax(1), TOLERANCE);
    }

    @Test
    public void testOneHundredDollarGrossPayFederalIncomeTax() {
        assertEquals(14.00, calculator.calculateFederalIncomeTax(100), TOLERANCE);
    }

    @Test
    public void testNegativeGrossPayFederalIncomeTax() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateFederalIncomeTax(-1));
    }

    @Test
    public void testZeroGrossPayStateIncomeTax() {
        assertEquals(0.00, calculator.calculateStateIncomeTax(0), TOLERANCE);
    }

    @Test
    public void testOneDollarGrossPayStateIncomeTax() {
        assertEquals(0.05, calculator.calculateStateIncomeTax(1), TOLERANCE);
    }

    @Test
    public void testOneHundredDollarGrossPayStateIncomeTax() {
        assertEquals(5.00, calculator.calculateStateIncomeTax(100), TOLERANCE);
    }

    @Test
    public void testNegativeGrossPayStateIncomeTax() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateStateIncomeTax(-1));
    }

    @Test
    public void testZeroDependentsInsuranceCost() {
        assertEquals(15.00, calculator.calculateInsuranceCost(0), TOLERANCE);
    }

    @Test
    public void testOneDependentInsuranceCost() {
        assertEquals(15.00, calculator.calculateInsuranceCost(1), TOLERANCE);
    }

    @Test
    public void testTwoDependentsInsuranceCost() {
        assertEquals(15.00, calculator.calculateInsuranceCost(2), TOLERANCE);
    }

    @Test
    public void testThreeDependentsInsuranceCost() {
        assertEquals(35.00, calculator.calculateInsuranceCost(3), TOLERANCE);
    }

    @Test
    public void testFourDependentsInsuranceCost() {
        assertEquals(35.00, calculator.calculateInsuranceCost(4), TOLERANCE);
    }

    @Test
    public void testNegativeDependentsInsuranceCost() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateInsuranceCost(-1));
    }

    @Test
    public void testZeroGrossPayTotalDeductions() {
        assertEquals(25.00, calculator.calculateTotalDeductions(0, 0), TOLERANCE);
    }

    @Test
    public void testOneDollarGrossPayTotalDeductions() {
        assertEquals(25.25, calculator.calculateTotalDeductions(1, 1), TOLERANCE);
    }

    @Test
    public void testManyDollarsTotalDeductions() {
        assertEquals(50.00, calculator.calculateTotalDeductions(100, 2), TOLERANCE);
    }

    @Test
    public void testThreeDependentBoundaryTotalDeductions() {
        assertEquals(70.00, calculator.calculateTotalDeductions(100, 3), TOLERANCE);
    }

    @Test
    public void testRegularPayrollTotalDeductions() {
        assertEquals(170.85, calculator.calculateTotalDeductions(503.40, 4), TOLERANCE);
    }

    @Test
    public void testNegativeGrossPayTotalDeductions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalDeductions(-1, 0));
    }

    @Test
    public void testNegativeDependentsTotalDeductions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalDeductions(100, -1));
    }

    @Test
    public void testZeroGrossPayNetPay() {
        assertEquals(-25.00, calculator.calculateNetPay(0, 0), TOLERANCE);
    }

    @Test
    public void testOneDollarGrossPayNetPay() {
        assertEquals(-24.25, calculator.calculateNetPay(1, 1), TOLERANCE);
    }

    @Test
    public void testManyDollarsNetPay() {
        assertEquals(50.00, calculator.calculateNetPay(100, 2), TOLERANCE);
    }

    @Test
    public void testThreeDependentBoundaryNetPay() {
        assertEquals(30.00, calculator.calculateNetPay(100, 3), TOLERANCE);
    }

    @Test
    public void testRegularPayrollNetPay() {
        assertEquals(332.55, calculator.calculateNetPay(503.40, 4), TOLERANCE);
    }

    @Test
    public void testOvertimePayrollNetPay() {
        assertEquals(572.7875, calculator.calculateNetPay(797.05, 0), TOLERANCE);
    }

    @Test
    public void testNegativeGrossPayNetPay() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateNetPay(-1, 0));
    }

    @Test
    public void testNegativeDependentsNetPay() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateNetPay(100, -1));
    }


}
