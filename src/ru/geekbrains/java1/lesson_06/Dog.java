package ru.geekbrains.java1.lesson_06;

public class Dog extends Animal {
    private float maxDistanceToSwim;

    public Dog(String name) {
        super(name);
        maxDistance = strong * 5;
        maxHeight = strong * 0.005f;
        maxDistanceToSwim = strong * 0.1f;
    }

    public void swim(float distance) {
        if (distance <= maxDistanceToSwim)
            System.out.printf("%s проплыл %.1f метров\n", this, distance);
        else
            System.out.println("Столько не проплыть");
    }

    @Override
    public String toString() {
        return "пес " + name;
    }
}
