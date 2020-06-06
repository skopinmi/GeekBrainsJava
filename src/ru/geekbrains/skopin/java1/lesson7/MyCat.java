package ru.geekbrains.skopin.java1.lesson7;

public final class MyCat extends Cat {
    /*
          У меня только 1 кот
          с хорошим аппетитом
    * */

    private static MyCat myCat;
    private MyCat() {
        super("Матроскин", 65);
    }
    public static MyCat getMyCat () {
        if (myCat == null) {
            myCat = new MyCat();
        }
        return myCat;
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
