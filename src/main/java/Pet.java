public abstract class Pet extends AbstractAnimal {
    protected String purpose; // Назначение питомца в истории людей

    public Pet(String breed, String name, Double cost, String character) {
        super(breed, name, cost, character);
    }

    public Pet(String breed, String name, Double cost, String character, String purpose) {
        super(breed, name, cost, character);
        this.purpose = purpose;
    }

    @Override
    public String about() {
        return "Домашний питомец. " + purpose.toString();
    }

    public String getPurpose() {
        return purpose;
    }

}
