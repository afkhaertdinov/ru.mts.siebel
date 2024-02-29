package DTO;

public abstract class Pet extends AbstractAnimal {
    protected String purpose; // Назначение питомца в истории людей

    public Pet(String breed, String name, Double cost, String character, String purpose) {
        super(breed, name, cost, character);
        this.purpose = purpose;
    }

    @Override
    public String about() {
        return "Домашний питомец. " + purpose;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
