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
        String thisWord =  guessTheWold(words);                                 // загадали слово
        System.out.println("Угадайте загаданное слово.");
        playGame(sc, thisWord);                                                 // игра
        sc.close();
    }
    private static void playGame (Scanner sc, String thisWord) {
        Boolean win;
        do {
            String userWord = sc.nextLine();                                           // слово игрока
            win = compareTwoWords(thisWord, userWord);
            if (!win) {
                printChars(thisWord, userWord);
                System.out.println("Попробуйте еще.");
            }
            sayResult(win);
        } while (!win);
    }
    private static String guessTheWold (String [] array) {
        int index = (int) (Math.random() * (array.length + 1));          // загадали число
        return array[index];
    }
    private static void sayResult (Boolean win) {                //печать результата
        System.out.println(win?"Вы угадали!":"Вы не угадали!");
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
}
