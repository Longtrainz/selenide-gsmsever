package com.gsmserver.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Calculator {

    public String multiply(String price, int count) {
        double firstValue = Double.parseDouble(price);
        double result = firstValue * count;

        return String.format("%.2f", result);
    }

    public static void main(String[] args) {
        System.out.println(multiply("126.99", 3));
    }
}