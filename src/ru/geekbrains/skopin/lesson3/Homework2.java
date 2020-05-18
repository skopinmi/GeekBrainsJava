package ru.geekbrains.skopin.lesson3;

import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"
        };
        int indexWord = (int) (Math.random() * 25);
        Boolean win;
        String thisWord = words[indexWord];                                     // загадали слово
        System.out.println("Угадайте загаданное слово.");
        String userWord;
        do {
            userWord = sc.nextLine();
            win = compareTwoWords(thisWord, userWord);
            if (!win) {
                printChars(thisWord, userWord);
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

    public static void printChars (String thisWord, String userWord){           // печать совпавших букв и #
        int littleWord = Math.min(thisWord.length() , userWord.length()) ;
        for (int i = 0; i < littleWord; i++) {                             // печать совпадений
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
}
