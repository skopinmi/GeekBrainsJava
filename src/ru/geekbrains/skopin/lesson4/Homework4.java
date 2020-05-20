package ru.geekbrains.skopin.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static char[][] gameField;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_O = 'O';
    public static final char DOT_X = 'X';
    public static  char DOT_EMPTY = '*';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        boolean continueGame = true;
        System.out.println("Крестики - Нолики");
        do {
            makeGameField(SIZE);
            printGameField();
            playGame();
            System.out.println("");
            System.out.println("Будем играть еще?");
            System.out.println("Да 1 / Нет 0");
            if (scanner.nextInt() == 0) {
                continueGame = false;
            }
        } while (continueGame);
    }
    public static void playGame (){                             // последовательность ходов и оформление игры
        while (true) {
            System.out.println("Ваш ход :");
            moveOfHuman();
            System.out.println("");
            printGameField();
            if (isWin(DOT_X)) {
                System.out.println("Вы выиграли.");
                break;
            }
            if (isGameFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
            System.out.println("Ход компьютера :");
            System.out.println("");
            moveOfAi2();
            printGameField();
            if (isWin(DOT_O)) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            if (isGameFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
    }
    public static boolean isWin(char symbol) {
        /* проверка циклами
         *  проводится счет указанных в аргументах символов
         *  по горизонталям, вертикалям и диагоналям при
         *  получении результата равного DOT_TO_WIN
         *  возвращает true
         *  */
        int countDotDiagonal1 = 0;
        int countDotDiagonal2 = 0;
        int countDotVertical;
        int countDotHorizontal;
        for (int i = 0; i < SIZE; i++) {
            countDotVertical = 0;                    //  обнуление счетчиков вертикалей и диагоналей
            countDotHorizontal = 0;                  //
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[i][ii] == symbol) {
                    countDotHorizontal++;
                }
                if (gameField[ii][i] == symbol) {
                    countDotVertical++;
                }
                if (countDotHorizontal == DOTS_TO_WIN || countDotVertical == DOTS_TO_WIN) {
                    return true; }
            }
            if(gameField[i][i] == symbol) {
                countDotDiagonal1++;
            }
            if (gameField[i][gameField.length - 1 - i] == symbol) {
                countDotDiagonal2++;
            }
            if (countDotDiagonal1 == DOTS_TO_WIN || countDotDiagonal2 == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }
    public static boolean isGameFieldFull () {
        for (char [] a : gameField){
            for(char b : a) {
                if (b == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void makeGameField (int SIZE) {
        gameField = new char [SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int ii = 0; ii < SIZE; ii++) {
                gameField [i] [ii] = DOT_EMPTY;
            }
        }
    }
    public static void printGameField () {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for(char a: gameField[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void moveOfHuman () {
        int x;
        int y;
        boolean rightPutIn = true;             // ошибка при введении координат true / false
        do {
            if (!rightPutIn) {
                System.out.println("Вероятно Вы ошиблись, повторите ход: ");
            }
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            rightPutIn = isSpaceValid(x, y);
        } while (!rightPutIn);
        gameField [x][y] = DOT_X;
    }
    public static void moveOfAi (){
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isSpaceValid( x, y ));
        gameField [x][y] = DOT_O;
    }
    public static boolean isSpaceValid (int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (gameField[x][y] == DOT_EMPTY) return true;
        return false;
    }
/*
        Далее методы отвечающие за AI

 */
    public static void moveOfAi2 (){                        // интеллект предупреждение проигрыша по горизонтали и вертикали
        int x;
        int y;
        int xForMoveAttack = getHorizontal(DOT_O);       // координата горизонтали предполагаемого выигрыша
        int yForMoveAttack = getVertical(DOT_O);         // координата вертикали предполагаемого выигрыша
        int xForMoveProtection = getHorizontal(DOT_X);   // координата горизонтали предполагаемого проигрыша
        int yForMoveProtection = getVertical(DOT_X);     // координата вертикали предполагаемого проигрыша
        int xDiagonalMoveAttack = getXInDiagonal(DOT_O);           // координата Х в диагонали предполагаемого выигрыша
        int yDiagonalMoveAttack = getYInDiagonal(DOT_O);           // координата У в диагонали предполагаемого выигрыша
        int xDiagonalProtection = getXInDiagonal(DOT_X);           // координата Х в диагонали предполагаемого проигрыша
        int yDiagonalProtection = getYInDiagonal(DOT_X);            // координата У в диагонали предполагаемого проигрыша
        do {
            if (xDiagonalMoveAttack != - 1 && yDiagonalMoveAttack != - 1) {
                x = xDiagonalMoveAttack;
                y = yDiagonalMoveAttack;
            } else if (xDiagonalProtection != - 1 && yDiagonalProtection != - 1){
                x = xDiagonalProtection;
                y = yDiagonalProtection;
            } else if (xForMoveAttack != -1 && yForMoveAttack == -1) {              // исключение случая когда образовалась "ВИЛКА" - заведомый проигрыш
                x = xForMoveAttack;                               //
                y = random.nextInt(SIZE);
            } else if ( xForMoveAttack == -1 && yForMoveAttack != -1 ) {
                y = yForMoveAttack;
                x = random.nextInt(SIZE);
            } else if (xForMoveProtection != -1 && yForMoveProtection == -1) {         // исключение случая когда образовалась "ВИЛКА" - заведомый проигрыш
                x = xForMoveProtection;                               //
                y = random.nextInt(SIZE);
            } else if ( xForMoveProtection == -1 && yForMoveProtection != -1 ) {
                y = yForMoveProtection;
                x = random.nextInt(SIZE);
            } else {
                y = random.nextInt(SIZE);
                x = random.nextInt(SIZE);
            }
        } while (!isSpaceValid( x, y ));
        gameField [x][y] = DOT_O;
    }
    public static boolean isHorizontalFull (int horizontal) {   // проверка горизонтали на полную заполненность
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {
            if (gameField[horizontal][i] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) return true;
        }
        return false;
    }
    public static boolean isVerticalFull (int vertical) {      // проверка вертикали на полную заполненность
        int countFullSpace = 0;
        for (int i = 0; i < SIZE; i++) {
            if (gameField[i][vertical] != DOT_EMPTY) {
                countFullSpace++;
            }
            if (countFullSpace == SIZE) return true;
        }
        return false;
    }
    public static int getVertical (char checkDot ){
        int yForMove = - 1;                               // координата вертикали  где проверяемых символов DOT_TO_WIN - 1
        for (int i = 0; i < SIZE; i++) {
            int countDotVertical = 0;                        // счет символов  по вертикалям
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[ii][i] == checkDot) {
                    countDotVertical++;
                }
                if (countDotVertical == (DOTS_TO_WIN - 1) && !isVerticalFull(i)) {     // символов в вертикаль на 1 меньше
                    yForMove = i;                                                      // до победы + вертикаль не заполнена полностью
                    break;
                }
            }
        }
        return  yForMove;
    }
    public static int getHorizontal (char checkDot ){

        int xForMove = - 1;                               // координата горизонтали где проверяемых символов DOT_TO_WIN - 1
        for (int i = 0; i < SIZE; i++) {
            int countDotHorizontal = 0;                      // счет символов в горизонтали где проверяемых символов DOT_TO_WIN - 1
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[i][ii] == checkDot) {
                    countDotHorizontal++;
                }
                if (countDotHorizontal == (DOTS_TO_WIN - 1) && !isHorizontalFull(i)) { // символов  в горизонтали на 1 меньше
                    xForMove = i;                                                      // до  победы + горизонталь не заполнена полностью
                    break;
                }
            }
        }
        return  xForMove;
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
