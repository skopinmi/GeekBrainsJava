package ru.geekbrains.skopin.lesson1;

public class Exercise8 {

    public static void main(String[] args) {
//     /* test : */
//        getStatus(1700); // false
//        getStatus(1800); // false
//        getStatus(1900); // false
//        getStatus(1600); // true
//        getStatus(2000); // true
//        getStatus(2100); // false
//        getStatus(2200); // false
//        getStatus(1560); // false
//        getStatus(2020); // true

    }
    public static void getStatus (int year) {
        if (year % 400 == 0 && year % 100 == 0 ) {
            System.out.println( " Високосный ");
        } else if (year % 4 == 0 && year % 100 > 0) {
            System.out.println( " Високосный ");
        } else {
            System.out.println( " Невисокосный ");
        }
    }
}