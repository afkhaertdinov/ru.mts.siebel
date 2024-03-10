package HomeWork.Service;

public enum AnimalNames {
    ARTI("Арти"),
    AMUR("Амур"),
    AJRON("Айрон"),
    ALEKS("Алекс"),
    ALFA("Альфа"),
    AMADEJ("Амадей"),
    ATLAS("Атлас"),
    AMIGO("Амиго"),
    AGAT("Агат"),
    ALBUS("Альбус"),
    AHMAT("Ахмат"),
    ADAM("Адам"),
    AVGUST("Август"),
    ANTEJ("Антей"),
    ARES("Арес"),
    ARAMIS("Арамис"),
    AKSEL("Аксель"),
    ASASIN("Асасин"),
    ANUBIS("Анубис");
    private final String txt;
    AnimalNames(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }
}
