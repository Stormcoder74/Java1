package ru.geekbrains.java1.lesson_05;
// класс "Сотрудник" в пределах ДЗ. Дополнительно по адресу :
// https://github.com/Stormcoder74/Java1/tree/master/src/ru/geekbrains/java1
public class WorkerTest {   // класс "Сотрудник" в пределах ДЗ.

    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public WorkerTest(String fio, String position, String email,
                      String phone, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info(){
        System.out.print(fio + ", ");
        System.out.print(position + ", ");
        System.out.print(email + ", ");
        System.out.print(salary + ", ");
        System.out.print(phone + ", ");
        System.out.println(age + ".");
    }
}
