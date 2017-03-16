package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Мария on 15.03.2017.
 */
public class OperationsBetweenAccounts extends Thread {
//        private Account fromOne;
//        private Account toOther;


    public synchronized void transferMoney(Account fromOne, Account toOther, int amount) throws OperationNotSupportedException {
        if (fromOne == null || toOther == null) {
            throw new NullPointerException("Empty data");
        }
        if (amount < 0) {
            throw new OperationNotSupportedException("Amount can't be negative");
        }
        if (fromOne.equals(toOther)) {
            throw new OperationNotSupportedException("Can't add money to your own account");
        }
        int balanceWithdraw = toOther.getBalance();
        int y = balanceWithdraw - amount;
        if (y >= 0) {
            toOther.setBalance(y);
            toOther.setStatistics(y);

            int balanceDeposit = fromOne.getBalance();
            int x = balanceDeposit + amount;
            fromOne.setBalance(x);
            fromOne.setStatistics(x);
        } else {
            throw new OperationNotSupportedException("Balance can't be <0");
        }
    }
}
