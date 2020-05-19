package ru.geekbrains.skopin.lesson3;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
/*
        Одинаковый код для всех задач
*/
        Scanner sc = new Scanner(System.in);

/*      Задача №1
        Угадай число
*/
        int numberTry = 3;
        int maxNumber = 9;
        gameGuessNumber(sc, numberTry,maxNumber);

/*
        Задача №2
        Два варианта исполнения
        в методе playGame
        в методе playGame2 сохраняются ранее отгаданные символы и указываюся в строке #### на своих местах.
*/
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"
        };
        String thisWord =  guessTheWord(words);                                 // загадали слово
        System.out.println("Угадайте загаданное слово.");
        System.out.println("###############");
//      игра №1 :
        playGame(sc, thisWord);
//      игра вариант №2 :
//        playGame2(sc, thisWord);

/*
        общий код для задач - завершение работы программы
 */
        System.out.println("Игра закончена!");
        sc.close();
    }

    private static void gameGuessNumber (Scanner sc, int numberTry, int maxNumber) {
        boolean continuePlay = true;
        while (continuePlay) {
            System.out.println("Угадайте число от 0 до " + maxNumber + ".");
            System.out.println("У Вас " + numberTry + " попытки.");
            boolean win = tryToGuess(sc, numberTry, maxNumber);
            sayResult(win);
            continuePlay = isNextGame(sc);
        }
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

    private static void playGame (Scanner sc, String thisWord) {                  // логика игры
        Boolean win;
        do {
            String userWord = sc.nextLine();                                           // слово игрока
            win = compareTwoWords(thisWord, userWord);
            printChars(thisWord, userWord);
            sayResult(win);
            if (!win) {
                System.out.println("Попробуйте еще раз.");
            }

        } while (!win);
    }

    private static void playGame2 (Scanner sc, String thisWord) {                   // игра
        Boolean win;
        String userGuessChars = "###############";                               // строка с отгаданными символами
        do {
            String userWord = sc.nextLine();                                           // слово игрока
            win = compareTwoWords(thisWord, userWord);
            userGuessChars = makeUserGuessChars(thisWord, userWord, userGuessChars); // изменяем строку с отгаданными символами
            System.out.println(userGuessChars);
            sayResult(win);
            if (!win) {
                System.out.println("Попробуйте еще раз.");
            }

        } while (!win);
    }

    private static String guessTheWord (String [] array) {
        int index = (int) (Math.random() * (array.length + 1));          // загадали число
        return array[index];
    }

    private static Boolean compareTwoWords (String thisWord, String userWord) {  // сравнение слов да/нет
        return thisWord.equals(userWord);
    }

    private static void printChars (String thisWord, String userWord){          // печать совпавших букв и #
        int littleWord = Math.min(thisWord.length() , userWord.length()) ;     // выбор меньшего слова
        for (int i = 0; i < littleWord; i++) {                                 // печать совпадений
            char a = thisWord.charAt(i);                                       // и символов #
            char b = userWord.charAt(i);
            if (a == b) {
                System.out.print(a);
            } else {
                System.out.print("#");
            }
        }
        for (int i = 0; i < 15 - littleWord; i++) {                     // все что меньше 15 допечатываем #
            System.out.print("#");
        }
        System.out.println("");
    }

    private static String makeUserGuessChars (String thisWord, String userWord, String userGuessChars) {
        String buildWord = "";
        if (thisWord.length() < userWord.length()) {                              //          выбираем меньшее слово
            thisWord = makeWordMoreChar(thisWord, userWord.length());             //          уравниваем до большего
        } else {                                                                  //          добавление #
            userWord = makeWordMoreChar(userWord, thisWord.length());
        }
        for (int i = 0; i < thisWord.length(); i++) {                             // запись в  String  совпавших символов
            char a = thisWord.charAt(i);                                   // и символов #
            char b = userWord.charAt(i);
            char c = userGuessChars.charAt(i);
            if (a == b) {
                buildWord += a;
            } else if ( c != 35) {                                 // если на этой позиции не # буква отгадана игроком
                buildWord += c;
            } else {
                buildWord += "#";
            }
        }
        userGuessChars = makeWordMoreChar(buildWord, 15);                      // дописать до 15 символов
        return userGuessChars;
    }

    private static String makeWordMoreChar (String word, int numberOfChar) {
        int size = word.length();                                             // уравниваем слова до 15 символов
        for (int i = 0; i < (numberOfChar - size); i++) {                     // все что меньше 15 допечатываем #
            word += "#";
        }
        return word;
    }
}
