package ru.geekbrains.java1.lesson_07;

public class Owner {
    public static void feedCats(Plate plate) {
        int amount = (int) (Math.random() * 60 + 70);
        plate.increaseFood(amount);
        System.out.printf("Хозяин положил %d еды\n", amount);
    }
}
