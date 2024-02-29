package org.example;

public class Encoder {

    private static final int OFFSET_MIN = 64;
    private static final int OFFSET_MAX = 90;

    public static void main(String[] args) {
        Encoder app = new Encoder();
        String result = app.solve("ABCZ", 520);
        System.out.println(result);
    }

    public String solve(String value, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            int ch = value.charAt(i) + n;
            while (ch > OFFSET_MAX) {
                int offset = ch - OFFSET_MAX;
                ch = OFFSET_MIN + offset;
            }
            sb.append((char) ch);
        }
        return sb.toString();
    }

    // improve this version using MOD and remove while cycle
}
