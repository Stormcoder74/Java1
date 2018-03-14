package ru.geekbrains.java1.lesson_6;

public class Cat extends Animal {
    protected int b;

    public Cat(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public void voice() {
        System.out.println("Cat мяуced");
    }
}
