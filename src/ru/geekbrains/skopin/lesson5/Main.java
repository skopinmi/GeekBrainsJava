package ru.geekbrains.skopin.lesson5;

public class Main {
    public static void main(String[] args) {
/*
        Создать массив из 5 сотрудников.
 */
        Employee[] array = new Employee[5];
        array[0] = new Employee("Petro", "operator", "petroHot@mail.ru", "89110500000", 10000, 35);
        array[1] = new Employee("Dima", "washer", "srey@gmail.com", "88124545245", 9000, 25);
        array[2] = new Employee("John", "translator", "johnuoch@rambler.ru", "89212361213", 11500, 40);
        array[3] = new Employee("Sveta", "seller", "svtonline@yandex.ru", "84954442237", 25000, 26);
        array[4] = new Employee("Vova", "security guard", "wwwvovan@yahoo.com", "83464445827", 7500, 52);
/*
        С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
        for (Employee a : array) {
            if (a.age > 40) {
                Employee.printInfo(a);
            }
        }
    }
}
