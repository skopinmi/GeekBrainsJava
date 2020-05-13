package ru.geekbrains.skopin.lesson2;

public class Exercise5 {
    public static void main(String[] args) {
        int [] array = { 10, -1, 20, -5, 0, 150, 49, - 78, 24, 4 };
        int maxNumber = array [0];
        int minNumber = array [0];
        for (int i = 0; i < array.length; i++) {
            if (maxNumber < array[i]) {
                maxNumber = array[i];
            }
            if (minNumber > array[i]) {
                minNumber = array[i];
            }
        }
    /* test : */
//        for(int a: array) {                         // print array
//            System.out.print(a + " ");
//        }
//        System.out.println("");
//        System.out.println("Минимальное число  - " + minNumber);     // print min
//        System.out.println("Максимальное число - " + maxNumber);     // print max
    }
}
