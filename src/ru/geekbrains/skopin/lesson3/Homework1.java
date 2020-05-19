package ru.geekbrains.skopin.lesson3;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {

        boolean continuePlay = true;
        Scanner sc = new Scanner(System.in);
        int numberTry = 3;
        int maxNumber = 9;
        while (continuePlay) {
            System.out.println("Угадайте число от 0 до " + maxNumber + ".");
            System.out.println("У Вас " + numberTry + " попытки.");
            boolean win = tryToGuess(sc, numberTry, maxNumber);
            sayResult(win);
            continuePlay = isNextGame(sc);
        }
        System.out.println("Игра закончена!");
        sc.close();
    }


    private static int guessTheNumber (int maxNumber) {
        int number = (int) (Math.random() * (maxNumber + 1));          // загадали число
        return number;
    }

    private static boolean tryToGuess (Scanner sc, int numberTry, int maxNumber) { //логика игры результат победа да/нет

        boolean win = false;
        int number = guessTheNumber(maxNumber);
        for (int i = 0; i < numberTry; i++) {
            int userNumber = sc.nextInt();
            if (number == userNumber) {                                // сравнение чисел
                win = true;
                break;
            } else {
                System.out.println(":( Не верно!");
                System.out.println(number > userNumber ? "Загаданное число больше Вашего." : "Загаданное число меньше Вашего.");
            }
        }
        return win;
    }

    private static void sayResult (Boolean win){ //печать результата
        System.out.println(win?"Вы угадали!":"Вы не угадали!");
    }

    private static Boolean isNextGame (Scanner sc) { // запрос продолжать ли игру?
        System.out.println("Попробуйте еще раз?");
        System.out.println("Повторить игру еще раз? 1 - да / 0 - нет.");
        return sc.nextInt() != 0; // получение ответа
    }
}
