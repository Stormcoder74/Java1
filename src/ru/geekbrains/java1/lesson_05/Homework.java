package ru.geekbrains.java1.lesson_05;

public class Homework {
    public static void main(String[] args) {
        Worker[] workerList = new Worker[5];

        workerList[0] = new Worker("Ivanov Petr", "Director",
                " ivpetr@mailbox.com ", "892312311", 100000, 48);

        workerList[1] = new Worker("Ivanov Ivan", "Engineer",
                " ivivan@mailbox.com ", "892312312", 80000, 47);

        workerList[2] = new Worker("Brooke Shields", "Manager",
                " brookeshields@mailbox.com ", "892846712", 60000, 23);

        workerList[3] = new Worker("Teryaev Sergey", "Java developer",
                " teryaevs@yandex.ru ", "89140889876", 125000, 43);

        workerList[4] = new Worker("Natalie Portman", "Accounter",
                " sidorov@mailbox.com ", "892357812", 70000, 32);

        //print(workerList, 20);
        //unicode();
    }

    private static void print(Worker[] list, int age) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].getAge() > age) {
                list[i].info();
                System.out.println();
            }
        }
    }
}
