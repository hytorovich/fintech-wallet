package com.fintech.wallet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    public void testThrows() {
        int a = 0;
        int b = 0;
        int c = a / b;

    }

    private User nikolay;
    private Account nikolayPay;

    @BeforeEach
    void setUp() {
        nikolay = new User(1, 20, "Nikolay", "ogo@gmail.com");
        nikolayPay = new Account(1, nikolay);
    }

    @Test
    public void testBalance() {
        nikolayPay.deposit(new BigDecimal(1000));
        assertEquals(new BigDecimal(1000), nikolayPay.getBalance());
    }

    @Test
    public void testWithdraw() {
        nikolayPay.deposit(new BigDecimal(1000));
        assertTrue(nikolayPay.withdraw(new BigDecimal(700)));
        assertEquals(new BigDecimal(300), nikolayPay.getBalance());
    }

    @Test
    public void withdrawReturnsFalseWhenBalanceIsInsufficient() {
        nikolayPay.deposit(new BigDecimal(1000));
        assertFalse(nikolayPay.withdraw(new BigDecimal(7000)));
        assertEquals(new BigDecimal(1000), nikolayPay.getBalance());
        assertEquals(1, nikolayPay.getTransactions().size());
    }

    @Test
    public void throwTest() {
        AccountTest test = new AccountTest();
        assertThrows(ArithmeticException.class, () -> test.testThrows());
    }

    @Test
    public void throwTest2() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }

    ;

    @Test
    public void negativeAmount() {
        assertFalse(nikolayPay.withdraw(new BigDecimal("-1000")));
        assertEquals(0, nikolayPay.getTransactions().size());
        assertEquals(BigDecimal.ZERO, nikolayPay.getBalance());
    }

    @Test
    public void transactionChange() {
        nikolayPay.deposit(new BigDecimal(1000));
        assertThrows(UnsupportedOperationException.class, () -> nikolayPay.getTransactions().clear());
    }
}
