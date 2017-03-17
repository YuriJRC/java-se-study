package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Мария on 16.03.2017.
 */
public class AccountOperationsTest {
    private OperationsBetweenAccounts op;
    private Account account1;
    private Account account2;
    private WriteToFile writer;

    @Before
    public void init() throws Exception {
        op = new OperationsBetweenAccounts();
        account1 = new Account(500);
        account2 = new Account(1000);
        writer = new WriteToFile();
    }

    @Test
            (expected = IllegalArgumentException.class)
    public void IllegalArgumentExceptionTest() throws Exception {
        Account account = new Account(-500);
        account.setBalance(-100);
        account.setStatistics(-5);
        account.getBalance();

        op.transferMoney(account, account, 500);

        Account account2 = new Account(500);
        op.transferMoney(account, account2, -200);
        op.transferMoney(account, account2, 6000);
    }

    @Test
            (expected = NullPointerException.class)
    public void NullPointerExceptionTest() throws Exception {
        op.transferMoney(null, null, 50);

        ReadFromFileSync sync = new ReadFromFileSync(null);
        ReadFromFileConcurrent concurrent = new ReadFromFileConcurrent(null);

        writer.writeAccounts(null, null);
    }

    @Test
    public void AccountTest() throws Exception {
        assertTrue(account1.getBalance() == 500);

        op.transferMoney(account1, account2, 100);
        assertTrue(account1.getStatistics().get(0) == 400);
    }

    @Test
    public void OperationsTest() throws Exception {
        op.transferMoney(account1, account2, 300);

        assertTrue(account1.getBalance() == 200);
        assertTrue(account2.getBalance() == 1300);
    }

    @Test
    public void WriteToFileTest() throws Exception {
        File file = new File("ACCOUNTS2.TXT");

        op.transferMoney(account1, account2, 400);

        WriteToFile writer = new WriteToFile();
        writer.writeAccounts("ACCOUNTS2.TXT", account1, account2);

        assertTrue(file.exists() && file.length() > 20);
    }

    @Test
    public void ReadFromFileTest() throws Exception {
        ReadFromFileSync sync = new ReadFromFileSync("ACCOUNTS2.TXT");
        ArrayList <Account> newAccounts = sync.getListOfAccounts();

        ReadFromFileConcurrent concurrent = new ReadFromFileConcurrent("ACCOUNTS2.TXT");
        ArrayList <Account> newAccounts2 = concurrent.getListOfAccounts();

        assertTrue(newAccounts.get(0).getBalance()==100 &&
                newAccounts2.get(0).getBalance()==100);
        assertTrue(newAccounts.get(1).getStatistics().get(0)==1400 &&
                newAccounts2.get(1).getStatistics().get(0)==1400);

    }
}