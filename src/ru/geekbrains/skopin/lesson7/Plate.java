package ru.geekbrains.skopin.lesson7;

public class Plate {

    private final int maxOfFood;
    private int food;


    public Plate( int maxOfFood) {
        food = 0;
        this.maxOfFood = maxOfFood;
    }

    public void setFoodInPlate (int food) {
        if (food <= maxOfFood) {
            this.food = food;
        } else {
            this.food = maxOfFood;
            System.out.println("В тарелку поместилось только: " + this.food);
        }
    }

    public void info () {
        System.out.println("Тарелка содержит : " +  food);
    }

    public void decreaseFood (int appetiteOfAnimal) {
        if (!isEmpty()) {
            food -= appetiteOfAnimal;
        }
    }

    public boolean isEmpty () {
        return food == 0;
    }

    public int getFoodInPlate (){
        return food;
    }
}
