package com.tw.assign4.splitwise;


import java.util.*;

public class SettlementService {

    public List<Transactions> settle(List<Expense> expenses) {
        List<Transactions> transactions = new ArrayList<>();

        // 1. Calculate net balance per person
        for (Expense e : expenses) {
            double share = e.getAmountPaid() / e.getParticipants().size();
            for (String person : e.getParticipants()) {
                if (!person.equals(e.getExpensePaidBy())) {
                    transactions.add(new Transactions(person, e.getExpensePaidBy(), share));
                }
            }

        }
        return transactions;
    }
}





