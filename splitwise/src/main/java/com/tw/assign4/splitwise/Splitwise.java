package com.tw.assign4.splitwise;

import java.io.IOException;
import java.util.List;

public class Splitwise {

        public static void main(String[] args) throws IOException {
            InputExpenseReader parser = new InputExpenseReader();
            List<Expense> expenses = parser.parse("splitwise/src/main/resources/InputExpenses.txt");

            SettlementService service = new SettlementService();
            List<Transactions> transactions = service.settle(expenses);

            System.out.println("List of transactions -");
            transactions.forEach(System.out::println);
        }
    }

