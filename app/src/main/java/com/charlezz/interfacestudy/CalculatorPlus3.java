package com.charlezz.interfacestudy;

public class CalculatorPlus3 implements Calculator {
    @Override
    public int sum(int a, int b) {
        return a+b+3;
    }
}
