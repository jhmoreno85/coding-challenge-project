package org.example;

public class ZigzagString {

    public static void main(String[] args) {
        ZigzagString app = new ZigzagString();
        String result = app.solve("PAYPALISHIRING", 3);
        System.out.println(result);
    }

    private String solve(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer();
        }
        int level = 0;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {
            arr[level].append(s.charAt(i));
            if (goingDown) {
                if (level == numRows - 1) {
                    level--;
                    goingDown = false;
                } else {
                    level++;
                }
            } else {
                if (level == 0) {
                    level++;
                    goingDown = true;
                } else {
                    level--;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[0].append(arr[i]);
        }
        return arr[0].toString();
    }
}
