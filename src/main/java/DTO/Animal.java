package DTO;

import java.time.LocalDate;

public interface Animal {
    String getBreed();
    String getName();
    Double getCost();
    String getCharacter();
    LocalDate getBirthDate();
    String about(); // Коротко о животном

}
