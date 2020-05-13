package ru.geekbrains.skopin.lesson2;

public class Exercise4 {
    public static void main(String[] args) {
        int [] [] arraySquare = new int [5] [5];
        for (int i = 0; i < arraySquare.length; i++){
            arraySquare [i] [i] = 1;
            arraySquare [i] [arraySquare.length -1 - i] = 1;
        }
    /* test: */
        for(int i = 0; i < arraySquare.length; i++) {
            for (int ii = 0; ii < arraySquare.length; ii ++) {
                System.out.print(arraySquare[i][ii] + " ");
            }
            System.out.println("");
        }
    }
}
