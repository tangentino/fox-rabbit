package io.muic.ooc.fab;

import java.util.List;
import java.util.Iterator;
import java.util.Random;

public class Fox extends Carnivore {

    @Override
    protected int getMaxAge() {
        return 150;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.FOX.getProbability();
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    protected int getBreedingAge() {
        return 15;
    }

    @Override
    protected AnimalType[] getFoodList() {
        return new AnimalType[]{AnimalType.RABBIT};
    }

}
