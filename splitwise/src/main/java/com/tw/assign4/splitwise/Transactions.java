package com.tw.assign4.splitwise;

public class Transactions {
    private final String fromPayer;
    private final String toPayee;
    private final double amountToBePaid;

    public Transactions(String fromPayer, String to, double amount) {
        this.fromPayer = fromPayer;
        this.toPayee = to;
        this.amountToBePaid = amount;
    }

    public String getFromPayer() {
        return fromPayer;
    }

    public String getToPayee() {
        return toPayee;
    }

    public double getAmount() {
        return amountToBePaid;
    }

    @Override
    public String toString() {
        return fromPayer + " pays " + toPayee + " " + (int) amountToBePaid;
    }
}
