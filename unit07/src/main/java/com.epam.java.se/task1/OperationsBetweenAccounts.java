package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Мария on 15.03.2017.
 */
public class OperationsBetweenAccounts extends Thread {

    public synchronized void transferMoney(Account fromOne, Account toOther, int amount) throws OperationNotSupportedException {
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
