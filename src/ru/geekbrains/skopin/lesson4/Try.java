package ru.geekbrains.skopin.lesson4;

public class Try {
    public static int SIZE = 3;
    public static char[][] gameField;
    public static final char DOT_O = 'O';
    public static final char DOT_X = 'X';
    public static char DOT_EMPTY = '*';
    public static final int DOTS_TO_WIN = 3;

    public static void main(String[] args) {
        gameField = new char[SIZE][SIZE];
        gameField[0][0] = 'O';
        gameField[0][1] = '*';
        gameField[0][2] = '*';
        gameField[1][0] = '*';
        gameField[1][1] = 'O';
        gameField[1][2] = 'O';
        gameField[2][0] = 'O';
        gameField[2][1] = '*';
        gameField[2][2] = 'O';
        printGameField();
        System.out.println(isWin('O'));
    }

    public static void makeGameField(int SIZE) {
        gameField = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int ii = 0; ii < SIZE; ii++) {
                gameField[i][ii] = DOT_EMPTY;
            }
        }
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

    public static boolean isWin(char symbol) {
        /* проверка циклами*/
        int countDotDiagonal1 = 0;
        int countDotDiagonal2 = 0;
        int countDotVertical;
        int countDotHorizontal;
        for (int i = 0; i < SIZE; i++) {
            countDotVertical = 0;
            countDotHorizontal = 0;
            for (int ii = 0; ii < SIZE; ii++) {
                if (gameField[i][ii] == symbol) {
                    countDotHorizontal++;
                }
                if (gameField[ii][i] == symbol) {
                    countDotVertical++;
                }
                if (countDotHorizontal == DOTS_TO_WIN || countDotVertical == DOTS_TO_WIN) { return true; }
            }
            if(gameField[i][i] == symbol) {
                countDotDiagonal1++;
            }
            if (gameField[i][gameField.length - 1 - i] == symbol) {
                countDotDiagonal2++;
            }
        }
        if (countDotDiagonal1 == DOTS_TO_WIN || countDotDiagonal2 == DOTS_TO_WIN) {return true;}
        return false;
    }
}
