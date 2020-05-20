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
        gameField[0][0] = 'O';
        gameField[0][1] = 'O';
        gameField[0][2] = 'O';
        gameField[1][0] = '*';
        gameField[1][1] = 'O';
        gameField[1][2] = 'O';
        gameField[2][0] = 'O';
        gameField[2][1] = '*';
        gameField[2][2] = 'O';
        printGameField();
        System.out.println(isHorizontalFull(0));
        System.out.println(isVerticalFull(0));
    }

    public static int checkVerticalOneMoveToWin (char checkDot ){
        int yForMove = - 1;                               // координата вертикали предполагаемого проигрыша
        for (int i = 0; i < SIZE; i++) {
            int countDotVertical = 0;                        // счет символов противника по вертикалям
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[ii][i] == checkDot) {
                    countDotVertical++;
                }
                if (countDotVertical == (DOTS_TO_WIN - 1) && !isVerticalFull(i)) {     // символов противника в вертикаль на 1 меньше
                    yForMove = i;                                                      // до его победы + вертикаль не заполнена полностью
                    break;
                }
            }
        }
        return  yForMove;
    }
    public static int checkHorizontalOneMoveToWin (char checkDot ){

        int xForMove = - 1;                               // координата горизонтали предполагаемого проигрыша
        for (int i = 0; i < SIZE; i++) {
            int countDotHorizontal = 0;                      // счет символов противника по горизонталям
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[i][ii] == checkDot) {
                    countDotHorizontal++;
                }
                if (countDotHorizontal == (DOTS_TO_WIN - 1) && !isHorizontalFull(i)) { // символов противника в горизонтали на 1 меньше
                    xForMove = i;                                                      // до его победы + горизонталь не заполнена полностью
                    break;
                }
            }
        }
        return  xForMove;
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
    public static boolean isHorizontalFull (int horizontal) {
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {

            if (gameField[horizontal][i] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) return true;
        }
        return false;
    }
    public static boolean isVerticalFull (int vertical) {
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {

            if (gameField[i][vertical] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) return true;
        }
        return false;
    }




}
