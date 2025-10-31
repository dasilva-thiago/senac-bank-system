package model;

public class Loan {
    private final double income;
    private final double interestRate = 6.47;

    public Loan(double income) {
        this.income = income;
    }

    public boolean isEligible() {
        return income >= 1600;
    }

    public double calculateLoanAmount() {
        return income * 5;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
