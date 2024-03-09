package Service;

import DTO.*;

import java.time.LocalDate;
import java.util.Random;

public class CreateAnimalsServiceImpl implements CreateAnimalsService {
    @Override
    public Animal[] createAnimalServiceImpl(int num) {
        System.out.println("Создаём " + num + " случайных питомцев через метод класса CreateAnimalServiceImpl(int num)");
        Animal[] animalArray = new Animal[num];
        Random randomNum = new Random();
        LocalDate localDate = CreateAnimalsService.randomDate();
        for (int i = 0; i < num; i++) {
            switch (randomNum.nextInt(4)){
                case 0:
                    animalArray[i] = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animalArray[i] = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animalArray[i] = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animalArray[i] = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }
            System.out.printf("%02d. %s%n",i+1,animalArray[i].toString());
        }
        return animalArray;
    }

    public static Animal[] CreateAnimalService(){
        System.out.println("Создаём 10 случайных питомцев через метод класса CreateAnimalService()");
        Animal[] animalArray = new Animal[10];
        int i = 0;
        Random randomNum = new Random();
        LocalDate localDate = CreateAnimalsService.randomDate();
        do {
            switch (randomNum.nextInt(4)){
                case 0:
                    animalArray[i] = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animalArray[i] = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animalArray[i] = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animalArray[i] = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }
            System.out.printf("%02d. %s%n",i+1,animalArray[i].toString());
            i++;
        } while (i < 10);
        return animalArray;
    }
}
