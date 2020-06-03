package ru.geekbrains.skopin.lesson7;

public class Main {
    public static void main(String[] args) {

/*
        один кот ест, много ест
*/
        System.out.println("Кормим голодного кота.");

        Cat cat = new Cat("Голодный", 5);
        Plate plate = new Plate(200);
        plate.setFoodInPlate(2000);
        for (int i = 0; i < 11; i++) {
            cat.eatFrom(plate);
            plate.info();
        }

/*
        много котов и все едят методом eatFrom
 */
        System.out.println("");
        System.out.println("Пришло множество котов.");

        Cat[] cats = makeArray(10);
        Plate plate1 = new Plate(50);
        plate1.setFoodInPlate(1000);
        plate1.info();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eatFrom(plate1);
        }
        for (int i = 0; i < cats.length; i++) {
            cats[i].getIsFullOfAnimal();
        }
        plate1.info();

/*
        много котов и все едят методом eatByUnitFrom, степень сытости в процентах
*/
        System.out.println("");
        System.out.println("Пришло множество котов.");

        Cat[] cats1 = makeArray(10);
        Plate plate2 = new Plate(50);
        plate2.setFoodInPlate(35);
        plate2.info();
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].eatByUnitFrom(plate2);
        }
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].getIsFullOfAnimalInPercent();
        }
        plate2.info();
        plate2.setFoodInPlate(25);
        plate2.info();
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].eatByUnitFrom(plate2);
        }
        for (int i = 0; i < cats1.length; i++) {
            cats1[i].getIsFullOfAnimalInPercent();
        }
        plate2.info();


/*
        группа котов ест
*/
        System.out.println("");
        System.out.println("Пришла организованная группа котов.");

        Plate plate3 = new PlateForMyCat();
        plate3.setFoodInPlate(60);
        plate3.info();
        GroupOfAnimals groupOfCats = new GroupOfAnimals(makeArray(10) );
        groupOfCats.groupEatFrom(plate3);
        plate3.info();
        System.out.println("Есть ли голодные коты в группе : " + groupOfCats.hasWhoNeedFood());
        groupOfCats.printCatInfo();

/*
        кот, собака и 2 тарелки
        кот есто из своей
        собака не ест из кошачьей
 */
        System.out.println("");
        System.out.println("Кот, собака и 2 тарелки.");

        Plate plateForAll = new Plate(100);
        plateForAll.setFoodInPlate(75);
        Plate plateForCat = new PlateForMyCat();
        plateForCat.setFoodInPlate(75);
        Dog dog = new Dog("Бобик", 45);
        Cat catX = MyCat.getMyCat();
        dog.eatFrom(plateForCat);
        plateForCat.info();
        catX.eatFrom(plateForAll);
        dog.eatFrom(plateForAll);
        plateForAll.info();
        catX.eatFrom(plateForCat);
        plateForCat.info();
    }

    public static Cat [] makeArray (int count) { // массив группа котов
        Cat [] cats = new Cat[count];
        for (int i = 0; i < count; i++) {
            String name = "Cat " + (i + 1);
            int appetite = (int) (Math.random() * 10) + 1;
            cats[i] = new Cat(name, appetite);
        }
        return cats;
    }
}
