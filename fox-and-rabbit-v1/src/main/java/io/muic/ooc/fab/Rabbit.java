package io.muic.ooc.fab;

import sun.security.action.GetLongAction;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {

    @Override
    protected AnimalType[] getFoodList() { return null; }

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
