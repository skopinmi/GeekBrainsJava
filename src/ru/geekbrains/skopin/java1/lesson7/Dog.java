package ru.geekbrains.skopin.java1.lesson7;

public class Dog extends Animal {
    public Dog(String name, int appetite) {
        super(name, appetite);
    }

    @Override
    public void eatFrom(Plate plate) {
        if (plate instanceof PlateForMyCat) {
            System.out.println("Собака не хочет есть из кошачьей миски.");
        } else {
            super.eatFrom(plate);
        }
    }
}
