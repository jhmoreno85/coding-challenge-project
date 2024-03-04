package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> list = List.of("cat", "dog", "tac", "god", "act");
        GroupAnagrams app = new GroupAnagrams();
        List<List<String>> result = app.groupAnagrams(list);
        log.info("{}", result);
    }

    private List<List<String>> groupAnagrams(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String orderedWord = new String(letters);
            if (map.containsKey(orderedWord)) {
                map.get(orderedWord).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(orderedWord, newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
