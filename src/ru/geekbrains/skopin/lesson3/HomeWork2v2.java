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
        String userGuessChars = "###############";    // строка с отгаданными символами
        int indexWord = (int) (Math.random() * 25);
        Boolean win;
        String thisWord = words[indexWord];                                     // загадали слово
        System.out.println("Угадайте загаданное слово." + thisWord);
        String userWord;
        do {
            userWord = sc.nextLine();
            win = compareTwoWords(thisWord, userWord);
            userGuessChars = makeUserGuessChars2(thisWord, userWord, userGuessChars); // изменяем строку с отгаданными символами
            if (!win) {
                System.out.println(userGuessChars);
                System.out.println("Попробуйте еще.");
            }
            sayResult(win);
        } while (!win);
        sc.close();
    }

    public static void sayResult (Boolean win) {                //печать результата
        System.out.println(win?"Вы угадали!":"Вы не угадали!");
    }

    public static Boolean compareTwoWords (String thisWord, String userWord) {  // сравнение слов да/нет
        return thisWord.equals(userWord);
    }

    public static String makeWord15Char (String word) {
        int size = word.length();                                 // уравниваем слова до 15 символов
        for (int i = 0; i < 15 - size; i++) {                     // все что меньше 15 допечатываем #
            word += "#";
        }
        return word;
    }

    public static String makeUserGuessChars2 (String thisWord, String userWord, String userGuessChars) {
        String buildWord = "";
        int littleWord = Math.min(thisWord.length() , userWord.length()) ;
        for (int i = 0; i < littleWord; i++) {                             // запись в  String  совпавших символов
            char a = thisWord.charAt(i);                                   // и символов #
            char b = userWord.charAt(i);
            char c = userGuessChars.charAt(i);
            if (a == b) {
                buildWord += a;
            } else if ((int) c != 35) {                                 // если на этой позиции не # буква отгадана игроком
                buildWord += c;
            } else {
                buildWord += "#";
            }
        }
        userGuessChars = makeWord15Char(buildWord);                      // дописать до 15 символов
        return userGuessChars;
    }

}
