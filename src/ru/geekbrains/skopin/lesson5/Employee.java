package ru.geekbrains.skopin.lesson5;

public class Employee {
    public String name;
    public String position;
    public String eMail;
    public long phoneNumber;
    public int salary;
    public int age;

    public Employee(String name, String position, String eMail, long phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void main(String[] args) {

        Employee[] array = new Employee[5];
        array[0] = new Employee("Petro", "operator", "petroHot@mail.ru", 911050000, 10000, 35);
        array[1] = new Employee("Dima", "washer", "srey@gmail.com", 812454545, 9000, 25);
        array[2] = new Employee("John", "translator", "johnuoch@rambler.ru", 921236121, 11500, 40);
        array[3] = new Employee("Sveva", "seller", "svtonline@yandex.ru", 495444223, 25000, 26);
        array[4] = new Employee("Vova", "security guard", "wwwvovan@yahoo.com", 346444582, 7500, 52);
        for (Employee a : array) {
            if (a.age > 40) {
                System.out.println("Name: " + a.name);
                System.out.println("position: " + a.position);
                System.out.println("Email: " + a.eMail);
                System.out.println("Phone number: " + a.phoneNumber);
                System.out.println("Salary: " + a.salary);
                System.out.println("Age: " + a.age);
            }
        }
    }
}

