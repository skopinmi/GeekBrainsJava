package ru.geekbrains.skopin.lesson5;
/*
    Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 */

public class Employee {
    public String name;
    public String position;
    public String eMail;
    public long phoneNumber;
    public int salary;
    public int age;
/*
    Конструктор класса должен заполнять эти поля при создании объекта.
 */
    public Employee(String name, String position, String eMail, long phoneNumber, int salary, int age) {
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

    public static void main(String[] args) {
/*
        Создать массив из 5 сотрудников.
 */
        Employee[] array = new Employee[5];
        array[0] = new Employee("Petro", "operator", "petroHot@mail.ru", 911050000, 10000, 35);
        array[1] = new Employee("Dima", "washer", "srey@gmail.com", 812454545, 9000, 25);
        array[2] = new Employee("John", "translator", "johnuoch@rambler.ru", 921236121, 11500, 40);
        array[3] = new Employee("Sveva", "seller", "svtonline@yandex.ru", 495444223, 25000, 26);
        array[4] = new Employee("Vova", "security guard", "wwwvovan@yahoo.com", 346444582, 7500, 52);
/*
        С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
        for (Employee a : array) {
            if (a.age > 40) {
                printInfo(a);
            }
        }
    }
}

