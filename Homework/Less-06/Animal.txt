package ru.geekbrains.java1.lesson_06;

public abstract class Animal {
    public static final int DEVIATION = 20;
    protected String name;
    protected int strong;
    protected int maxDistance;
    protected float maxHeight;

    public Animal(String name) {
        this.name = name;
        strong = (int) (Math.random() * DEVIATION * 2 - DEVIATION + 100);
    }

    public void run(int distance) {
        if (distance <= maxDistance)
            System.out.printf("%s пробежал %d метров\n", this, distance);
        else
            System.out.println("Столько не пробежать");
    }

    public void jump(float height) {
        if (height <= maxHeight)
            System.out.printf("%s перепрыгнул препятствие высотой в %.1f метров\n", this, height);
        else
            System.out.println("Это не перепрыгнуть");
    }
}
