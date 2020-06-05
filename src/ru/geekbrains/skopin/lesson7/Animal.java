package ru.geekbrains.skopin.lesson7;

public class Animal {

    private final String name;
    private final int appetite;
    private boolean fullOfAnimal;
    private int countOfEaten; // для метода eatByUnitFrom

    public Animal (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullOfAnimal = false;
    }

    public void eatFrom (Plate plate) {
        int foodInPlate = plate.getFoodInPlate();
        if (!isFullOfAnimal())
        {
            if (foodInPlate >= appetite) {
                plate.decreaseFood(appetite);
                fullOfAnimal = true;
                System.out.println(name + " поел.");
            } else {
                System.out.println( name + " еды в этой тареклке мало.");
            }
        } else {
            System.out.println(name + " сытое животное.");
        }

    }

    public boolean isFullOfAnimal () {
        return fullOfAnimal;
    }

    public void getIsFullOfAnimal () {
        if (isFullOfAnimal()) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }

    /* метод питания по 1 единице пищи */

    public void eatByUnitFrom (Plate plate) {

        while (!isFullOfAnimal()) {
            if (!plate.isEmpty()) {
                plate.decreaseFood(1);
                countOfEaten++;
                if (appetite == countOfEaten) {
                    fullOfAnimal = true;
                    System.out.println(name + " теперь сытое животное.");
                }

            } else {
                System.out.println("Кот " + name + " поел, но не наелся.");
                break;
            }
        }
    }

    /* определение степени голода в процентах*/

    public void getIsFullOfAnimalInPercent () {
        if (isFullOfAnimal()) {
            System.out.println(name + " сыт.");
        } else {
            float percent = (1 - (float) countOfEaten / appetite) * 100;
            System.out.println( name + " голоден на " +  percent + " %." );
        }
    }

    /* сеттеры и геттеры для общения с GroupOfCat */

    public int getAppetite() {
        return appetite;
    }

    public int getCountOfEaten() {
        return countOfEaten;
    }

    public void setCountOfEaten(int countOfEaten) {
        this.countOfEaten += countOfEaten;
    }

    public void setFullOfCat (boolean bl) {
        this.fullOfAnimal = bl;
    }
}









