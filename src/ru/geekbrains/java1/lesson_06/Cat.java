package ru.geekbrains.java1.lesson_06;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        maxDistance = strong * 2;
        maxHeight = strong * 0.02f;
    }

    @Override
    public String toString() {
        return "кот " + name;
    }
}
