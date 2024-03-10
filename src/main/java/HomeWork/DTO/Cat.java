package HomeWork.DTO;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, Double cost, String character, LocalDate birthDate) {
        super("кот", name, cost, character, birthDate);
    }

}
