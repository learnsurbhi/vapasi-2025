package com.tw.assign4.splitwise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SettlementServiceTest {

    private static SettlementService settlementService;

    @BeforeAll
    public static  void setup() {
        settlementService = new SettlementService();
    }

    @Test
    void testThreeParticipants() {
        Expense expense = new Expense("B", 90.0, List.of("A", "B", "C"));

        List<Transactions> result = settlementService.settle(List.of(expense));

        assertEquals(2, result.size());

        Map<String, Double> expected = Map.of(
                "A", 30.0,
                "C", 30.0
        );

        for (Transactions t : result) {
            assertEquals("B", t.getToPayee());
            assertTrue(expected.containsKey(t.getFromPayer()));
            assertEquals(expected.get(t.getFromPayer()), t.getAmount(), 0.001);
        }
    }

    @Test
    void testOnlyPayer() {
        Expense expense = new Expense("A", 100.0, List.of("A"));

        List<Transactions> result = settlementService.settle(List.of(expense));

        assertTrue(result.isEmpty());
    }

    @Test
    void testEmptyExpenses() {
        List<Transactions> result = settlementService.settle(Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}