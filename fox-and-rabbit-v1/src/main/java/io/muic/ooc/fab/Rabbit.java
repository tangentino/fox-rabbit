package io.muic.ooc.fab;

import sun.security.action.GetLongAction;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {
    // Characteristics shared by all rabbits (class variables).

    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;

    @Override
    protected Location relocate() {
        return field.freeAdjacentLocation(getLocation());
    }

    @Override
    protected int getMaxAge() {
        return 40;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }
}
