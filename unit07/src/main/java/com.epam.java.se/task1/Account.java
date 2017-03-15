package com.epam.java.se.task1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Мария on 15.03.2017.
 */
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    private int balance;
    private ArrayList <Integer> balanceStatistics;

    public Account(int balance) {
        this.balance = balance;
        balanceStatistics = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Integer> getBalanceStatistics() {
        return balanceStatistics;
    }

    public void setStatistics(int amount) {
        balanceStatistics.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (balance != account.balance) return false;
        return balanceStatistics != null ? balanceStatistics.equals(account.balanceStatistics) : account.balanceStatistics == null;
    }

    @Override
    public int hashCode() {
        int result = balance;
        result = 31 * result + (balanceStatistics != null ? balanceStatistics.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}