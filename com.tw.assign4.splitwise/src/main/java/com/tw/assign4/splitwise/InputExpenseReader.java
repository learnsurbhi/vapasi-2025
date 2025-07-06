package com.tw.assign4.splitwise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputExpenseReader {

    public List<Expense> parse(String filePath) throws IOException {
            List<Expense> expenses = new ArrayList<>();
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (line.isBlank()) continue;
                String[] parts = line.split(" spent | for ");
                String payer = parts[0].trim();
                double amount = Double.parseDouble(parts[1].trim());
                List<String> participants = Arrays.asList(parts[3].split(","));
                expenses.add(new Expense(payer, amount, participants));
            }
            return expenses;
        }
    }


