package ru.geekbrains.skopin.lesson4;

import java.util.Random;

public class Try {
    public static int SIZE = 3;
    public static char[][] gameField;
    public static final char DOT_O = 'O';
    public static final char DOT_X = 'X';
    public static char DOT_EMPTY = '*';
    public static final int DOTS_TO_WIN = 3;
    public static Random random = new Random();

    public static void main(String[] args) {
        gameField = new char[SIZE][SIZE];
        gameField[0][0] = '*';
        gameField[0][1] = 'O';
        gameField[0][2] = 'X';
        gameField[1][0] = '*';
        gameField[1][1] = 'O';
        gameField[1][2] = 'O';
        gameField[2][0] = 'O';
        gameField[2][1] = '*';
        gameField[2][2] = 'O';
        printGameField();
        System.out.println(isDiagonal1OneMoveToFull(DOT_O));
        System.out.println(isDiagonal2OneMoveToFull(DOT_O));
        System.out.println(getXInDiagonal(DOT_O));
        System.out.println(getYInDiagonal(DOT_O));
    }
    public static void printGameField() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (char a : gameField[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getXInDiagonal(char symbol){    // получение Х в диагонали
        int x = - 1;
        if(isDiagonal1OneMoveToFull(symbol)) {
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][i] == DOT_EMPTY) {
                    return i;
                }
            }
        } else if (isDiagonal2OneMoveToFull(symbol)) {
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][SIZE - 1 - i] == DOT_EMPTY) {
                    return i;
                }
            }
        }
        return x;
    }
    public static int getYInDiagonal(char symbol) {            // получение y в диагонали
        int y = -1;
        if (isDiagonal1OneMoveToFull(symbol)) {
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][i] == DOT_EMPTY) {
                    return i;
                }
            }
        } else if (isDiagonal2OneMoveToFull(symbol)) {
            for (int i = 0; i < SIZE; i++) {
                if (gameField[i][SIZE - 1 - i] == DOT_EMPTY) {
                    return (SIZE - 1 - i);
                }
            }
        }
        return y;
    }

    public static boolean isDiagonal1OneMoveToFull (char symbol ) {  // есть ли в дигонали  символов DOT_TO_WIN - 1
        int countDotDiagonal1 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (gameField[i][i] == symbol) {
                countDotDiagonal1 ++;
            }
            if (countDotDiagonal1 == (DOTS_TO_WIN - 1) && !isDiagonal1Full()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDiagonal2OneMoveToFull (char symbol) {  // есть ли в дигонали  символов DOT_TO_WIN - 1
        int countDotDiagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (gameField[i][SIZE - 1 - i] == symbol) {
                countDotDiagonal2++;
            }
            if (countDotDiagonal2 == (DOTS_TO_WIN - 1) && !isDiagonal2Full()) {
                return true;
            }
        }
        return false;
    }
    public static boolean isDiagonal1Full () {                     // проверка диагонали 1 на полную заполненность
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {

            if (gameField[i][i] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) {
                return true;
            }
        }
        return false;
    }
    public static boolean isDiagonal2Full () {                     // проверка диагонали 2 на полную заполненность
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {
            if (gameField[i][SIZE - 1 - i] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) return true;
        }
        return false;
    }


}
