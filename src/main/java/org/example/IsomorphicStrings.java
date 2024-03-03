package org.example;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings app = new IsomorphicStrings();
        System.out.println("Is isomorphic: " + app.isIsomorphic("ccb", "xxy"));
        System.out.println("Is isomorphic: " + app.isIsomorphic("aab", "xyz"));
    }

    private boolean isIsomorphic(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                if (map.get(s1.charAt(i)) != s2.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s1.charAt(i), s2.charAt(i));
            }
        }
        return true;
    }
}
