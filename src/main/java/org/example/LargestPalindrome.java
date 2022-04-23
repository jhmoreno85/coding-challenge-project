package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LargestPalindrome {

    public static void main(String[] args) {
        LargestPalindrome app = new LargestPalindrome();
        log.info(app.largestPalindrome("iibmmbiibma"));
    }

    public String largestPalindrome(String str) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            int extract1 = expand(str, i, i);
            int extract2 = expand(str, i, i + 1);
            int offset = extract1 > extract2 ? 1 : 2;
            int maxLength = Math.max(extract1, extract2);
            if (maxLength > end - start) {
                start = i - ((maxLength) / 2);
                end = i + (maxLength / 2) + offset;
            }
        }
        return str.substring(start, end);
    }

    public int expand(String str, int l, int r) {
        while (l > 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return r - l;
    }
}
