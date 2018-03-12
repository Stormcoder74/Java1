package ru.geekbrains.java1.lesson_05;

public class Homework {
    public static void main(String[] args) {
        Worker[] workerList = new Worker[5];

        workerList[0] = new Worker("Ivanov Petr", "Director",
                " ivpetr@mailbox.com ", "89231231136", 100000, 48);

        workerList[1] = new Worker("Ivanov Ivan", "Engineer",
                " ivivan@mailbox.com ", "89231236012", 80000, 47);

        workerList[2] = new Worker("Brooke Shields", "Manager",
                " brookeshields@mailbox.com ", "892846732i2", 70000, 23);

        workerList[3] = new Worker("Teryaev Sergey", "Java developer",
                " teryaevs@yandex.ru ", "89140889876", 125000, 43);

        workerList[4] = new Worker("Natalie Portman", "Accounter",
                " sidorov@mailbox.com ", "+792357812", 70000, 32);

        print(workerList, 20);

    }

    private static void print(Worker[] list, int ageFilter) {
        for (Worker aList : list)
            if (aList.getAge() > ageFilter) {
                aList.info();
                System.out.println();
            }
    }
}
