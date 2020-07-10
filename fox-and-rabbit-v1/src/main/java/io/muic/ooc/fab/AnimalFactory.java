package io.muic.ooc.fab;

public class AnimalFactory {

    public static Animal createAnimal(AnimalType type, Field field, Location location) {
        switch (type) {
            case RABBIT:
                return new Rabbit(true, field, location);
            case FOX:
                return new Fox(true, field, location);
            default:
                throw new IllegalArgumentException("Unknown animal type");
        }
    }
}
