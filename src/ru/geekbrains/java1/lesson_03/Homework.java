package ru.geekbrains.java1.lesson_03;

import java.util.Arrays;
import java.util.Scanner;

public class Homework {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        guessNum();
        guessWord();
    }

    private static void guessNum() {
        boolean right = false;
        Scanner scanner = new Scanner(System.in);
        do {
            int secretNumber = (int) (Math.random() * 10);
            System.out.println("\nВам необходимо угадать число от 0 до 9 с трех попыток");
            for (int i = 1; i < 4; i++) {
                System.out.println("Попытка " + i);
                int guess;
                while (true) {
                    System.out.println("Введите число:");
                    if (scanner.hasNextInt()) {
                        guess = scanner.nextInt();
                        break;
                    } else scanner.nextLine();
                }
                if (guess > secretNumber) System.out.println("Загаданное число меньше");
                else if (guess < secretNumber) System.out.println("Загаданное число больше");
                else {
                    System.out.println("Правильно. Примите поздравления!");
                    right = true;
                    break;
                }
            }
            if (!right) System.out.println("Очень жаль, но все попытки исчерпаны. Вы проиграли.");
            System.out.println("Хотите сыграть еще раз? 1 - Да, 0 -Нет");
        } while (scanner.next().equals("1"));
    }

    private static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int secretWord = (int) (Math.random() * words.length);
        System.out.println("Вам необходимо подобрать пароль. Возможные варианты  приведены ниже:");
        System.out.println(Arrays.toString(words));
        int count = 0;
        String guess;
        do {
            System.out.println("Введите слово");
            guess = scanner.nextLine();
            System.out.print("Совпвдающие буквы: ");
            for (int i = 0; i < 15; i++)
                if (i < guess.length() && i < words[secretWord].length() && words[secretWord].charAt(i) == guess.charAt(i))
                    System.out.print(guess.charAt(i));
                else System.out.print("#");
            System.out.println();
            count++;
        } while (!guess.equals(words[secretWord]));
        String tries;
        switch (count) {
            case 1:
                tries = " попытку. С первого раза! Потрясающе!!!";
                break;
            case 2:
            case 3:
            case 4:
                tries = " попытки. Отличный результат!";
                break;
            default:
                tries = " попыток.";
        }
        System.out.println("Поздравляю! Вы угадали использовав " + count + tries);
    }
}