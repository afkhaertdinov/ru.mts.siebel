package DTO;

public class Wolf extends Predator {

    public Wolf(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "волка - лесные массивы.");
    }

    @Override
    public String toString() {
        return "Wolf{" +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
