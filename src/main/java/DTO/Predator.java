package DTO;

import java.time.LocalDate;

public abstract class Predator extends AbstractAnimal {
//    protected String habitat; // Среда обитания

    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed + "/хищник", name, cost, character, birthDate);
//        this.habitat = habitat;
    }

    @Override
    public String about() {
        return "Опасный хищник, среда обитания "; // + habitat;
    }

}
