package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class LetterCombinationsPhoneV2 {

    private static final int OFFSET = 48;
    private static final String[] KEYBOARD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinationsPhoneV2 app = new LetterCombinationsPhoneV2();
        List<String> combinations = app.findCombinations("23");
        combinations.forEach(combination -> log.info("{}", combination));
    }

    public List<String> findCombinations(String digits) {
        if (null == digits || digits.isEmpty() || !digits.matches("\\d+")) {
            return Collections.emptyList();
        }
        List<String> resultList = new ArrayList<>();
        backtrack(digits.toCharArray(), resultList, new StringBuilder(), 0);
        return resultList;
    }

    public void backtrack(char[] digits, List<String> resultList, StringBuilder sb, int idx) {
        if (sb.toString().length() == digits.length) {
            resultList.add(sb.toString());
            return;
        }

        String letterGroup = KEYBOARD[digits[idx] - OFFSET];
        for (int i = 0; i < letterGroup.length(); i++) {
            sb.append(letterGroup.charAt(i));
            backtrack(digits, resultList, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
