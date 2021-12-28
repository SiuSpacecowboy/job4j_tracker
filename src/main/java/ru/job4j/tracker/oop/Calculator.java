package ru.job4j.tracker.oop;

public class Calculator {

    private static int x = 5;

    public int divide(int num) {
        return num / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x + y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = sum(10);
        System.out.println(result);
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int res = calculator.divide(5);
        System.out.println(res);
        int resu = minus(5);
        System.out.println(resu);
        int fin = calculator.sumAllOperation(5);
        System.out.println(fin);
    }
}

