package DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractAnimal implements Animal {
    protected String breed; // порода
    protected String name; // имя
    protected Double cost; // цена в магазине
    protected String character; // характер
    protected LocalDate birthDate; // День рождения животного в формате dd-MM-yyyy

    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public abstract String about(); // Коротко о животном
    @Override
    public String getBreed() {
        return breed;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Double getCost() {
        return cost;
    }
    @Override
    public String getCharacter() {
        return character;
    }
    @Override
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " {breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost= $" + String.format("%.2f",cost) + '\'' +
                ", character='" + character + '\'' +
                ", birthDate='" + birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                '}';
    }
}
