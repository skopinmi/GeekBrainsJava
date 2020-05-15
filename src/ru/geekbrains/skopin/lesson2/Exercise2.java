package ru.geekbrains.skopin.lesson2;

public class Exercise2 {
    public static void main(String[] args) {
        int [] array = new int [8];
        for (int i = 0; i < array.length; i++){
            array [i] = i * 3;
        }
    /*  test : */
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
