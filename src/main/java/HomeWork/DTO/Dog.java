package HomeWork.DTO;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, Double cost, String character, LocalDate birthDate) {
        super("собака", name, cost, character, birthDate);
    }

}
