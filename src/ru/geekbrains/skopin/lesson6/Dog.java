package ru.geekbrains.skopin.lesson6;

public class Dog extends Animal {

    protected static int dogCount; // счетчик собак
/*
    разброс ограничений определяется случайно в конструкторе
*/
    protected Dog(String name) {
        super(name, (int)(Math.random() * 200) + 400, (int)(Math.random() * 4) + 6, (float) (Math.random() + 0.20));
        dogCount++;
    }

    @Override
    protected void run(int runDistance) {
        System.out.println("run: " + (runDistance <= this.limitRun));
    }

    @Override
    protected void swim(int swimDistance) {
        System.out.println("swim: " + (swimDistance <= this.limitSwim));
    }

    @Override
    protected void jump(float hightOfJump) {
        System.out.println("jump: " + (hightOfJump <= this.limitJump));
    }
}
