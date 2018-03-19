// https://github.com/Stormcoder74/Java1.git

package ru.geekbrains.java1.lesson_06;

public class Homework {
    public static void main(String[] args) {
        Animal animals[] = {new Cat("Барсик"), new Cat("Мурзик"), new Cat("Васька"),
                new Dog("Полкан"), new Dog("Вулкан"), new Dog("Барбос")};
        for (int i = 0; i < 3; i++) {
            int dificult = (int) (Math.random() * Animal.DEVIATION * 2 - Animal.DEVIATION + 95);
            int catDistance = dificult * 2;
            int dogDistance = dificult * 5;
            float catHeight = dificult * 0.02f;
            float dogHeight = dificult * 0.005f;
            float swimDistance = dificult * 0.1f;
            for (Animal animal: animals) {
                if(animal.toString().contains("кот")){
                    System.out.printf("%s беги %d метров\n", animal, catDistance);
                    animal.run(catDistance);
                    System.out.printf("%s преодолей препятствие %.1f метров\n", animal, catHeight);
                    animal.jump(catHeight);
                }
                if(animal.toString().contains("пес")){
                    System.out.printf("%s беги %d метров\n", animal, dogDistance);
                    animal.run(dogDistance);
                    System.out.printf("%s преодолей препятствие %.1f метров\n", animal,  dogHeight);
                    animal.jump(dogHeight);
                    System.out.printf("%s плыви %.1f метров\n", animal, swimDistance);
                    ((Dog)animal).swim(swimDistance);
                }
            }
            System.out.println();
        }
    }
}
