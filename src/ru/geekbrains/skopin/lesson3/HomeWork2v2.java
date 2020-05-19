package ru.geekbrains.skopin.lesson3;

import java.util.Scanner;
/*
   Второе задание
   с "памятью" о ранее угаданных символах.
   В последующих попытка  оставляет
   их на своих местах среди #.

 */
public class HomeWork2v2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"
        };
        String thisWord = guessTheWold(words);                                     // загадали слово
        System.out.println("Угадайте загаданное слово.");
        playGame2(sc, thisWord);
        sc.close();
    }
    private static void playGame2 (Scanner sc, String thisWord) {                   // игра
        Boolean win;
        String userGuessChars = "###############";                               // строка с отгаданными символами
        do {
            String userWord = sc.nextLine();                                           // слово игрока
            win = compareTwoWords(thisWord, userWord);
            userGuessChars = makeUserGuessChars(thisWord, userWord, userGuessChars); // изменяем строку с отгаданными символами
            if (!win) {
                System.out.println(userGuessChars);
                System.out.println("Попробуйте еще.");
            }
            sayResult(win);
        } while (!win);
    }
    private static String guessTheWold (String [] array) {
        int index = (int) (Math.random() * (array.length + 1));          // загадали число
        return array[index];
    }
    public static void sayResult (Boolean win) {                //печать результата
        System.out.println(win?"Вы угадали!":"Вы не угадали!");
    }

    public static Boolean compareTwoWords (String thisWord, String userWord) {  // сравнение слов да/нет
        return thisWord.equals(userWord);
    }

    public static String makeWordMoreChar (String word, int numberOfChar) {
        int size = word.length();                                             // уравниваем слова до 15 символов
        for (int i = 0; i < (numberOfChar - size); i++) {                     // все что меньше 15 допечатываем #
            word += "#";
        }
        return word;
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

}
