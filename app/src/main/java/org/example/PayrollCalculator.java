package org.example;

public class PayrollCalculator {
    public static final double HOURLY_RATE = 16.78;
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final int REGULAR_HOURS_LIMIT = 40;

    public static final double UNION_DUES = 10.00; // prob should be getter
    private static final double SOCIAL_SECURITY_RATE = 0.06;
    private static final double FEDERAL_INCOME_TAX_RATE = 0.14;
    private static final double STATE_INCOME_TAX_RATE = 0.05;

    private static final double STANDARD_INSURANCE_COST = 15.00;
    private static final double LARGE_FAMILY_INSURANCE_COST = 35.00;
    private static final int LARGE_FAMILY_SIZE = 3;


    public double calculateRegularPay(double hoursWorked) {
        notNegative(hoursWorked, "Hours worked");
        double regularHours = Math.min(hoursWorked, REGULAR_HOURS_LIMIT);
        return regularHours * HOURLY_RATE;
    }

    public double calculateOvertimePay(double hoursWorked) {
        notNegative(hoursWorked, "Hours worked");
        double overtimeHours = Math.max(hoursWorked - REGULAR_HOURS_LIMIT, 0.0);
        return overtimeHours * HOURLY_RATE * OVERTIME_MULTIPLIER;
    }

    public double calculateGrossPay(double hoursWorked) {
        return calculateRegularPay(hoursWorked) + calculateOvertimePay(hoursWorked);
    }

    public double calculateSocialSecurityTax(double grossPay) {
        notNegative(grossPay, "Gross pay");
        return grossPay * SOCIAL_SECURITY_RATE;
    }

    public double calculateFederalIncomeTax(double grossPay) {
        notNegative(grossPay, "Gross pay");
        return grossPay * FEDERAL_INCOME_TAX_RATE;
    }

    public double calculateStateIncomeTax(double grossPay) {
        notNegative(grossPay, "Gross pay");
        return grossPay * STATE_INCOME_TAX_RATE;
    }

    public double calculateInsuranceCost(int dependents) {
        notNegative(dependents, "Dependents");
        if (dependents >= LARGE_FAMILY_SIZE) {
            return LARGE_FAMILY_INSURANCE_COST;
        } else {
            return STANDARD_INSURANCE_COST;
        }
    }

    public double calculateTotalDeductions(double grossPay, int dependents) {
        notNegative(grossPay, "Gross pay");
        notNegative(dependents, "Dependents");

        return calculateSocialSecurityTax(grossPay)
                + calculateFederalIncomeTax(grossPay)
                + calculateStateIncomeTax(grossPay)
                + UNION_DUES
                + calculateInsuranceCost(dependents);
    }

    public double calculateNetPay(double grossPay, int dependents) {
        return grossPay - calculateTotalDeductions(grossPay, dependents);
    }

    private void notNegative(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " must be a non-negative number.");
        }
    }
}
