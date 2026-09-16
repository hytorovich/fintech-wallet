package com.fintech.wallet;

import com.fintech.wallet.model.Account;
import com.fintech.wallet.model.Transaction;
import com.fintech.wallet.model.TransactionType;
import com.fintech.wallet.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User nikolay = new User(
                1,
                22,
                "Nikolay",
                "gol@gmail.com"
        );

        Account account = new Account(1, nikolay);

        account.deposit(new BigDecimal("1000"));
        account.deposit(new BigDecimal("200"));

        boolean firstWithdraw = account.withdraw(new BigDecimal("300"));
        boolean secondWithdraw = account.withdraw(new BigDecimal("5000"));

        System.out.println("Баланс: " + account.getBalance());
        System.out.println("Ожидаемый баланс: 900");

        System.out.println();

        System.out.println("withdraw(300): " + firstWithdraw);
        System.out.println("Ожидается: true");

        System.out.println("withdraw(5000): " + secondWithdraw);
        System.out.println("Ожидается: false");

        System.out.println();

        System.out.println("Количество транзакций: "
                + account.getTransactions().size());
        System.out.println("Ожидается: 3");

        System.out.println();

        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
        System.out.println(account.getOwner().getName());
    }
}