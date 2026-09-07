package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PayrollCalculator payroll = new PayrollCalculator();

        System.out.println("Welcome to the Payroll Program!\n");

        System.out.print("How many hours did you work this week? ");
        double hours = input.nextDouble();

        System.out.print("How many children do you have? ");
        int children = input.nextInt();

        double gross = payroll.calculateGrossPay(hours);
        double socialSecurity = payroll.calculateSocialSecurityTax(gross);
        double federalTax = payroll.calculateFederalIncomeTax(gross);
        double stateTax = payroll.calculateStateIncomeTax(gross);
        double insurance = payroll.calculateInsuranceCost(children);
        double net = payroll.calculateNetPay(gross, children);

        System.out.println("\nPayroll Stub:\n");
        System.out.printf("    Hours:      %.2f%n", hours);
        System.out.printf("    Rate:       %.2f $/hr%n", PayrollCalculator.HOURLY_RATE);
        System.out.printf("    Gross:      $ %.2f%n%n", gross);
        System.out.printf("    SocSec:     $ %.2f%n", socialSecurity);
        System.out.printf("    FedTax:     $ %.2f%n", federalTax);
        System.out.printf("    StTax:      $ %.2f%n", stateTax);
        System.out.printf("    Union:      $ %.2f%n", PayrollCalculator.UNION_DUES);
        System.out.printf("    Ins:        $ %.2f%n%n", insurance);
        System.out.printf("    Net:        $ %.2f%n%n", net);

        System.out.println("Thank you for using the Payroll Program!");
        input.close();
    }
}
