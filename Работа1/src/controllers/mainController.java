package controllers;

import views.result;

public class mainController {
    public static void mainWork() {System.out.println("В данном калькуляторе реализованны функции: \n" +
            " + - сложение, - - вычитание, * - умножение, / - деление, // - деление без остатка, % остаток от деления, ^ или ** - возведение в степень" +
            "() - скобки.\n" + "Вывод ^ происходит только целочисленный, а ввод, и целочисленный, и дробный");
        System.out.println(result.processInput());}
}