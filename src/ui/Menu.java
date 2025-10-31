package ui;

import java.util.Scanner;
import model.Account;
import model.ATM;
import service.AccountService;
import service.ATMService;
import service.LoanService;

public class Menu {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(1600);
        ATM atm = new ATM();
        int option;
        
        while (true) {
            System.out.println("\n========== SENAC BANK ==========");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Check Loan");
            System.out.println("5 - View Available Bills");
            System.out.println("0 - Exit");
            System.out.println("================================");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            
            switch (option) {
                case 0 -> {
                    System.out.println("\nThank you for using Senac Bank!");
                    scanner.close();
                    return;
                }
                case 1 -> AccountService.checkBalance(account);
                case 2 -> AccountService.deposit(scanner, account);
                case 3 -> ATMService.withdraw(scanner, account, atm);
                case 4 -> LoanService.checkLoan(scanner);
                case 5 -> atm.viewAvailableBills();
                default -> System.out.println("Invalid option. Try again!");
            }
            
            System.out.println("\nPress ENTER to continue...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}