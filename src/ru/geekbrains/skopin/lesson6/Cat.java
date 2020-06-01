package ru.geekbrains.skopin.lesson6;

public class Cat extends Animal
{
    protected static int catCount; // счетчик кошек
/*
    разброс ограничений определяется случайно в конструкторе
 */
    protected Cat(String name) {
        super(name, (int) (Math.random() * 100) + 150, 0 , (float) (Math.random() * 3) + 3);
        catCount++;
    }

    @Override
    protected void run(int runDistance) {
        System.out.println("run: " + (runDistance <= this.limitRun));
    }

    @Override
    protected void swim(int swimDistance) {
        System.out.println("swim: " + false);
    }

    @Override
    protected void jump(float hightOfJump) {
        System.out.println("jump: " + (hightOfJump <= this.limitJump));
    }
}
