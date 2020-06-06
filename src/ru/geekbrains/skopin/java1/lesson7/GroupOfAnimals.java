package ru.geekbrains.skopin.java1.lesson7;

public class GroupOfAnimals {
/*

 */

    private final  Animal [] animalsArray;

    public GroupOfAnimals (Animal[] catsArray) {
        this.animalsArray = catsArray;
    }
    public void groupEatFrom (Plate plate) {
        while (!plate.isEmpty() && hasWhoNeedFood()) {
            for(int i = 0; i < animalsArray.length; i++) {
                int appetite = animalsArray[i].getAppetite();
                int countOfEaten = animalsArray[i].getCountOfEaten();
                if(appetite > countOfEaten){
                    plate.decreaseFood(1);
                    animalsArray[i].setCountOfEaten(1);
                } else {
                    animalsArray[i].setFullOfCat(true);
                }
            }
        }
    }

    public boolean hasWhoNeedFood () {
        for (Animal a : animalsArray) {
            if (!a.isFullOfAnimal()) {
                return true;
            }
        }
        return false;
    }

    public void printCatInfo () {
        for (Animal a : animalsArray) {
            a.getIsFullOfAnimalInPercent();
        }
    }

}
