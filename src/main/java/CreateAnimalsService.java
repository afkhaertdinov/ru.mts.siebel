import java.text.DecimalFormat;
import java.util.Random;

public interface CreateAnimalsService {
    enum OfTheBreed {PORODISTAYA, BEZPORODNAYA};
    enum Names {ARTI, AMUR, AJRON, ALEKS, ALFA, AMADEJ, ATLAS, AMIGO, AGAT, ALBUS, AANG, ADAM, AVGUST, ANTEJ, ARES, ARAMIS, AKSEL, ASASIN, ANUBIS};
    enum Characters {SPOKOJNYJ, POKLADISTYJ, IGRIVYJ, NEPREDSKAZUEMYJ, AGRESSIVNYJ};
    static void CreateAnimalService(){ // Создаём 10 случайных питомцев
        Animal[] animalArrays = new Animal[10];
        int i = 0;
        Random Rnd = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double coast;
        while (i < 10) {
            switch (Rnd.nextInt(4)){
                case 0:
                    animalArrays[i] = new Wolf(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 100, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 1:
                    animalArrays[i] = new Shark(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 100, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 2:
                    animalArrays[i] = new Dog(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 100, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                case 3:
                    animalArrays[i] = new Cat(OfTheBreed.values()[Rnd.nextInt(2)].toString(),Names.values()[Rnd.nextInt(19)].toString(),Rnd.nextDouble() * 100, Characters.values()[Rnd.nextInt(5)].toString());
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return;
            }

            System.out.println(i);
            System.out.println(OfTheBreed.values()[Rnd.nextInt(2)]);
            System.out.println(Names.values()[Rnd.nextInt(19)]);
            coast = Rnd.nextDouble() * 100;
            System.out.printf("%.2f",coast);
            System.out.println();
            System.out.println(Characters.values()[Rnd.nextInt(5)]);
            System.out.println();
            i++;
        }
    }
    void CreateAnimalServiceImpl(int num);
}
