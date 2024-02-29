package DTO;

public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "акулы - морские водоёмы.");
    }

    @Override
    public String toString() {
        return "Shark{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
