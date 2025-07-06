package com.tw.assign4.splitwise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SplitwiseTest {

    private  static InputExpenseReader reader;
    private static Path resourceFilePath;

    @BeforeAll
    public static void setup()  {

        reader = new InputExpenseReader();
        resourceFilePath = Paths.get("src/test/java/com/tw/assign4/splitwise/expenses2.txt");
    }
    @Test
    void testSplitwise() throws IOException {
        List<Expense> expenses = reader.parse(resourceFilePath.toString());

        SettlementService service = new SettlementService();
        List<Transactions> transactions = service.settle(expenses);

        assertEquals(13, transactions.size());
        assertTrue(transactions.stream().anyMatch(t -> t.getFromPayer().equals("A") && t.getToPayee().equals("B")));
    }
  
}