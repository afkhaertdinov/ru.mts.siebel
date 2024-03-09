package DTO;

import java.time.LocalDate;

public abstract class Pet extends AbstractAnimal {
    protected String purpose; // Назначение питомца в истории людей

    public Pet(String breed, String name, Double cost, String character,LocalDate birthDate) {
        super(breed + "/питомец", name, cost, character, birthDate);
//        this.purpose = purpose;
    }

    @Override
    public String about() {
        return "Домашний питомец. " ;
    }

}
