package ru.geekbrains.skopin.lesson6;

abstract class Animal {

    protected String name;

    protected static int animalCount;  // счет животных

    protected Animal(String name) {

        this.name = name;
        animalCount ++;
    }

    protected void run (int runDistance){
        System.out.println(name + " пробежал(ла) " + runDistance);
    }
    abstract void swim (int swimDistance);
}
