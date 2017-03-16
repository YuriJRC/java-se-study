package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Мария on 15.03.2017.
 */
public class OperationsBetweenAccounts {


    public void transferMoney(Account fromOne, Account toOther, int amount) throws IllegalArgumentException {
        if (fromOne == null || toOther == null) {
            throw new NullPointerException("Empty data");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can't be negative");
        }
        if (fromOne.equals(toOther)) {
            throw new IllegalArgumentException("Can't add money to your own account");
        }
        int balanceWithdraw = fromOne.getBalance();
        int y = balanceWithdraw - amount;
        if (y >= 0) {
            fromOne.setBalance(y);
            fromOne.setStatistics(y);

            int balanceDeposit = toOther.getBalance();
            int x = balanceDeposit + amount;
            toOther.setBalance(x);
            toOther.setStatistics(x);
        } else {
            throw new IllegalArgumentException("Balance can't be <0");
        }
    }
}
