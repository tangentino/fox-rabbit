package io.muic.ooc.fab;

public abstract class Herbivore extends Animal {

    // Split Animal into Carnivore and Herbivore
    // Only method shared by Herbivores is relocate()
    // Herbivores relocate randomly
    // No need to depend on food or hunger because they don't eat other animals, only breed

    @Override
    protected Location relocate() {
        return field.freeAdjacentLocation(getLocation());
    }

}
