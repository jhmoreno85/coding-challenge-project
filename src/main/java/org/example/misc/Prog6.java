package org.example.misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prog6 {

    public static void main(String[] args) {
        Prog6 app = new Prog6();
        boolean result = app.solve("#ABC##BFH#X", "XX##ADSD###BFX");
        System.out.println(result);
    }

    private boolean solve(String s1, String s2) {
        s1 = applyBackspace(s1);
        s2 = applyBackspace(s2);
        return s1.equals(s2);
    }

    private String applyBackspace(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
