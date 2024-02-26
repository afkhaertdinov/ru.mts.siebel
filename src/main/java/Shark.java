public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "морские водоёмы");
    }

    public Shark(String breed, String name, Double cost, String character, String habitat) {
        super(breed, name, cost, character, habitat);
    }

}
