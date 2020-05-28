package ru.geekbrains.skopin.lesson6;


public class Main {

    public static void main(String[] args) {

        Animal[] array = new Animal[15];
        int countDog = 8;
        int countCat = array.length - countDog;

        for(int i = 0; i < countDog; i++) {
            array[i] = new Dog("Dog" + i);
        }

        for(int i = countDog; i < array.length; i++) {
            array[i] = new Cat("Cat" + i);
        }

        for (Animal a : array) {
            System.out.println(a.name);
        }

        for(int i = 0; i < array.length; i++) {
            array[i].run((int) (Math.random() * 250));
            array[i].swim((int) (Math.random() * 15));
        }

        System.out.println(Animal.animalCount);
        System.out.println(Dog.dogCount);
        System.out.println(Cat.catCount);

    }
}
