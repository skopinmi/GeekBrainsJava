package ru.geekbrains.skopin.lesson5;

abstract class Animal {

    String name;

    static int animalCount;  // счет животных

    public Animal(String name) {

        this.name = name;
        animalCount ++;
    }

    void run(int runDistance){
        System.out.println(name + " пробежал(ла) " + runDistance);
    }
    void swim(int swimDistance) {
        System.out.println(name + " проплыл(ла) " + swimDistance);
    }
}
