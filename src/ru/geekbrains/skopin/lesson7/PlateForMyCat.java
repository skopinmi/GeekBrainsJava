package ru.geekbrains.skopin.lesson7;

public final class PlateForMyCat extends Plate {
    private static PlateForMyCat plateForMyCat;
    private PlateForMyCat() {
        super(75);
    }

    public static PlateForMyCat getPlateForMyCat() {
        if (plateForMyCat==null) {
            plateForMyCat = new PlateForMyCat();}
            return plateForMyCat;
    }
}
