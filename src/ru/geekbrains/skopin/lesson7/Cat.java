package ru.geekbrains.skopin.lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean fullOfCat;

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
            } else if (foodInPlate < appetite){
                System.out.println("Коту " + name + " еды в этой тареклке мало.");
            } else {
                System.out.println(name + " поел и сыт.");
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

}
