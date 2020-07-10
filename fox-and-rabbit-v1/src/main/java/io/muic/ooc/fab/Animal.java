package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal {

    protected static final Random RANDOM = new Random();

    private boolean alive = true;
    private Location location;
    protected Field field;
    private int age = 0;


    public Animal(boolean randomAge,Field field,Location location) {
        this.field = field;
        setLocation(location);
        if (randomAge) {
            age = RANDOM.nextInt(getMaxAge());
        }
    }

    public void act(List<Animal> newAnimals) {
        incrementAge();
        if (isAlive()) {
            giveBirth(newAnimals);
            // Try to move into a free location.
            Location newLocation = relocate();
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    protected abstract Animal breedOne(boolean randomAge, Field field, Location location);

    private void giveBirth(List<Animal> newAnimals) {
        // New rabbits are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = breedOne(false, field, loc);
            newAnimals.add(young);
        }
    }

    protected abstract Location relocate();

    public boolean isAlive() {
        return alive;
    }

    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    protected abstract int getMaxAge();

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    protected abstract double getBreedingProbability();

    protected abstract int getMaxLitterSize();

    protected abstract int getBreedingAge();

    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <=  getBreedingProbability()) {
            births = RANDOM.nextInt( getMaxLitterSize()) + 1;
        }
        return births;
    }

    private boolean canBreed() {
        return age >= getBreedingAge();
    }
}
