package service;

import java.util.Scanner;
import model.Loan;

public class LoanService {
    public static void checkLoan(Scanner scanner) {
        System.out.print("\nEnter your monthly income: $");
        double income = scanner.nextDouble();

        Loan loan = new Loan(income);
        if (loan.isEligible()) {
            System.out.printf("Loan available: $%.2f\n", loan.calculateLoanAmount());
            System.out.printf("Interest rate: %.2f%% per month\n", loan.getInterestRate());
        } else {
            System.out.println("You are not eligible. Minimum income: $1600.");
        }
    }
}
