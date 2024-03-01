package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigzagString {

    private static final String EMPTY = "";

    public static void main(String[] args) {
        ZigzagString app = new ZigzagString();
        String result = app.solve("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    private String solve(String s, int numRows) {
        Map<Integer, String> map = new HashMap<>();
        boolean goingDown = true;
        int level = 1;
        for (int i = 0; i < s.length(); i++) {
            String sub = map.getOrDefault(level, EMPTY);
            sub += s.charAt(i);
            map.put(level, sub);
            if (goingDown) {
                if (level == numRows) {
                    level--;
                    goingDown = false;
                } else {
                    level++;
                }
            } else {
                if (level == 1) {
                    level++;
                    goingDown = true;
                } else {
                    level--;
                }
            }
        }
        return IntStream.range(1, numRows + 1)
                .mapToObj(map::get)
                .collect(Collectors.joining());
    }
}
