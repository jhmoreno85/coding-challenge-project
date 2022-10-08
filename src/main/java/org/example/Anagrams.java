package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Anagrams {

    public static void main(String[] args) {
        Anagrams app = new Anagrams();
        log.info("words are anagrams each other: {}", app.anagramEachOther("aabbccy", "bbaaccx"));
    }

    private boolean anagramEachOther(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int ascii1 = s1.charAt(i);
            int ascii2 = s2.charAt(i);
            map.put(ascii1, map.getOrDefault(ascii1, 0) + 1);
            if (0 == map.get(ascii1)) {
                map.remove(ascii1);
            }
            map.put(ascii2, map.getOrDefault(ascii2, 0) - 1);
            if (0 == map.get(ascii2)) {
                map.remove(ascii2);
            }
        }
        return map.isEmpty();
    }
}
