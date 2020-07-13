package io.muic.ooc.fab;

import sun.security.action.GetLongAction;

import java.util.List;
import java.util.Random;

public class Rabbit extends Herbivore {

    @Override
    protected int getMaxAge() {
        return 40;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.RABBIT.getProbability();
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
