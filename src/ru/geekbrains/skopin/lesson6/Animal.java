package ru.geekbrains.skopin.lesson6;

abstract class Animal {

    protected String name; // в условиях задач имени нет, добавил для отличия разных котов и собак
    protected int limitRun;
    protected int limitSwim;
    protected float limitJump;

    protected static int animalCount;  // счет животных

    protected Animal(String name, int limitRun, int limitSwim, float limitJump) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
        animalCount ++;
    }

    protected abstract void run (int runDistance);
    protected abstract void swim (int swimDistance);
    protected abstract void jump (float hightOfJump);
}
