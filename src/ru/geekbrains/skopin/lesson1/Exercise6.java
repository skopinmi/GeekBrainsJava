
package ru.geekbrains.skopin.lesson1;

public class Exercise6 {

    public static void main(String[] args) {
        /*    проверка : */
        System.out.println(moreOrLess(-1));
        System.out.println(moreOrLess(1));
        System.out.println(moreOrLess(0));
    }
    private static boolean moreOrLess (int a) {
        return a>=0;
    }
}