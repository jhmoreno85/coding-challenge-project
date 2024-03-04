package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Anagrams {

    public static void main(String[] args) {
        Anagrams app = new Anagrams();
        log.info("words are anagrams each other: {}", app.anagramEachOther(
                "aabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbrccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyx",
                "xaabbccyaabbccyaabbccyaabbcrcyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyxaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccyaabbccy"));
    }

    private boolean anagramEachOther(String s1, String s2) {
        long start = System.currentTimeMillis();
        if (s1.length() != s2.length()) {
            log.info("elapsed time: {}", System.currentTimeMillis() - start);
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            if (0 == map.get(ch1)) {
                map.remove(ch1);
            }
            char ch2 = s2.charAt(i);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
            if (0 == map.get(ch2)) {
                map.remove(ch2);
            }
        }
        log.info("elapsed time: {}", System.currentTimeMillis() - start);
        return map.isEmpty();
    }
}
