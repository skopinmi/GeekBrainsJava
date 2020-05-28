package ru.geekbrains.skopin.lesson6;

public class Cat extends Animal
{
    protected static int catCount;

    protected Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    protected void run(int runDistance) {
        if( runDistance > 200) {
            runDistance = 200;
            System.out.println( name + " пробежал(ла) только " + runDistance);
        }
        else {
        super.run(runDistance);
        }
    }

    @Override
    protected void swim(int swimDistance) {
        System.out.println(name + " плавать не умеет");
    }
}
