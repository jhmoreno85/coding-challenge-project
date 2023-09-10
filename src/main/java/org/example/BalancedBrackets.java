package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BalancedBrackets {

    private static final Map<Character, Character> BRACKETS_MAP;
    static {
        BRACKETS_MAP = new HashMap<>();
        BRACKETS_MAP.put('}', '{');
        BRACKETS_MAP.put(')', '(');
        BRACKETS_MAP.put(']', '[');
        BRACKETS_MAP.put('>', '<');
    }

    public static void main(String[] args) {
        BalancedBrackets app = new BalancedBrackets();
        log.info("{}", app.isBalanced("([){(()(){([][][][])}[])}[{}]]{}<()>("));
    }

    private boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (BRACKETS_MAP.containsKey(s.charAt(i))) {
                if (BRACKETS_MAP.get(s.charAt(i)).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
