package service;

import java.util.Scanner;
import model.Account;

public class AccountService {
    public static void checkBalance(Account account) {
        System.out.printf("\nYour current balance is: $%.2f\n", account.getBalance());
    }

    public static void deposit(Scanner scanner, Account account) {
        System.out.print("\nAmount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit completed successfully!");
            System.out.printf("New balance: $%.2f\n", account.getBalance());
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }
}
