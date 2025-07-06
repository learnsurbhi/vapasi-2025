package com.tw.assign4.splitwise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class InputExpenseReaderTest {
    private  static InputExpenseReader reader;
    private static Path resourceFilePath;

    @BeforeAll
    public static void setup()  {

        reader = new InputExpenseReader();
        resourceFilePath = Paths.get("src/test/java/com/tw/assign4/splitwise/expenses.txt");
    }


    @Test
    void testReadExpensesFromResourceFile() throws IOException {
        List<Expense> expenses = reader.parse(resourceFilePath.toString());

        assertFalse(expenses.isEmpty());
        Expense first = expenses.getFirst();
        assertNotNull(first.getExpensePaidBy());
        assertTrue(first.getAmountPaid() > 0);
        assertNotNull(first.getParticipants());
    }


}