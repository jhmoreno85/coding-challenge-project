package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

    public static void main(String[] args) {
        Test app = new Test();
        log.info("{}", app.calculateTime(10100, 0, 500, 1000));
    }

    public int calculateTime(int ff, int fv, int depFF, int depFV) {
        int months = 0;
        while (ff >= fv) {
            ff += depFF;
            fv += depFV;
            months++;
        }
        return months;
    }
}
