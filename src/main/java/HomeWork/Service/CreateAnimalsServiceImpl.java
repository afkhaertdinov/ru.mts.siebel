package HomeWork.Service;

import HomeWork.DTO.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CreateAnimalsServiceImpl implements CreateAnimalsService {
    @Override
    public HashMap<String, List<Animal>> createAnimalServiceImpl(int num) {
        System.out.println("Создаём " + num + " случайных питомцев через метод класса CreateAnimalServiceImpl(int num)");
        HashMap<String, List<Animal>> hashMap = new HashMap<>();
        List<Animal> animalList;
        Animal animal;
        Random randomNum = new Random();
        for (int i = 0; i < num; i++) {
            LocalDate localDate = CreateAnimalsService.randomDate();
            switch (randomNum.nextInt(4)){
                case 0:
                    animal = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animal = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animal = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animal = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }
            animalList = hashMap.get(animal.getBreed());
            if (animalList == null) animalList = new ArrayList<>();
            animalList.add(animal);
            hashMap.put(animal.getBreed(), animalList);
        }
        return hashMap;
    }

    @SuppressWarnings("unused")
    public static HashMap<String, List<Animal>> CreateAnimalService(){
        System.out.println("Создаём 10 случайных питомцев через перегруженный метод класса CreateAnimalService()");
        HashMap<String, List<Animal>> hashMap = new HashMap<>();
        List<Animal> animalList;
        Animal animal;
        int i = 0;
        Random randomNum = new Random();
        do {
            LocalDate localDate = CreateAnimalsService.randomDate();
            switch (randomNum.nextInt(4)){
                case 0:
                    animal = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animal = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animal = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animal = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(),randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }
            animalList = hashMap.get(animal.getBreed());
            if (animalList == null) animalList = new ArrayList<>();
            animalList.add(animal);
            hashMap.put(animal.getBreed(), animalList);
            i++;
        } while (i < 10);
        return hashMap;
    }
}
