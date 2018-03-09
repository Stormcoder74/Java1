package ru.geekbrains.java1.lesson_04;


import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static int SIZE = 10;
    public static int DOTS_TO_WIN = 5;
    public static int HUMAN = 1;
    public static int AI = 0;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            Turn(HUMAN);
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            Turn(AI);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    boolean row = true;
                    boolean column = true;
                    boolean diag1 = true;
                    boolean diag2 = true;
                    for (int k = 1; k < DOTS_TO_WIN && (row || column || diag1 || diag2); k++) {
                        row = (i + k) < SIZE && row && map[i + k][j] == symb;
                        column = (j + k) < SIZE && column && map[i][j + k] == symb;
                        diag1 = (i + k) < SIZE && (j + k) < SIZE && diag1 && map[i + k][j + k] == symb;
                        diag2 = (i - k) >= 0 && (j + k) < SIZE && diag2 && map[i - k][j + k] == symb;
                    }
                    if (row || column || diag1 || diag2) return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static int thinkingAI(char simb) {
        for (int max = DOTS_TO_WIN - 2; max > 0; max--) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == simb) {
                        boolean column = true;
                        boolean row = true;
                        boolean diag1 = true;
                        boolean diag2 = true;
                        for (int k = 1; k <= max && (column || row || diag1 || diag2); k++) {
                            column = (i + k) < SIZE && column && map[i + k][j] == simb;
                            row = (j + k) < SIZE && row && map[i][j + k] == simb;
                            diag1 = (i + k) < SIZE && (j + k) < SIZE && diag1 && map[i + k][j + k] == simb;
                            diag2 = (i + k) < SIZE && (j - k) >= 0 && diag2 && map[i + k][j - k] == simb;
                        }
                        if (column && isCellValid(i - 1, j))
                            return (i - 1) * 10 + j;
                        else if (column && isCellValid(i + max + 1, j))
                            return (i + max + 1) * 10 + j;
                        if (row && isCellValid(i, j - 1))
                            return i * 10 + (j - 1);
                        else if (row && isCellValid(i, j + max + 1))
                            return i * 10 + (j + max + 1);
                        if (diag1 && isCellValid(i - 1, j - 1))
                            return (i - 1) * 10 + (j - 1);
                        else if (diag1 && isCellValid(i + max + 1, j + max + 1))
                            return (i + max + 1) * 10 + (j + max + 1);
                        if (diag2 && isCellValid(i - 1, j + 1))
                            return (i - 1) * 10 + (j + 1);
                        else if (diag2 && isCellValid(i + max + 1, j - max - 1))
                            return (i + max + 1) * 10 + (j - max - 1);
                    }
                }
            }
        }
        return -1;
    }

    public static void Turn(int player) {
        int x, y, think;
        do {
            if (player == AI) {
                think = thinkingAI(DOT_X);
                if (think >= 0) {
                    y = think / 10;
                    x = think % 10;
                } else {
                    y = rand.nextInt(SIZE);
                    x = rand.nextInt(SIZE);
                }
            } else {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            }
        } while (!isCellValid(y, x));
        if (player == AI) {
            System.out.println("Компьютер сделал ход в клетку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        } else {
            map[y][x] = DOT_X;
        }
    }

    public static boolean isCellValid(int y, int x) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}