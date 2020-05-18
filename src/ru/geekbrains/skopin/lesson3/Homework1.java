package ru.geekbrains.skopin.lesson3;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {

        boolean play = true;
        Scanner sc = new Scanner(System.in);
        int numberTry = 3;
        int maxNumber = 9;
        while (play) {
            System.out.println("Угадайте загаданное число от 0 до " + maxNumber + ".");
            System.out.println("У Вас " + numberTry + " попытки.");
            sayResult(playGame(sc, numberTry, maxNumber));
            play = isNextGame(sc);
        }
        System.out.println("Игра закончена!");
        sc.close();
    }

    public static boolean playGame (Scanner sc, int numberTry, int maxNumber) { //логика игры результат победа да/нет

        boolean win = false;
        int number = (int) (Math.random() * (maxNumber + 1));          // загадали число
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

    public static void sayResult (Boolean win){ //печать результата
        System.out.println(win?"Вы угадали!":"Вы не угадали!");
    }

    public static Boolean isNextGame (Scanner sc) { // запрос продолжать ли игру?
        System.out.println("Попробуйте еще раз?");
        System.out.println("Повторить игру еще раз? 1 - да / 0 - нет.");
        return sc.nextInt() != 0; // получение ответа
    }
}
