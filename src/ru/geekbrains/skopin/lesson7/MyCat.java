package ru.geekbrains.skopin.lesson7;

public final class MyCat extends Cat {
    public MyCat() {
        super("Матроскин", 65);
    }

    @Override
    public void eatFrom(Plate plate) {
        if (plate instanceof PlateForMyCat) {
            super.eatFrom(plate);
        } else {
            System.out.println("Мой кот кушает только из своей миски.");
        }
    }
}
