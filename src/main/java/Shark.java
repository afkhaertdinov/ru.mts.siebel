public class Shark extends Predator {
    public Shark(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "акулы - морские водоёмы.");
    }

    public Shark(String breed, String name, Double cost, String character, String habitat) {
        super(breed, name, cost, character, habitat);
    }

}
