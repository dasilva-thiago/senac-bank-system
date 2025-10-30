import java.util.Scanner;

public class senac_bank {
    private static double balance = 1600.0;
    private static int bills2 = 42;
    private static int bills5 = 30;
    private static int bills10 = 25;
    private static int bills20 = 20;
    private static int bills50 = 15;
    private static int bills100 = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("\n ========== SENAC BANK ==========");
            System.out.println(" 1 - Check Balance");
            System.out.println(" 2 - Deposit Amount");
            System.out.println(" 3 - Withdraw");
            System.out.println(" 4 - Check Loan");
            System.out.println(" 5 - View Available Bills");
            System.out.println(" 0 - Exit");
            System.out.println(" ===============================");
            System.out.print(" Choose operation: ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("\n Thank you for using Senac Bank!");
                    scanner.close();
                    return;
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkLoan(scanner);
                    break;
                case 5:
                    viewAvailableBills();
                    break;
                default:
                    System.out.println("\n Invalid option! Try again.");
            }

            System.out.println("\n Press ENTER to continue...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    private static void checkBalance() {
        System.out.println("\n --CHECK BALANCE--");
        System.out.printf(" Your current balance is: $%.2f\n", balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.println("\n --DEPOSIT--");
        System.out.print(" Amount to deposit: $");
        double deposit = scanner.nextDouble();

        if (deposit > 0) {
            balance += deposit;
            System.out.println(" Deposit completed successfully!");
            System.out.printf(" Your current balance is: $%.2f\n", balance);
        } else {
            System.out.println(" Invalid amount for deposit!");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.println("\n --WITHDRAW--");
        System.out.printf(" Available balance: $%.2f\n", balance);
        System.out.print(" How much do you want to withdraw? $");
        double withdrawal = scanner.nextDouble();

        if (withdrawal <= 0) {
            System.out.println(" Invalid amount for withdrawal!");
        } else if (withdrawal > balance) {
            System.out.println(" Error: Insufficient balance!");
        } else {
            if (checkWithdrawalAvailability((int) withdrawal)) {
                executeWithdrawal((int) withdrawal);
                balance -= withdrawal;
                System.out.println("\n Withdrawal completed successfully!");
                System.out.printf(" Your new balance is: $%.2f\n", balance);
            } else {
                System.out.println("\n Error: Not enough bills available to complete this withdrawal.");
                System.out.println(" Try a different amount or check available bills.");
            }
        }
    }

    private static void checkLoan(Scanner scanner) {
        System.out.println("\n --CHECK LOAN--");
        System.out.print(" Enter your monthly income: $");
        double income = scanner.nextDouble();

        if (income >= 1600) {
            double loan = 5 * income;
            System.out.printf(" Amount available for loan: $%.2f\n", loan);
            System.out.println(" Would you like to take the loan? (Interest: 6.47% per month)");
        } else {
            System.out.println(" Insufficient income for loan.");
            System.out.println(" Minimum income required: $1600.00");
        }
    }

    private static void viewAvailableBills() {
        System.out.println("\n --AVAILABLE BILLS IN ATM--");
        System.out.printf(" %d x $100.00 = $%d\n", bills100, bills100 * 100);
        System.out.printf(" %d x $50.00 = $%d\n", bills50, bills50 * 50);
        System.out.printf(" %d x $20.00 = $%d\n", bills20, bills20 * 20);
        System.out.printf(" %d x $10.00 = $%d\n", bills10, bills10 * 10);
        System.out.printf(" %d x $5.00 = $%d\n", bills5, bills5 * 5);
        System.out.printf(" %d x $2.00 = $%d\n", bills2, bills2 * 2);
        System.out.println(" ----------------------");
        
        int totalValue = (bills100 * 100) + (bills50 * 50) + (bills20 * 20) + 
                        (bills10 * 10) + (bills5 * 5) + (bills2 * 2);
        int totalBills = bills100 + bills50 + bills20 + bills10 + bills5 + bills2;
        
        System.out.printf(" Total in ATM: $%d in %d bills\n", totalValue, totalBills);
    }

    private static boolean checkWithdrawalAvailability(int amount) {
        int valueInt = amount;
        int tempB100 = bills100, tempB50 = bills50, tempB20 = bills20;
        int tempB10 = bills10, tempB5 = bills5, tempB2 = bills2;

        while (valueInt >= 100 && tempB100 > 0) {
            valueInt -= 100;
            tempB100--;
        }
        while (valueInt >= 50 && tempB50 > 0) {
            valueInt -= 50;
            tempB50--;
        }
        while (valueInt >= 20 && tempB20 > 0) {
            valueInt -= 20;
            tempB20--;
        }
        while (valueInt >= 10 && tempB10 > 0) {
            valueInt -= 10;
            tempB10--;
        }
        while (valueInt >= 5 && tempB5 > 0) {
            valueInt -= 5;
            tempB5--;
        }
        while (valueInt >= 2 && tempB2 > 0) {
            valueInt -= 2;
            tempB2--;
        }

        return valueInt == 0;
    }

    private static void executeWithdrawal(int amount) {
        int valueInt = amount;
        int used100 = 0, used50 = 0, used20 = 0;
        int used10 = 0, used5 = 0, used2 = 0;

        System.out.println("\n --BILLS DISPENSED--");

        while (valueInt >= 100 && bills100 > 0) {
            valueInt -= 100;
            bills100--;
            used100++;
        }
        if (used100 > 0) {
            System.out.printf(" %d x $100.00\n", used100);
        }

        while (valueInt >= 50 && bills50 > 0) {
            valueInt -= 50;
            bills50--;
            used50++;
        }
        if (used50 > 0) {
            System.out.printf(" %d x $50.00\n", used50);
        }

        while (valueInt >= 20 && bills20 > 0) {
            valueInt -= 20;
            bills20--;
            used20++;
        }
        if (used20 > 0) {
            System.out.printf(" %d x $20.00\n", used20);
        }

        while (valueInt >= 10 && bills10 > 0) {
            valueInt -= 10;
            bills10--;
            used10++;
        }
        if (used10 > 0) {
            System.out.printf(" %d x $10.00\n", used10);
        }

        while (valueInt >= 5 && bills5 > 0) {
            valueInt -= 5;
            bills5--;
            used5++;
        }
        if (used5 > 0) {
            System.out.printf(" %d x $5.00\n", used5);
        }

        while (valueInt >= 2 && bills2 > 0) {
            valueInt -= 2;
            bills2--;
            used2++;
        }
        if (used2 > 0) {
            System.out.printf(" %d x $2.00\n", used2);
        }

        int totalBills = used100 + used50 + used20 + used10 + used5 + used2;
        System.out.println(" ----------------------");
        System.out.printf(" Total: %d bills\n", totalBills);
    }
}