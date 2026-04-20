package org.example;

import java.util.HashMap;
import java.util.Map;

public class MakeBillChange {

    int[] bills = { 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };

    public static void main(String[] args) {
        MakeBillChange app = new MakeBillChange();
        int qty = app.makeChange(999);
        System.out.println("Smallest number of bills is: " + qty);
        app.makeChangeWithCounter(999);
    }

    private int makeChange(int amount) {
        if (amount < 1) {
            return 0;
        }
        int qty = 0;
        for (int bill : bills) {
            if (amount / bill > 0) {
                qty += amount / bill;
                amount -= (amount / bill) * bill;
            }
        }
        return qty;
    }

    private void makeChangeWithCounter(int amount) {
        if (amount < 1) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            int qty = amount / bill;
            if (qty > 0) {
                map.put(bill, qty);
                amount -= qty * bill;
            }
        }
        System.out.println(map);
    }
}
