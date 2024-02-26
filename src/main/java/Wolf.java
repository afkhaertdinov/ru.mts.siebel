public class Wolf extends Predator {

    public Wolf(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character, "лесные массивы");
    }


    public Wolf(String breed, String name, Double cost, String character, String habitat) {
        super(breed, name, cost, character, habitat);
    }

}
