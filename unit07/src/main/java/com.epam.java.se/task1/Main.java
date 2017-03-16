package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Мария on 15.03.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Account account1 = new Account(1000);
        Account account2 = new Account(500);

        OperationsBetweenAccounts op = new OperationsBetweenAccounts();
        try {
            op.transferMoney(account1, account2, 50);
            op.transferMoney(account1, account2, 200);
            op.transferMoney(account1, account2, 100);
            op.transferMoney(account2, account1, 600);
            op.transferMoney(account2, account1, 100);

        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println(account1.getBalanceStatistics());
        System.out.println(account2.getBalanceStatistics());

//        WriteToFile writer = new WriteToFile();
//        writer.writeAccounts("ACCOUNTS.TXT", account1, account2);
//
//        ReadFromFile reader = new ReadFromFile("ACCOUNTS.TXT");
//        ReadFromFile reader2 = new ReadFromFile("ACCOUNTS.TXT");
//        ReadFromFile reader3 = new ReadFromFile("ACCOUNTS.TXT");
//        ReadFromFile reader4 = new ReadFromFile("ACCOUNTS.TXT");
//        ReadFromFile reader5 = new ReadFromFile("ACCOUNTS.TXT");
//        ReadFromFile reader6 = new ReadFromFile("ACCOUNTS.TXT");
//
//        reader.start();
//        reader2.start();
//        reader3.start();
//        reader4.start();
//        reader5.start();
//        reader6.start();
//
//        Thread.sleep(1000);
//
//        reader.join();
//        reader2.join();
//        reader3.join();
//        reader4.join();
//        reader5.join();
//        reader6.join();
//
//        reader.getListOfAccounts();
//        reader.showAccounts();
    }
}
