package ru.geekbrains.java1.lesson_05;

import java.util.Scanner;

public class Worker {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;
    private static int amount = 0;

    public Worker() {
        this("", "", "", "", 0, 0);
    }

    public Worker(String fio, String position, String email,
                  String phone, float salary, int age) {
        if (!setFio(fio)) this.fio = "сотрудник_" + (amount + 1);
        if (!setPosition(position)) this.position = "Стажер";
        if (!setEmail(email)) this.email = "отсутствует";
        if (!setPhone(phone)) this.phone = "отсутствует";
        if (!setSalary(salary)) this.salary = 50000;
        if (!setAge(age)) this.age = 0;

        amount++;
    }

    private boolean checkText(String string) {
        if (string.length() <= 1) return false;
        for (int i = 0; i < string.length(); i++) {
            if (!((string.charAt(i) >= 0x41 && string.charAt(i) <= 0x5A) ||
                    (string.charAt(i) >= 0x61 && string.charAt(i) <= 0x7A) ||
                    (string.charAt(i) >= 0x410 && string.charAt(i) <= 0x44F) ||
                    (string.charAt(i) == ' ')))
                return false;
        }
        return true;
    }

    public boolean setFio(String fio) {
        if (checkText(fio.trim())) {
            this.fio = fio.trim();
            return true;
        }
        System.out.println("строка (ФИО) содержит недопустимые символы");
        return false;
    }

    public boolean setPosition(String position) {
        if (checkText(position.trim())) {
            this.position = position.trim();
            return true;
        }
        System.out.println("строка (должность) содержит недопустимые символы");
        return false;
    }

    public boolean setEmail(String email) {    // будем считать, что для адреса разрешены все симвлоы
        int indexDog = email.indexOf('@');                  // проверим только
        if (indexDog < 0 || (indexDog + 6) > email.length()) {      // наличие на актуальном месте '@'
            System.out.println("некорректный формат email адреса '@'");
            return false;
        }
        if (email.indexOf('.', indexDog + 2) < 0 ||     // и наличие '.'
                email.indexOf('.', indexDog + 2) + 3 > email.length()) {
            System.out.println("некорректный формат email адреса '.'");
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean setPhone(String phone) {    // будем считать, что проверяем сотовый телефон
        phone = phone.trim();
        if (phone.indexOf("+7") == 0) phone = phone.substring(2);
        if (phone.indexOf("8") == 0) phone = phone.substring(1);
        if (phone.length() != 10) {
            System.out.println("неверная длина номера");
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < 0x30 || phone.charAt(i) > 0x39) {
                System.out.println("неверные символы в номере");
                return false;
            }
        }
        this.phone = phone;
        return true;
    }

    public boolean setSalary(float salary) {
        if (salary < 50000) {
            System.out.println("Минимальный размер оплаты труда составляет 50000 руб.");
            return false;
        }
        this.salary = salary;
        return true;
    }

    public boolean setAge(int age) {
        if (age < 14) {
            System.out.println("Использование труда малолетних детей запрещено!");
            return false;
        }
        this.age = age;
        return true;
    }

    public void info() {
        System.out.print(fio + ", ");
        System.out.print(position + ", ");
        System.out.print(email + ", ");
        System.out.print(salary + ", ");
        System.out.print(phone + ", ");
        System.out.println(age + ".");
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public static Worker createWorker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("В процессе ввода данных могутвыводиться нижеследующие сообщения.");
        System.out.println("В таком случае введите данные повторно");
        System.out.println();
        Worker worker = new Worker();
        System.out.println();
        String input;
        do {
            System.out.println("Введите ФИО сотрудника");
            input = scanner.nextLine();
        } while (!worker.setFio(input));

        do {
            System.out.println("Введите должность сотрудника");
            input = scanner.nextLine();
        } while (!worker.setPosition(input));

        do {
            System.out.println("Введите email сотрудника");
            input = scanner.nextLine();
        } while (!worker.setEmail(input));

        do {
            System.out.println("Введите телефон сотрудника");
            input = scanner.nextLine();
        } while (!worker.setPhone(input));

        float inputF = 0f;
        do {
            System.out.println("Введите зарплату сотрудника");
            if (scanner.hasNextFloat())
                inputF = scanner.nextFloat();
        } while (!worker.setSalary(inputF));

        int inputI = 0;
        do {
            System.out.println("Введите возраст сотрудника");
            if (scanner.hasNextInt())
                inputI = scanner.nextInt();
        } while (!worker.setAge(inputI));

        return worker;
    }
}
