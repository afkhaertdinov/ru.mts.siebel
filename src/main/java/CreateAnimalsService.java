import java.text.DecimalFormat;
import java.util.Random;

public interface CreateAnimalsService {
    enum OfTheBreed {PORODISTAYA, BEZPORODNAYA} //Порода: Породистая, Безпородная
    enum Names { //Клички/имена животных
        ARTI, AMUR, AJRON, ALEKS, ALFA, AMADEJ, ATLAS, AMIGO, AGAT, ALBUS, AANG, ADAM, AVGUST, ANTEJ, ARES, ARAMIS, AKSEL, ASASIN, ANUBIS}
    enum Characters { // Характер животных: Спокойный, Покладистый, игривый, Непредсказуемый, Агрессивный
        SPOKOJNYJ, POKLADISTYJ, IGRIVYJ, NEPREDSKAZUEMYJ, AGRESSIVNYJ}

    static void CreateAnimalService(){ // Создаём 10 случайных питомцев
        System.out.println("Создаём 10 случайных питомцев через метод интерфейса CreateAnimalService()");
        Animal[] animalArray = new Animal[10];
        int i = 0;
        Random Rnd = new Random();
        //DecimalFormat decimalFormat = new DecimalFormat("#.##");
        while (i < 10) {
            switch (Rnd.nextInt(4)){
                case 0:
                    animalArray[i] = new Wolf(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 1000, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 1:
                    animalArray[i] = new Shark(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 1000, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 2:
                    animalArray[i] = new Dog(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 1000, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 3:
                    animalArray[i] = new Cat(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 1000, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return;
            }

            System.out.printf("%02d. " + animalArray[i].about() + "%n",i+1);
            System.out.printf("    порода: %s; имя: %s; цена: $%.2f; характер: %s%n",animalArray[i].getBreed(),animalArray[i].getName(),animalArray[i].getCost(),animalArray[i].getCharacter());
            i++;
        }
    }

    Animal[] CreateAnimalServiceImpl(int num);

}
