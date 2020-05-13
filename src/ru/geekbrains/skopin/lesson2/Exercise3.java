package ru.geekbrains.skopin.lesson2;

public class Exercise3 {
    public static void main(String[] args) {
        int [] array = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array [i] *= 6;
            }
        }
//    /* test: */
//        for (int a : array) {
//            System.out.print(a + " ");
//        }
    }
}
