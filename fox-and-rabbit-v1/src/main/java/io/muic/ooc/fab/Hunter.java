package io.muic.ooc.fab;

public class Hunter extends Carnivore {
    @Override
    // Hunter is immortal
    protected void setDead() {};

    @Override
    protected AnimalType[] getFoodList() {
        // Hunter will kill every animal except for themselves
        AnimalType[] animalTypes = AnimalType.values();
        AnimalType[] ans = new AnimalType[animalTypes.length - 1];
        for (int i = 0; i < animalTypes.length; i++) {
            if (animalTypes[i] != AnimalType.HUNTER) {
                ans[i] = animalTypes[i];
            }
        }
        return ans;
    }

    @Override
    protected int getMaxAge() {
        return 300;
    }

    @Override
    protected double getBreedingProbability() {
        return AnimalType.HUNTER.getProbability();
    }

    @Override
    protected int getMaxLitterSize() {
        return 1;
    }

    @Override
    protected int getBreedingAge() {
        return 35;
    }
}
