package com.git.wuqf;

/**
 * Created by sdzn-dsj on 2016/12/13.
 */
public class CalculatorImpl implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a < b ? a : b;
    }
}
