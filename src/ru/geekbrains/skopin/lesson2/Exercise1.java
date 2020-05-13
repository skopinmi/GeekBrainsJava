package ru.geekbrains.skopin.lesson2;

public class Exercise1 {
/*  Задача выполнена в методе
*   выглядит не очень хорошо :) */

    public static void main(String[] args) {
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    /* test : */
//        for(byte a : array) {
//            System.out.print(a); //print first array
//        }
//        System.out.println("");

        array = changeArray(array);
    /* test : */
//        for(byte a : array) {
//            System.out.print(a); //print second array
//        }
    }
    private static byte [] changeArray (byte[] array) {
        for (int i = 0; i < array.length; i++ ) {
            if (array[i] == 1) {
                array[i] = 0;
            }
            else {
                array[i] = 1;
            }
        }
        return array;
    }
}

