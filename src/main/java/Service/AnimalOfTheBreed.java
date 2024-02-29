package Service;

public enum AnimalOfTheBreed {
    PORODISTAYA("Породистая"),
    BEZPORODNAYA("Безпородная");
    private final String txt;
    AnimalOfTheBreed(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }

}
