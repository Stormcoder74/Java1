package ru.geekbrains.java1.lesson_6;

public abstract class Animal {
    protected int a;

    public Animal(int a) {
        this.a = a;
    }

    abstract public void voice();
}
