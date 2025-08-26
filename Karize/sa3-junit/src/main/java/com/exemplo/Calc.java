package com.exemplo;

public class Calc {

    public int soma(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b não pode ser zero");
        }
        return a / b;
    }

    public boolean ehPar(int n) {
        return n % 2 == 0;
    }
}
