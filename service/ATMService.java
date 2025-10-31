package service;

import java.util.Scanner;
import model.ATM;
import model.Account;

public class ATMService {
    public static void withdraw(Scanner scanner, Account account, ATM atm) {
        System.out.print("\nHow much do you want to withdraw? $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance!");
            return;
        }
        if (!atm.canWithdraw((int) amount)) {
            System.out.println("ATM cannot dispense the requested amount with available bills.");
            return;
        }

        atm.executeWithdrawal((int) amount);
        account.withdraw(amount);
        System.out.printf("\nWithdrawal completed! New balance: $%.2f\n", account.getBalance());
    }
}
