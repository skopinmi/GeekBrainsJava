package ru.geekbrains.skopin.lesson5;
/*
    Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 */

public class Employee {
    public String name;
    public String position;
    public String eMail;
    public String phoneNumber;
    public int salary;
    public int age;
/*
    Конструктор класса должен заполнять эти поля при создании объекта.
 */
    public Employee(String name, String position, String eMail, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
/*
    Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */
    public static void printInfo (Employee employee) {
        System.out.println("Name: " + employee.name);
        System.out.println("position: " + employee.position);
        System.out.println("Email: " + employee.eMail);
        System.out.println("Phone number: " + employee.phoneNumber);
        System.out.println("Salary: " + employee.salary);
        System.out.println("Age: " + employee.age);
    }
}

