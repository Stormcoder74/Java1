// https://github.com/Stormcoder74/Java1.git

package ru.geekbrains.java1.lesson_07;

import java.util.Random;

public class Homework {
    public static void main(String[] args) {
        Random rnd = new Random();
        int hours = 0;
        Plate plate = new Plate(70 + rnd.nextInt(60));
        plate.info();

        Cat[] cats = {new Cat("Барсик", 15 + rnd.nextInt(10), 5 + rnd.nextInt(5)),
                new Cat("Мурзик", 15 + rnd.nextInt(10), 5 + rnd.nextInt(5)),
                new Cat("Васька", 15 + rnd.nextInt(10), 5 + rnd.nextInt(5)),};
        do {
            for (Cat cat: cats) {
                do {
                    if (!cat.getSatiety())
                        if (!cat.eat(plate))
                            Owner.feedCats(plate);
                }while (!cat.getSatiety());
                cat.anHourPassed();
            }
            plate.info();
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            hours++;
            System.out.printf("\nПрошел час %d:00\n", hours);
        } while (hours < 24);

    }
}