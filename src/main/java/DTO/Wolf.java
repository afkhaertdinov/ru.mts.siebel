package DTO;

import java.time.LocalDate;

public class Wolf extends Predator {

    public Wolf(String name, Double cost, String character, LocalDate birthDate) {
        super("волк", name, cost, character, birthDate);
    }

}
