package io.muic.ooc.fab;

public enum AnimalType {
    RABBIT(0.08), FOX(0.02);

    private double breedingProbability;

    AnimalType(double probability) {
        breedingProbability = probability;
    }

    public double getProbability() {
        return breedingProbability;
    }
}
