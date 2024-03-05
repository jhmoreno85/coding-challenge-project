package org.example;

public class StringCalculator {

    public static void main(String[] args) {
        String input = "3*12*6+5/3-1*2";
        StringCalculator app = new StringCalculator();
        float result = app.calculate(input);
        System.out.println(input + " = " + String.format("%.2f", result));
    }

    public float calculate(String input) {
        int pos = input.indexOf('+');
        if (pos != -1) {
            return calculate(input.substring(0, pos)) + calculate(input.substring(pos + 1));
        } else {
            pos = input.indexOf('-');
            if (pos != -1) {
                return calculate(input.substring(0, pos)) - calculate(input.substring(pos + 1));
            } else {
                pos = input.indexOf('*');
                if (pos != -1) {
                    return calculate(input.substring(0, pos)) * calculate(input.substring(pos + 1));
                } else {
                    pos = input.indexOf('/');
                    if (pos != -1) {
                        return calculate(input.substring(0, pos)) / calculate(input.substring(pos + 1));
                    }
                }
            }
        }
        return Float.parseFloat(input);
    }
}
