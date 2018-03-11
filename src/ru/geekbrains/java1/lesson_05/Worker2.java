package ru.geekbrains.java1.lesson_05;

// класс "Сотрудник"

import java.sql.SQLOutput;

public class Worker2 {   // класс "Сотрудник" в пределах ДЗ.

    private String fio;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;
    private static int amount = 0;

    public static void main(String[] args) {
        Worker2 worker = new Worker2("Вася", "сторож", "без@емей.ла", "+79244566744", 34567, 98);
        worker.info();

        Worker2 worker2 = new Worker2();

        worker2.setFio("Иванов Иван");
        System.out.println(worker2.getFio());

        worker2.setPosition("    Директор    ");
        System.out.println(worker2.getPosition());

        worker2.setEmail("ivanov@mailbox.ru");
        System.out.println(worker2.getEmail());

        worker2.setPhone("89245793463");
        System.out.println(worker2.getPhone());
    }

    public Worker2() {

    }

    public Worker2(String fio, String position, String email,
                   String phone, float salary, int age) {
        setFio(fio);
        if (this.fio == null) this.fio = "сотрудник_" + (amount + 1);
        setPosition(position);
        if (this.position == null) this.position = "Стажер";
        setEmail(email);
        if (this.email == null) this.email = "отсутствует";
        setPhone(phone);
        if(this.phone ==null) this.phone = "отсутствует";
        this.salary = salary;
        this.age = age;

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        if (checkText(fio.trim()))
            this.fio = fio.trim();
        else
            System.out.println("строка (ФИО) содержит недопустимые символы");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (checkText(position.trim()))
            this.position = position.trim();
        else
            System.out.println("строка (должность) содержит недопустимые символы");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {    // будем считать, что для адреса разрешены все симвлоы
        int indexDog = email.indexOf('@');                  // проверим только
        if (indexDog < 0 || (indexDog + 6) > email.length()) {      // наличие '@' на актуальном месте
            System.out.println("некорректный формат email адреса '@'");
            return;
        }
        if (email.indexOf('.', indexDog + 2) < 0 ||     // и наличие '.' аналогично
                email.indexOf('.', indexDog + 2) + 3 > email.length()) {
            System.out.println("некорректный формат email адреса '.'");
            return;
        }
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {    // будем считать, что проверяем сотовый телефон
        phone = phone.trim();
        if (phone.indexOf("+7") == 0) phone = phone.substring(2);
        if (phone.indexOf("8") == 0) phone = phone.substring(1);
        if (phone.length() != 10) {
            System.out.println("неверная длина номера");
            return;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < 0x30 || phone.charAt(i)> 0x39) {
                System.out.println("неверные символы в номере");
                return;
            }
        }
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.print(fio + ", ");
        System.out.print(position + ", ");
        System.out.print(email + ", ");
        System.out.print(salary + ", ");
        System.out.print(phone + ", ");
        System.out.println(age + ".");
    }
}
