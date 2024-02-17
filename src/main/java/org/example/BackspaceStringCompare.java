package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

@Slf4j
public class BackspaceStringCompare {

    private static final char HASH = '#';

    public static void main(String[] args) {
        BackspaceStringCompare app = new BackspaceStringCompare();
        log.info("{}", app.compareStrings("yyf#c#a", "yyy#k#pp##a"));
    }

    public int compareStrings(String s1, String s2) {
        if (null == s1 || null == s2) {
            return 0;
        }
        return removeBackspaces(s1).equals(removeBackspaces(s2)) ? 1 : 0;
    }

    public String removeBackspaces(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (HASH != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
