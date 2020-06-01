package ru.geekbrains.skopin.lesson7;

public class Main {
    public static void main(String[] args) {
/* один кот ест, много ест */
        Cat cat = new Cat("Голодный", 2);
        Plate plate = new Plate(20);
        plate.setFoodInPlate(2000);
        for (int i = 0; i < 11; i++) {
            cat.eatFrom(plate);
            plate.info();
        }

/* много котов и все едят */
        Cat [] cats = new Cat[10];
        for (int i = 0; i < 10 ; i++) {
            cats[i] = new Cat("Котик № " + (i +1), (int) (Math.random() * 10));
        }
        Plate plate1 = new Plate (50);
        plate1.setFoodInPlate(1000);
        plate1.info();
        for (int i = 0; i < cats.length; i ++) {
            cats[i].eatFrom(plate1);
        }
        for (int i = 0; i < cats.length; i ++) {
            cats[i].getIsFullOfCat();
        }
        plate1.info();
    }
}
