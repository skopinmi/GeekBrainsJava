package ru.geekbrains.skopin.lesson2;

public class Exercise6 {
    public static void main(String[] args) {
        int [] array1 = { 1, 1, 1, 1, 1, 1, 1, 7};    // true
        int [] array2 = { 7, 1, 1, 1, 1, 1, 1, 1};    // true
        int [] array3 = { 1, 1, 1, 1, 1, 1, 1, 1};    // true
        int [] array4 = { 1, 1, 1, 1, 2, 1, 1, 1};    // false
        System.out.println(middleWay(array1));
        System.out.println(middleWay(array2));
        System.out.println(middleWay(array3));
        System.out.println(middleWay(array4));
    }

    private static Boolean middleWay (int [] array) {


        for (int i = 1; i < array.length; i++) {                         // середина изменение позиции
            int sumLeft = 0;
            int sumRight = 0;
            for (int left = 0; left < i; left++) {                      // счет левой половины
                sumLeft += array[left];
            }

            for (int right =  i; right < array.length; right++) {        // счет правой половины
                sumRight += array[right];
            }

            if (sumLeft == sumRight) {                                       // проверка равенства
                return true;
            }

        }
        return false;
    }
}
