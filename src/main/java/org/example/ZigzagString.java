package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigzagString {

    public static void main(String[] args) {
        ZigzagString app = new ZigzagString();
        String result = app.solveV2("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    private String solve(String s, int numRows) {
        char[][] board = new char[numRows][s.length() / 2];
        int x = 0;
        int y = 0;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {
            board[x][y] = s.charAt(i);
            if (goingDown) {
                x++;
                if (x == numRows) {
                    goingDown = false;
                    x -= 2;
                    y += 1;
                }
            } else {
                x--;
                y++;
                if (x < 0) {
                    goingDown = true;
                    x = 1;
                    y--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (0 != board[i][j]) {
                    sb.append(board[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private String solveV2(String s, int numRows) {
        Map<Integer, String> map = new HashMap<>();
        boolean goingDown = true;
        int level = 1;
        for (int i = 0; i < s.length(); i++) {
            String sub = map.getOrDefault(level, "");
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
