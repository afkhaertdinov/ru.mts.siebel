public abstract class Predator extends AbstractAnimal {
    protected String habitat; // Среда обитания

    public Predator(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    public Predator(String breed, String name, Double cost, String character, String habitat) {
        super(breed, name, cost, character);
        this.habitat = habitat;
    }

    @Override
    public void about() {
        System.out.println("Опасный хищник, среда обитания " + habitat + ".");
    }

    public String getHabitat() {
        return habitat;
    }
}
