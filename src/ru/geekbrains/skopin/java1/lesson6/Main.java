package ru.geekbrains.skopin.java1.lesson6;


public class Main {
/*
    для тестов
 */
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

//        for (Animal a : array) {
//            System.out.println(a.name);
//        }

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i].name);
            array[i].run((int) (Math.random() * 250));
            array[i].swim((int) (Math.random() * 15));
            array[i].jump((int) (Math.random() * 6));
        }
//        getInfo(array);

        System.out.println(Animal.animalCount);
        System.out.println(Dog.dogCount);
        System.out.println(Cat.catCount);

    }

    private static void getInfo (Animal[] array) {   // информация о животных в массиве

        for(int i = 0; i < array.length; i++) {
            System.out.println("name: " + array[i].name);
            System.out.println("limitRun: " + array[i].limitRun);
            System.out.println("limitSwim: " + array[i].limitSwim);
            System.out.println("limitJump: " + array[i].limitJump);
        }
    }
}
