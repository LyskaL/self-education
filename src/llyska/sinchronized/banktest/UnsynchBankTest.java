package llyska.sinchronized.banktest;

public class UnsynchBankTest {
    private static final int NACCOUNTS = 100;
    private static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable run = new TransferRunnable(bank, i, INITIAL_BALANCE);
            Thread thread = new Thread(run);
            thread.start();
        }
    }
}
