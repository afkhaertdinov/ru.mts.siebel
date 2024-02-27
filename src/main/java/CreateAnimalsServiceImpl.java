import java.util.Random;

public class CreateAnimalsServiceImpl implements CreateAnimalsService {
    @Override
    public Animal[] CreateAnimalServiceImpl(int num) {
        System.out.println("Создаём " + num + " случайных питомцев через метод класса CreateAnimalServiceImpl(int num)");
        Animal[] animalArray = new Animal[num];
        Random Rnd = new Random();
        for (int i = 0; i < num; i++) {
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
                    return null;
            }
            System.out.printf("%02d. " + animalArray[i].about() + "%n",i+1);
            System.out.printf("    порода: %s; имя: %s; цена: $%.2f; характер: %s%n",animalArray[i].getBreed(),animalArray[i].getName(),animalArray[i].getCost(),animalArray[i].getCharacter());
        }
        return animalArray;
    }

    static void CreateAnimalService(){
        System.out.println("Создаём 10 случайных питомцев через метод класса CreateAnimalService()");
        Animal[] animalArray = new Animal[10];
        int i = 0;
        Random Rnd = new Random();
        do {
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
        } while (i < 10);
    }
}
