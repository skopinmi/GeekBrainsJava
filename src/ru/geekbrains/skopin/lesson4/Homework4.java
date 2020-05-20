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
        System.out.println("Крестики - Нолики");
        makeGameField(SIZE);
        printGameField();
        playGame();
    }
    public static void playGame (){
        while (true) {
            System.out.println("Ваш ход :");

            moveOfHuman();
            if (isGameFieldFull()) {
                printGameField();
                System.out.println("Ничья.");
                break;
            }
            if (isWin(DOT_X)) {
                System.out.println("Вы выиграли.");
                break;
            }
            printGameField();
            System.out.println("Ход компьютера :");
            moveOfAi();
            if (isGameFieldFull()) {
                printGameField();
                System.out.println("Ничья.");
                break;
            }
            if (isWin(DOT_O)) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            printGameField();
        }
    }
    public static boolean isWin(char symbol) {
        /* проверка циклами*/
        int countDotDiagonal1 = 0;
        int countDotDiagonal2 = 0;
        int countDotVertical = 0;
        int countDotHorizontal = 0;
        for (int i = 0; i < SIZE; i ++) {
            for (int ii = 0; ii < SIZE; ii ++) {
                if (gameField[i][ii] == symbol) {
                    countDotHorizontal++;
                }
                if(gameField[ii][i] == symbol) {
                    countDotVertical++;
                }
                if (gameField[ii][ii] == symbol) {
                    countDotDiagonal1++;
                }
                if (gameField[i][gameField[i].length - 1 - ii] == symbol) {
                    countDotDiagonal2++;
                }
            }
        }
        if(countDotHorizontal == DOTS_TO_WIN || countDotVertical == DOTS_TO_WIN
                || countDotDiagonal1 == DOTS_TO_WIN||countDotDiagonal2 ==DOTS_TO_WIN) {
            return true;
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
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isSpaceValid( x, y ));
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
}
