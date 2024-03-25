package HomeWork.Service;

public enum AnimalCharacters {
    SPOKOJNYJ("Спокойный"),
    POKLADISTYJ("Покладистый"),
    AKTIVNYJ("Активный"),
    NEPREDSKAZUEMYJ("Непредсказуемый"),
    AGRESSIVNYJ("Агрессивный");
    private final String txt;
    AnimalCharacters(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }
}
