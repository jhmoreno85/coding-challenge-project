package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LetterCombinationsPhone {

    private static final Map<Character, List<Character>> map = new HashMap<>();
    static {
        map.put('0', Collections.singletonList('\0'));
        map.put('1', Collections.singletonList('\0'));
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        findCombinations(Arrays.asList('2', '3', '2', '3', '2', '3'));
    }

    public static void findCombinations(List<Character> digits) {
        if (digits.isEmpty()) {
            return;
        }
        backtrack("232", 0, "");
    }

    public static void backtrack(String digits, int currIndex, String word) {
        if (currIndex < digits.length()) {
            for (char ch : map.get(digits.charAt(currIndex))) {
                backtrack(digits, currIndex + 1, word + ch);
            }
        } else {
//            System.out.println(word.replace("\0", ""));
            log.info(word);
        }
    }
}
