package ru.geekbrains.skopin.lesson2;

public class Exercise7 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int dislocation =  2;
        array = dislocationArray(array, dislocation);
    /* test : */
        for (int a : array) {
            System.out.print(a + " ");
        }
    }


    private static int [] dislocationArray (int [] array, int dislocation) {
        int dis;
        if (dislocation < 0) {                   // получение необходимого количества
            dis = dislocation * - 1;
        } else {
            dis = dislocation;
        }
        for( int z = 0; z < dis; z++ ){
            int change = array[0];
            int change2;
            int nextPosition;
            if (dislocation < 0) {                                 // первичное определение индекса
                nextPosition = array.length - 1;                   // для следующего смещения
            } else {
                nextPosition = 1;
            }
            for (int i = 0; i < array.length; i++) {

                change2 = array [nextPosition];                      // сам
                array[nextPosition] = change;                        // процесс
                change = change2;                                    // смещения

                if (dislocation > 0) {                               // определение следующего положения
                    nextPosition += 1;                               // в массиве для смещения
                } else {
                    nextPosition -= 1;
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
