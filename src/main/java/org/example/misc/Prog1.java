package org.example.misc;

import java.util.ArrayList;
import java.util.List;

public class Prog1 {

    public static void main(String[] args) {
        Prog1 app = new Prog1();
        List<Integer> result = app.solve(20);
        result.forEach(System.out::println);
    }

    private List<Integer> solve(int num) {
        List<Integer> result = new ArrayList<>();
        while (num > 1) {
            result.add(num);
            num = (0 == num % 2) ? (num / 2) : (num * 3) + 1;
        }
        return result;
    }
}
