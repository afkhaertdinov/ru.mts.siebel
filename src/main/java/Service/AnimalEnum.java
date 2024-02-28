package Service;

enum AnimalOfTheBreed {
    PORODISTAYA("Породистая"),
    BEZPORODNAYA("Безпородная");
    private String txt;
    AnimalOfTheBreed(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }
}

//enum AnimalOfTheBreed {PORODISTAYA, BEZPORODNAYA} //Порода: Породистая, Безпородная

enum AnimalNames { //Клички/имена животных
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
    private String txt;
    AnimalNames(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }
}

enum AnimalCharacters { // Характер животных: Спокойный, Покладистый, игривый, Непредсказуемый, Агрессивный
    SPOKOJNYJ("Спокойный"),
    POKLADISTYJ("Покладистый"),
    AKTIVNYJ("Активный"),
    NEPREDSKAZUEMYJ("Непредсказуемый"),
    AGRESSIVNYJ("Агрессивный");
    private String txt;
    AnimalCharacters(String txt) { this.txt = txt; }
    @Override
    public String toString() { return txt; }
}
