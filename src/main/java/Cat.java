public class Cat extends Pet{
    public Cat(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "Кот умелый охотник на мышей.");
    }

    public Cat(String breed, String name, Double cost, String character, String voice) {
        super(breed, name, cost, character, voice);
    }

}
