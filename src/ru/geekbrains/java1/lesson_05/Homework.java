package ru.geekbrains.java1.lesson_05;

// Сверх ДЗ возможность добавлять новых сотрудников
// Вместо массива, не имеющего возможности расширения, используется ArrayList
// https://github.com/Stormcoder74/Java1.git

import java.util.ArrayList;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Worker> workerList = new ArrayList<>();

        workerList.add(new Worker("Ivanov Petr", "Director",
                " ivpetr@mailbox.com ", "89231231136", 100000, 48));

        workerList.add(new Worker("Ivanov Ivan", "Engineer",
                " ivivan@mailbox.com ", "89231236012", 80000, 47));

        workerList.add(new Worker("Brooke Shields", "Manager",
                " brookeshields@mailbox.com ", "892846732i2", 70000, 23));

        workerList.add(new Worker("Teryaev Sergey", "Java developer",
                " teryaevs@yandex.ru ", "89140889876", 125000, 43));

        workerList.add(new Worker("Natalie Portman", "Accounter",
                " sidorov@mailbox.com ", "+792357812", 70000, 32));

        String input = "";
        do {
            print(workerList, 40);
            System.out.println("Введите 1 чтобы добавить нового сотрудника или нажмите Enter для выхода");
            input = scanner.nextLine();
            if (input.equals("1"))
                workerList.add(Worker.createWorker());
        } while (input.equals("1"));
    }

    private static void print(ArrayList<Worker> list, int ageFilter) {
        for (Worker aList : list)
            if (aList.getAge() > ageFilter) {
                aList.info();
                System.out.println();
            }
    }
}
