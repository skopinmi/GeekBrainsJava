
package ru.geekbrains.skopin.lesson1;

public class Exercise7 {

    public static void main(String[] args) {
        /* проверка : */
        String name = "Леша";
        hello(name);
        hello("Маша");
    }
    private static void hello (String a) {
        System.out.println("Привет, " + a + "!");
    }

}