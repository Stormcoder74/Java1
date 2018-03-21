package ru.geekbrains.java1.lesson_07;


public class Plate {
    private int food;

    public Plate(int food){
        this.food = food;
    }

    public boolean decreaseFood(int amount){
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void increaseFood(int amount){
            food += amount;
    }

    public void info(){
        System.out.printf("в тарелке осталось %d еды\n", food);
    }
}
