package ru.geekbrains.skopin.lesson2;

public class HomeworkLesson2 {
    public static void main(String[] args) {
/*      exercise1 :
 */
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeArray(array);
//        for(byte a : newArray) {
//            System.out.print(a); //print second array
//        }

/*      exercise2 :
 */
        int [] array2 = new int [8];
        putInArray(array2);
//        for (int a : array2) {
//            System.out.print(a + " ");
//        }

/*      exercise3 :
 */
        int [] array3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        multiplySix(array3);
//        for (int a : array3) {
//            System.out.print(a + " ");
//        }

/*      exercise4 :
 */
        int [] [] arraySquare = new int [5] [5];
//        putXInSquareArray(arraySquare);
//        for(int i = 0; i < arraySquare.length; i++) {
//            for (int ii = 0; ii < arraySquare [i].length; ii++) {
//                System.out.print(arraySquare[i][ii] + " ");
//            }
//            System.out.println("");
//        }
//        другой цикл :
//        for(int []  a : arraySquare) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println("");
//        }

/*      exercise5 :
 */
        int [] array5 = { 10, -1, 20, -5, 0, 150, 49, - 78, 24, 4 };
//        System.out.println("");
//        System.out.println("Минимальное число  - " + getMax(array5));
//        System.out.println("Максимальное число - " + getMin(array5));

/*      exercise6 :
        test:
 */
//        int [] arrayX1 = { 1, 1, 1, 1, 1, 1, 1, 7};    // true
//        int [] arrayX2 = { 7, 1, 1, 1, 1, 1, 1, 1};    // true
//        int [] arrayX3 = { 1, 1, 1, 1, 1, 1, 1, 1};    // true
//        int [] arrayX4 = { 1, 1, 1, 1, 2, 1, 1, 1};    // false
//        System.out.println(isMiddleWay(arrayX1));
//        System.out.println(isMiddleWay(arrayX2));
//        System.out.println(isMiddleWay(arrayX3));
//        System.out.println(isMiddleWay(arrayX4));
/*       esercise7:
         test:
 */
        int[] arrayForDislocation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int dislocation =   -1;
        arrayForDislocation = dislocateArray(arrayForDislocation, dislocation);
        for (int a : arrayForDislocation) {
            if (dislocation < 0) {
                System.out.print(a + " < ");
            } else {
                System.out.print(a + " > ");
            }
        }
    }
    private static void changeArray (byte[] array) {
        for (int i = 0; i < array.length; i++ ) {
            if (array[i] == 1) {
                array[i] = 0;
            }
            else {
                array[i] = 1;
            }
        }
    }
    private static void putInArray (int[] array) {
        for (int i = 0; i < array.length; i++){
            array [i] = i * 3;
        }
    }
    private static void multiplySix (int [] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 6;
            }
        }
    }
    private static void putXInSquareArray (int [] [] arraySquare) {
        for (int i = 0; i < arraySquare.length; i++){
            arraySquare [i] [i] = 1;
            arraySquare [i] [arraySquare.length -1 - i] = 1;
        }
    }

    private static int getMax (int [] array) {
        int maxNumber = array [0];
        for (int i = 0; i < array.length; i++) {
            if (maxNumber < array[i]) {
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }
    private static int getMin (int[] array) {
        int minNumber = array [0];
        for (int i = 0; i < array.length; i++) {
            if (minNumber > array[i]) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }

    private static Boolean isMiddleWay (int [] array) {


        for (int i = 1; i < array.length; i++) {                         // середина изменение позиции
            int sumLeft = 0;
            int sumRight = 0;
            for (int left = 0; left < i; left++) {                      // счет левой половины
                sumLeft += array[left];
            }

            for (int right =  i; right < array.length; right++) {        // счет правой половины
                sumRight += array[right];
            }

            if (sumLeft == sumRight) {                                       // проверка равенства если да возврат
                return true;
            }

        }
        return false;
    }

    private static int [] dislocateArray (int [] array, int dislocation) {
        int dis = dislocation;
        if (dis < 0) {                   // получение необходимого количества смещений положительная величина
            dis *= - 1;
        }

        for( int z = 0; z < dis; z++ ){
            int change = array[0];
            int change2;
            int nextPosition;
            if (dislocation < 0) {                                 // первичное определение индекса
                nextPosition = array.length - 1;                   // для следующего смещения в зависимости от направления
            } else {                                               // смещения
                nextPosition = 1;
            }
            for (int i = 0; i < array.length; i++) {

                change2 = array [nextPosition];                      // сам
                array[nextPosition] = change;                        // процесс
                change = change2;                                    // смещения

                if (dislocation > 0) {                               // определение следующего положения
                    nextPosition ++;                               // в массиве для смещения
                } else {
                    nextPosition --;
                }
                if (nextPosition > array.length - 1) {              // проверка на соответсвование
                    nextPosition = nextPosition - array.length;     // индекса следующей позиции
                }                                                   // к наличию в массиве , коррекция
                if (nextPosition < 0) {
                    nextPosition = nextPosition + array.length;
                }
            }
        }
        return array;
    }
}
