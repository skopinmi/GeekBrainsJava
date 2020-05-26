package ru.geekbrains.skopin.lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> array = new ArrayList<>();

        for(int i = 0; i < 8; i++) {
            array.add(new Dog("Dog" + i));
        }

        for(int i = 0; i < 5; i++) {
            array.add(new Cat("Cat" + i));
        }

        for (Animal a : array) {
            System.out.println(a.name);
        }
        for (Animal a : array) {
            System.out.println(a.getClass().getSimpleName());
        }

        for(int i = 0; i < array.size(); i++) {
            array.get(i).run(i * 75);
            array.get(i).swim(i * 2);
        }

        System.out.println(Animal.animalCount);
        System.out.println(Cat.catCount);
        System.out.println(Dog.dogCount);
    }
}
