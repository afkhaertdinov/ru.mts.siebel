public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "Собака - отличный защитник дома.");
    }
    public Dog(String breed, String name, Double cost, String character, String voice) {
        super(breed, name, cost, character, voice);
    }

}
