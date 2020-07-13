package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public abstract class Carnivore extends Animal {

    // Split Animal into Carnivore and Herbivore
    // Makes it easier to add more carnivores (tiger, hunter) and easier to add more herbivores
    // All carnivores share the same methods that aren't shared by herbivores
    // So only thing needed to do when making new carnivore animal are the stats like breeding, foodlist, etc.

    // PROPERTIES OF CARNIVORE:
    // All carnivores eat other animals
    // So all carnivore needs to have foodLevel and foodList
    // foodList -> list of animals it eats
    // All methods related to eating/hunger should belong to Carnivore since in this program, the Herbivores do not have to eat

    private int foodLevel;

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge,field,location);
        foodLevel = RANDOM.nextInt(AnimalType.RABBIT.getFoodValue());
    }

    @Override
    protected Location relocate() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }

    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        AnimalType[] foodList = getFoodList();

        while (it.hasNext()) {
            Location where = it.next();
            Animal animal = (Animal) field.getObjectAt(where);
            if (animal != null) {
                for (AnimalType prey : foodList) {
                    if ( (animal.getClass() == prey.getAnimalClass()) && animal.isAlive()) {
                        animal.setDead();
                        foodLevel = prey.getFoodValue();
                        return where;
                    }
                }
            }
        }
        return null;
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    @Override
    public void act(List<Animal> newAnimal) {
        incrementHunger();
        super.act(newAnimal);
    }

    protected abstract AnimalType[] getFoodList();

}
