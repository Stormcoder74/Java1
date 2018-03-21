package ru.geekbrains.java1.lesson_07;

public class Cat {
    private String name;
    private int appetite;
    private int satiety;    // сытость
    private int gulosity;   // прожорливость (скорость снижения сытости)

    public Cat(String name, int appetite, int gulosity){
        this.name = name;
        this.appetite = appetite;
        this.gulosity = gulosity;
        satiety = 0;
    }

    public boolean eat(Plate plate){
        if(plate.decreaseFood(appetite)){
            System.out.printf("%s съел %d еды\n", name, appetite);
            satiety = appetite;
            return true;
        }
        System.out.printf("%s остался голоден, еды мало\n", name);
        return false;
    }

    public boolean getSatiety(){
        return satiety > 0;
    }

    public void anHourPassed(){
        satiety -= gulosity;
    }
}
