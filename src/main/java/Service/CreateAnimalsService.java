package Service;

import java.util.Random;
import DTO.*;



public interface CreateAnimalsService {


    public static Animal[] CreateAnimalService(){ // Создаём 10 случайных питомцев
        System.out.println("Создаём 10 случайных питомцев через метод интерфейса CreateAnimalService()");
        Animal[] animalArray = new Animal[10];
        int i = 0;
        Random randomNum = new Random();
        while (i < 10) {
//            AnimalOfTheBreed[] animalOfTheBreeds = AnimalOfTheBreed.values();
//            System.out.println(animalOfTheBreeds.toString());
            switch (randomNum.nextInt(4)){
                case 0:
                    animalArray[i] = new Wolf(AnimalOfTheBreed.values()[randomNum.nextInt(2)].toString(), AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString());
                    break;
                case 1:
                    animalArray[i] = new Shark(AnimalOfTheBreed.values()[randomNum.nextInt(2)].toString(), AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString());
                    break;
                case 2:
                    animalArray[i] = new Dog(AnimalOfTheBreed.values()[randomNum.nextInt(2)].toString(), AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString());
                    break;
                case 3:
                    animalArray[i] = new Cat(AnimalOfTheBreed.values()[randomNum.nextInt(2)].toString(), AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString());
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }

            System.out.printf("%02d. " + animalArray[i].toString() + "%n",i+1);
            i++;
        }
        return animalArray;
    }

    public Animal[] createAnimalServiceImpl(int num);

}
