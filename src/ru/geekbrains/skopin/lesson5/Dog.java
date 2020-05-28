package ru.geekbrains.skopin.lesson5;

public class Dog extends Animal {

    protected static int dogCount;

    protected Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    protected void run(int runDistance) {

        if( runDistance > 500) {
            runDistance = 500;
            System.out.println( name + " пробежал(ла) только " + runDistance);
        }
        else {
            super.run(runDistance);
        }
    }

    @Override
    protected void swim(int swimDistance) {
        if( swimDistance < 10) {
            System.out.println(name + " проплыл(ла) " + swimDistance);
        }
        else {
            System.out.println(name + " проплыл(ла) 10 и утонул(ла).");
        }
    }
}
