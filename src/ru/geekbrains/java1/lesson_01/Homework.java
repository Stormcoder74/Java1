package ru.geekbrains.java1.lesson_01;

public class Homework {
    public static void main(String[] args) {    // точка входа. 1 путкт ДЗ
        byte b = 5;                             // переменные примитивных типов...
        short s = 10;                           // ... 2 п. ДЗ
        int i = 130;
        long l = 375L;

        float pi = 3.1415f;
        double e0 = -1.602176620898E-19;

        boolean bool = true;

        char c = '\u5C8E';

        System.out.println(b + " " + s + " " + i + " " + l      // вывод их...
                + " " + pi + " " + e0 + " " + bool + " " + c);  // ... в консоль
        // вызовы методов
        System.out.println(calcExpr(b, s, i, l));           // 3 п. ДЗ

        System.out.println(checkSum(b, s));                 // 4 п.
        System.out.println(checkSum((byte) (b + 8), s));

        signOfNumber(i);                                    // 5 п.
        signOfNumber(i * -1);

        System.out.println(signOfNumber(s));                // 6 п.
        System.out.println(signOfNumber((short) (s - 25)));

        hello("Александр", "Сергей");                       // 7 п.

        leapYear(2017);                                     // 8 п.
        leapYear(2016);
        leapYear(2100);
        leapYear(2000);
    }
    // методы
    private static float calcExpr(byte a, short b, int c, long d) {  // 3 п.
        return a * (b + (c / d));
    }

    private static boolean checkSum(byte a, short b) {               // 4 п.
        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    private static void signOfNumber(int num) {                      // 5 п.
        if (num < 0) System.out.println("Число отрицательное.");
        else System.out.println("Число положительное.");
    }

    private static boolean signOfNumber(short num) {                 // 6 п.
        return num < 0;
    }

    private static void hello(String name1, String name2) {          // 7 п.
        System.out.println("Здрвствуйте, " + name1 + ". Меня зовут " + name2 + ".");
        System.out.println("Здрвствуйте, " + name2 + ". Рад знакомству.");
    }

    private static void leapYear(int year) {                         // 8 п.
        String ne = " не ";
        if (((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0) ne = " ";
        System.out.println(year + " год" + ne + "високосный.");
    }
}