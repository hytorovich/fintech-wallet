package com.fintech.wallet.model;

import java.math.BigDecimal;

public class Account {
    private long id;
    private User owner;
    private BigDecimal balance = BigDecimal.ZERO; // подсмотрел, не знал эку команду, а ноль из-за инт не принимался

    public Account(long id, User owner) {
        this.id = id;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account {" +
                "id=" + id +
                ", owner= " + owner.getName() +
                ", balance= " + balance +
                '}';
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }
        balance = balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount == null) {
            return false;
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (balance.compareTo(amount) < 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }
}
