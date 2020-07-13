package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Tiger extends Carnivore {

    @Override
    protected int getMaxAge() {
        return 200;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.TIGER.getProbability();
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 30;
    }

    @Override
    protected AnimalType[] getFoodList() {
        return new AnimalType[]{AnimalType.RABBIT,AnimalType.FOX};
    }

}
