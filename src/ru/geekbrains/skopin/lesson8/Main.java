
package ru.geekbrains.skopin.lesson8;

import java.util.Random;
import java.util.Scanner;

public class Main {
/*
    еще есть глюки ...
 */

    public static final int SIZE = 3;
    public static String[][] gameField = new String [SIZE][SIZE];;
    public static final int DOTS_TO_WIN = 3;
    public static String DOT_EMPTY = "*";
    private static String  DotComp = "O";
    private static String DotHuman = "X";
    public static Random random = new Random();
    private static boolean myMove = true;
    public static int countOfHumanWin = 0;
    public static int countOfAIWin = 0;
    public static int countOfDraw = 0;


    public static void main(String[] args) {

        GameWindow gameWindow = GameWindow.createGameWindow();
        gameWindow.setVisible(true);
        boolean continueGame = true;
        newGameField(SIZE);
        do {
            playGame();
            setMyMove(true);
        } while (continueGame);
    }


    public static boolean isGameFieldFull () {
        for (String [] a : gameField){
            for(String b : a) {
                if (b.equals(DOT_EMPTY)) return false;
            }
        }
        return true;
    }

    public static void newGameField (int SIZE) {
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
            for(String a: gameField[i]) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playGame (){                             // последовательность ходов и оформление игры
        while (true) {

            if (isWin(DotHuman)) {
                MassageWindow.createMassageWindow("Вы выиграли.");

//                countOfHumanWin++;
                break;
            }
            if (isGameFieldFull()) {
                MassageWindow.createMassageWindow("Ничья.");
//                countOfDraw++;
                break;
            }

            if (!myMove) {
                moveOfAi();
                printGameField();
                if (isWin(DotComp)) {
                    MassageWindow.createMassageWindow("Компьютер выиграл.");
//                countOfAIWin++;
                    break;
                }
                if (isGameFieldFull()) {
                    MassageWindow.createMassageWindow("Ничья.");
//                countOfDraw++;
                    break;
                }
            }
        }
        newGameField(SIZE);
    }

    public static void setMyMove(boolean myMove) {
        Main.myMove = myMove;
    }

    public static String getDotComp() {
        return DotComp;
    }

    public static void putInGameField (int x, int y) {
        gameField[y][x] = DotHuman;
    }
    public static String getGameField (int x, int y) {
        return gameField[y][x];
    }

    public static void moveOfAi (){
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isSpaceValid( x, y ));
        gameField [y][x] = DotComp;
        GameWindow.setJButton(x, y);
        setMyMove(true);
        printGameField();
    }

    public static boolean isWin(String symbol) {

        int countDotDiagonal1 = 0;
        int countDotDiagonal2 = 0;
        int countDotVertical;
        int countDotHorizontal;
        for (int i = 0; i < SIZE; i++) {
            countDotVertical = 0;                    //  обнуление счетчиков вертикалей и диагоналей
            countDotHorizontal = 0;                  //
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[i][ii].equals(symbol)) {
                    countDotHorizontal++;
                } else {
                    if (SIZE > 3) {
                        countDotHorizontal = 0;           //сброс на ноль для счета фишек только в один ряд
                    }
                }                                     //для случеев когда SIZE > DOT_TO_WIN
                if (gameField[ii][i].equals(symbol)) {
                    countDotVertical++;
                } else {
                    if (SIZE > 3) {
                        countDotHorizontal = 0;           //сброс на ноль для счета фишек только в один ряд для SIZE > 3
                    }
                }
                if (countDotHorizontal == DOTS_TO_WIN || countDotVertical == DOTS_TO_WIN) {
                    return true; }
            }
            if(gameField[i][i].equals(symbol)) {
                countDotDiagonal1++;
            } else {
                if (SIZE > 3) {
                    countDotDiagonal1 = 0;           //сброс на ноль для счета фишек только в один ряд для SIZE > 3
                }
            }
            if (gameField[i][gameField.length - 1 - i].equals(symbol)) {
                countDotDiagonal2++;
            } else {
                if (SIZE > 3) {
                    countDotDiagonal2 = 0;           //сброс на ноль для счета фишек только в один ряд для SIZE > 3
                }
            }
            if (countDotDiagonal1 == DOTS_TO_WIN || countDotDiagonal2 == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }
    public static boolean isSpaceValid (int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return gameField[y][x].equals(DOT_EMPTY);
    }

    public static void setDotComp(String dotComp) {
        DotComp = dotComp;
    }

    public static void setDotHuman(String dotHuman) {
        DotHuman = dotHuman;
    }
}

/*







    public static void main(String[] args) {

        System.out.println("Вы виграли " + countOfHumanWin + " раз.");
        System.out.println("Компьютер выиграл " + countOfAIWin + " раз.");
        System.out.println("Игр вничью " + countOfDraw + ".");
    }

 */
   /*









 */