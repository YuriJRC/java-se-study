package com.epam.java.se.task1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Мария on 15.03.2017.
 */
public class Account implements Serializable {
    private int id;
    private static int staticId=1;
    private static final long serialVersionUID = 1L;
    private int balance;
    private ArrayList<Integer> balanceStatistics;

    public Account(int balance) {
        id=staticId++;
        if (balance < 0) {
            throw new IllegalArgumentException("balance cant' be negative");
        }
        this.balance = balance;
        balanceStatistics = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance cant' be negative");
        }
        this.balance = balance;
    }

    public ArrayList<Integer> getStatistics() {
        if (balanceStatistics==null){
            throw new NullPointerException("Empty data");
        }
        return balanceStatistics;
    }

    public void setStatistics(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cant' be negative");
        }
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
        String format = "Account %d {balance= %d} Statistics: "+ balanceStatistics;
        return String.format(format, id, balance);
    }
}