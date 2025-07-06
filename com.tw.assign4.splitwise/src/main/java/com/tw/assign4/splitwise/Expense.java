package com.tw.assign4.splitwise;

import java.util.List;

public class Expense{

    private final String expensePaidBy;
    private final double amountPaid;
    private final List<String> participants;

    public Expense(String expensePaidBy, double amountPaid, List<String> participants) {
        this.expensePaidBy = expensePaidBy;
        this.amountPaid = amountPaid;
        this.participants = participants;
    }

    public String getExpensePaidBy() {
        return expensePaidBy;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public List<String> getParticipants() {
        return participants;
    }
}

