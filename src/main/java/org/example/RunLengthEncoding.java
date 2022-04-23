package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunLengthEncoding {

    public static void main(String[] args) {
        log.info(encode("aabcccccccca"));
    }

    public static String encode(String input) {
        if (null == input || input.isEmpty()) {
            return "";
        }
        char prevChar = 0;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (prevChar == input.charAt(i)) {
                counter++;
            } else {
                if (0 != prevChar) {
                    sb.append(counter).append(prevChar);
                }
                prevChar = input.charAt(i);
                counter = 1;
            }
        }
        sb.append(counter).append(prevChar);
        return sb.toString();
    }
}
