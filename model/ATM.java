package model;

public class ATM {
    private int bills2 = 42;
    private int bills5 = 30;
    private int bills10 = 25;
    private int bills20 = 20;
    private int bills50 = 15;
    private int bills100 = 10;

    public int getTotalValue() {
        return (bills2 * 2) + (bills5 * 5) + (bills10 * 10)
             + (bills20 * 20) + (bills50 * 50) + (bills100 * 100);
    }

    public int getTotalBills() {
        return bills2 + bills5 + bills10 + bills20 + bills50 + bills100;
    }

    public void viewAvailableBills() {
        System.out.println("\n--AVAILABLE BILLS--");
        System.out.printf(" %d x $100\n %d x $50\n %d x $20\n %d x $10\n %d x $5\n %d x $2\n",
                bills100, bills50, bills20, bills10, bills5, bills2);
        System.out.println("----------------------");
        System.out.printf(" Total in ATM: $%d (%d bills)\n", getTotalValue(), getTotalBills());
    }

    public boolean canWithdraw(int amount) {
        int temp = amount;
        int[] bills = {100, 50, 20, 10, 5, 2};
        int[] stock = {bills100, bills50, bills20, bills10, bills5, bills2};

        for (int i = 0; i < bills.length; i++) {
            while (temp >= bills[i] && stock[i] > 0) {
                temp -= bills[i];
                stock[i]--;
            }
        }
        return temp == 0;
    }

    public void executeWithdrawal(int amount) {
        int temp = amount;
        int[] bills = {100, 50, 20, 10, 5, 2};
        int[] stock = {bills100, bills50, bills20, bills10, bills5, bills2};
        int[] used = new int[6];

        for (int i = 0; i < bills.length; i++) {
            while (temp >= bills[i] && stock[i] > 0) {
                temp -= bills[i];
                stock[i]--;
                used[i]++;
            }
        }

        // Atualiza os valores após o saque
        bills100 = stock[0];
        bills50  = stock[1];
        bills20  = stock[2];
        bills10  = stock[3];
        bills5   = stock[4];
        bills2   = stock[5];

        System.out.println("\n--BILLS DISPENSED--");
        for (int i = 0; i < bills.length; i++) {
            if (used[i] > 0) {
                System.out.printf(" %d x $%d\n", used[i], bills[i]);
            }
        }
        System.out.println("----------------------");
    }
}
