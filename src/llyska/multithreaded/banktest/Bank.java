package llyska.multithreaded.banktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] _accounts;
    private final Lock _bankLock = new ReentrantLock();
    private final Condition _sufficientFunds;

    public Bank(int size, double initialBalance) {
        _sufficientFunds = _bankLock.newCondition();
        _accounts = new double[size];
        for (int i = 0; i < _accounts.length; i++) {
            _accounts[i] = initialBalance;
        }
    }

    public double[] getAccounts() {
        return _accounts;
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        _bankLock.lock();
        try {
            while(_accounts[from] < amount) {
                _sufficientFunds.await();
            }
            if (_accounts[from] < amount) {
                return;
            }
            System.out.println(Thread.currentThread());

            _accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);

            _accounts[to] += amount;
            System.out.printf(" [Total Balance %10.2f]%n", getTotalBalance());
            _sufficientFunds.signalAll();
        } finally {
            _bankLock.unlock();
        }
    }

    private double getTotalBalance() {
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