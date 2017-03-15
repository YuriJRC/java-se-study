package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Мария on 15.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(200);
        Account account2 = new Account(100);

        OperationsBetweenAccounts op = new OperationsBetweenAccounts();
        try {
            op.transferMoney(account1, account2, 100);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
    }
}
