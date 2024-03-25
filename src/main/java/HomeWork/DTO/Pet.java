package HomeWork.DTO;

import java.time.LocalDate;

public abstract class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character,LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

}
