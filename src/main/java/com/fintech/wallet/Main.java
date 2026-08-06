package com.fintech.wallet;

import com.fintech.wallet.model.Account;
import com.fintech.wallet.model.User;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
    User nikolay = new User(1, 22, "Nikolay", "gol@gmail.com");
        System.out.println(nikolay.getId());
        System.out.println(nikolay.getName());
        System.out.println(nikolay.getEmail());
        System.out.println(nikolay);
        System.out.println(nikolay.isAdult());
        nikolay.deactivate();
        System.out.println(nikolay.isActive());
        nikolay.activate();
        System.out.println(nikolay.isActive());
        nikolay.changeEmail("nikolay2@gmail.com");
        System.out.println(nikolay.getEmail());

        Account nikolayPay = new Account(1, nikolay);
        System.out.println("Account id: " + nikolayPay.getId());
        System.out.println("Owner: " + nikolayPay.getOwner().getName());
        System.out.println("Balance: " + nikolayPay.getBalance());
        System.out.println(nikolayPay);

        nikolayPay.deposit(new BigDecimal("1000"));
        nikolayPay.withdraw(new BigDecimal("50"));
        System.out.println(nikolayPay.getBalance());
}
}
