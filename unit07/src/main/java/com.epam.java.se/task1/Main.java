package com.epam.java.se.task1;

import javax.naming.OperationNotSupportedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Мария on 15.03.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1000);

        Account account2 = new Account(500);

        OperationsBetweenAccounts op = new OperationsBetweenAccounts();
        try {
            op.transferMoney(account1, account2, 50);
            op.transferMoney(account1, account2, 200);
            op.transferMoney(account1, account2, 100);
            op.transferMoney(account2, account1, 600);
            op.transferMoney(account2, account1, 100);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println(account1.getBalanceStatistics());
        System.out.println(account2.getBalanceStatistics());

        WriteToFile writer = new WriteToFile();
        writer.writeAccounts("ACCOUNTS.TXT", account1, account2);

        ReadFromFileSync reader = new ReadFromFileSync("ACCOUNTS.TXT");
        ReadFromFileSync reader2 = new ReadFromFileSync("ACCOUNTS.TXT");
        ReadFromFileSync reader3 = new ReadFromFileSync("ACCOUNTS.TXT");
        ReadFromFileSync reader4 = new ReadFromFileSync("ACCOUNTS.TXT");
        ReadFromFileSync reader5 = new ReadFromFileSync("ACCOUNTS.TXT");
        ReadFromFileSync reader6 = new ReadFromFileSync("ACCOUNTS.TXT");

        reader.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
        reader6.start();

        reader.join();
        reader2.join();
        reader3.join();
        reader4.join();
        reader5.join();
        reader6.join();

        ReadFromFileConcurrent newReader = new ReadFromFileConcurrent("ACCOUNTS.TXT");
        ReadFromFileConcurrent newReader2 = new ReadFromFileConcurrent("ACCOUNTS.TXT");
        ReadFromFileConcurrent newReader3 = new ReadFromFileConcurrent("ACCOUNTS.TXT");
        ReadFromFileConcurrent newReader4 = new ReadFromFileConcurrent("ACCOUNTS.TXT");
        ReadFromFileConcurrent newReader5 = new ReadFromFileConcurrent("ACCOUNTS.TXT");
        ReadFromFileConcurrent newReader6 = new ReadFromFileConcurrent("ACCOUNTS.TXT");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(newReader);
        executor.execute(newReader2);
        executor.execute(newReader3);
        executor.execute(newReader4);
        executor.execute(newReader5);
        executor.execute(newReader6);
        executor.shutdown();
    }
}
