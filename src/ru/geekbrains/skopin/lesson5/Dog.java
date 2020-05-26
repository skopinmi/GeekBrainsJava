package ru.geekbrains.skopin.lesson5;

public class Dog extends Animal {
    static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    void run(int runDistance) {
        if( runDistance > 500) {
            runDistance = 500;
        }
        super.run(runDistance);
    }

    @Override
    void swim(int swimDistance) {
        if( swimDistance > 10) {
            swimDistance = 10;
        }
        super.swim(swimDistance);
    }
}
