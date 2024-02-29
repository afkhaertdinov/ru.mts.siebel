package DTO;

public class Cat extends Pet {
    public Cat(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "Кот умелый охотник на мышей.");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
