package llyska.sinchronized.banktest;

public class TransferRunnable implements Runnable {
    private final Bank _bank;
    private final int _fromAccount;
    private final double _maxAmount;
    private final int DELAY = 10;

    public TransferRunnable(Bank bank, int from, double max) {
        _bank = bank;
        _fromAccount = from;
        _maxAmount = max;
    }

    @Override
    public void run() {
        try {
            int toAccount = (int) (_bank.size() * Math.random());
            double amount = _maxAmount * Math.random();
            _bank.transfer(_fromAccount, toAccount, amount);
            Thread.sleep((int) (DELAY * Math.random()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
