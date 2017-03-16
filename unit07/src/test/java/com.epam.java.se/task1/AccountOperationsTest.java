package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Мария on 16.03.2017.
 */
public class AccountOperationsTest {
    private OperationsBetweenAccounts op;
    private Account account1;
    private Account account2;

    @Before
    public void init()throws Exception{
        op = new OperationsBetweenAccounts();
        account1 = new Account(500);
        account2 = new Account(1000);
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
    }

    @Test
            (expected = NullPointerException.class)
    public void NullPointerExceptionTest() throws Exception {
        op.transferMoney(null, null, 50);

        ReadFromFileSync sync = new ReadFromFileSync(null);
        ReadFromFileConcurrent concurrent = new ReadFromFileConcurrent(null);

        WriteToFile write = new WriteToFile();
        write.writeAccounts(null, null);
    }

    @Test
    public void AccountTest()throws Exception{
        assertTrue(account1.getBalance()==500);

        op.transferMoney(account1, account2, 100);
        assertTrue(account1.getStatistics().get(0)==400);
    }

}

