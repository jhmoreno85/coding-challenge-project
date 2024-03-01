package org.example;

public class MakeBillChange {

    int[] bills = { 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {
        MakeBillChange app = new MakeBillChange();
        int qty = app.makeChange(999);
        System.out.println("Smallest number of bills is: " + qty);
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
}
