package llyska.sinchronized.banktest;

public class Bank {
    private final double[] _accounts;

    public Bank(int size, double initialBalance) {
        _accounts = new double[size];
        for (int i = 0; i < _accounts.length; i++) {
            _accounts[i] = initialBalance;
        }
    }

    public double[] getAccounts() {
        return _accounts;
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (_accounts[from] < amount) {
            wait();
        }
        if (_accounts[from] < amount) {
            return;
        }
        _accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d \t", amount, from, to);

        _accounts[to] += amount;
        System.out.printf(" [Total Balance %10.2f]%n", getTotalBalance());

        notifyAll();
    }

    private synchronized double getTotalBalance() {
        double sumBalances = 0;

        for (double balance : _accounts) {
            sumBalances += balance;
        }

        return sumBalances;
    }

    public int size() {
        return _accounts.length;
    }
}