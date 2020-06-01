package ru.geekbrains.skopin.lesson7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean fullOfCat;
    private int countOfEaten; // для метода eatByUnitFrom

    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullOfCat = false;
    }

    public void eatFrom (Plate plate) {
        int foodInPlate = plate.getFoodInPlate();
        if (!isFullOfCat())
        {
            if (foodInPlate >= appetite) {
                plate.decreaseFood(appetite);
                fullOfCat = true;
                System.out.println("Кот " + name + " поел.");
            } else {
                System.out.println("Коту " + name + " еды в этой тареклке мало.");
            }
        } else {
            System.out.println(name + " сытый кот.");
        }

    }

    public boolean isFullOfCat () {
        return fullOfCat;
    }

    public void getIsFullOfCat () {
        if (isFullOfCat()) {
            System.out.println("Кот " + name + " сыт.");
        } else {
            System.out.println("Кот " + name + " голоден.");
        }
    }

    /* метод питания по 1 единице пищи */

    public void eatByUnitFrom (Plate plate) {

        while (!isFullOfCat()) {
            if (!plate.isEmpty()) {
                plate.decreaseFood(1);
                countOfEaten++;
                if (appetite == countOfEaten) {
                    fullOfCat = true;
                    System.out.println(name + " теперь сытый кот.");
                }

            } else {
                System.out.println("Кот " + name + " поел, но не наелся.");
                break;
            }
        }
    }

    /* определение степени голода в процентах*/

    public void getIsFullOfCatInPercent () {
        if (isFullOfCat()) {
            System.out.println("Кот " + name + " сыт.");
        } else {
            float percent = (1 - (float) countOfEaten / appetite) * 100;
            System.out.println( "Кот " + name + " голоден на " +  percent + " %." );
        }
    }

}









