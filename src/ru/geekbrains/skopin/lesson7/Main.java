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

        /* много котов и все едят методом eatFrom */
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats[i] = new Cat("Котик № " + (i + 1), (int) (Math.random() * 10) + 1);
        }
        Plate plate1 = new Plate(50);
        plate1.setFoodInPlate(1000);
        plate1.info();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eatFrom(plate1);
        }
        for (int i = 0; i < cats.length; i++) {
            cats[i].getIsFullOfCat();
        }
        plate1.info();

        /* много котов и все едят методом eatByUnitFrom, степень сытости в процентах */
        Cat[] cats1 = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats1[i] = new Cat("Котик № " + (i + 1), (int) (Math.random() * 10) +1);
        }
        Plate plate2 = new Plate(50);
        plate2.setFoodInPlate(35);
        plate2.info();
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].eatByUnitFrom(plate2);
        }
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].getIsFullOfCatInPercent();
        }
        plate2.info();
        plate2.setFoodInPlate(25);
        plate2.info();
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].eatByUnitFrom(plate2);
        }
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].getIsFullOfCatInPercent();
        }
        plate2.info();

    }
}
