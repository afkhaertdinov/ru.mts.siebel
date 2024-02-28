package DTO;

import DTO.AbstractAnimal;

public abstract class Predator extends AbstractAnimal {
    protected String habitat; // Среда обитания

    public Predator(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    public Predator(String breed, String name, Double cost, String character, String habitat) {
        super(breed, name, cost, character);
        this.habitat = habitat;
    }

    @Override
    public String about() {
        return "Опасный хищник, среда обитания " + habitat.toString();
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
