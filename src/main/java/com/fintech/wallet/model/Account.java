package com.fintech.wallet.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final long id;
    private final User owner;
    private BigDecimal balance = BigDecimal.ZERO;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(long id, User owner) {
        this.id = id;
        this.owner = owner;
    }

    public List<Transaction> getTransactions() {
        return List.copyOf(transactions);
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
        transactions.add(new Transaction(this.id, TransactionType.DEPOSIT, amount));
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
        transactions.add(new Transaction(this.id, TransactionType.WITHDRAWAL, amount));
        return true;
    }
}
