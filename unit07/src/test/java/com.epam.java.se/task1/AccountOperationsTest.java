package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Мария on 16.03.2017.
 */
public class AccountOperationsTest {
    private OperationsBetweenAccounts op;

    @Before
    public void init()throws Exception{
        op = new OperationsBetweenAccounts();
    }

    @Test
            (expected = IllegalArgumentException.class)
    public void IllegalArgumentExceptionTest() throws Exception {
        Account account = new Account(-500);
        account.setBalance(-100);
        account.setStatistics(-5);

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

}

