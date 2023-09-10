package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BalancedBrackets {

    public static void main(String[] args) {
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('}', '{');
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('>', '<');

        BalancedBrackets app = new BalancedBrackets();
        log.info("{}", app.isBalanced(bracketsMap, "([){(()(){([][][][])}[])}[{}]]{}<()>("));
    }

    private boolean isBalanced(Map<Character, Character> bracketsMap, String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (bracketsMap.containsKey(s.charAt(i))) {
                if (bracketsMap.get(s.charAt(i)).equals(stack.peek())) {
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
