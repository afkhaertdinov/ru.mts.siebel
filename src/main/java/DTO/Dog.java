package DTO;

public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "Собака - отличный защитник дома.");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
