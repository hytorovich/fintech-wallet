package com.fintech.wallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final long accountId;
    private final BigDecimal amount;
    private final LocalDateTime createdAt;


    private final TransactionType type;

    public Transaction(long accountId, TransactionType type, BigDecimal amount) {
        this.accountId = accountId;
        this.createdAt = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }


    public long getAccountId() {
        return accountId;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "accountId=" + accountId +
                ", type=" + type +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}

