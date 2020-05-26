package ru.geekbrains.skopin.lesson5;

public class Cat extends Animal
{
    static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    void run(int runDistance) {
        if( runDistance > 200) {
            runDistance = 200;
        }
        super.run(runDistance);
    }

    @Override
    void swim(int swimDistance) {
        System.out.println(name + " плавать не умеет");
    }
}
