package HomeWork.Service;

import HomeWork.DTO.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static HomeWork.Service.ConstsClass.*;

public interface CreateAnimalsService {

    @SuppressWarnings("UnusedReturnValue")
    static HashMap<String, List<Animal>> CreateAnimalService() { // Создаём 10 случайных питомцев
        System.out.println("Создаём 10 случайных питомцев через метод интерфейса CreateAnimalService()");
        HashMap<String, List<Animal>> hashMap = new HashMap<>();
        List<Animal> animalList;
        Animal animal;
        int i = 0;
        Random randomNum = new Random();
        while (i < 10) {
            LocalDate localDate = randomDate();
            switch (randomNum.nextInt(4)) {
                case 0:
                    animal = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animal = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animal = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animal = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
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
        }
        return hashMap;
    }

    @SuppressWarnings("UnusedReturnValue")
    HashMap<String, List<Animal>> createAnimalServiceImpl(int num);

    static LocalDate randomDate() {
        double dblRandom = new Random().nextDouble();
        return LocalDate.ofInstant(Instant.ofEpochSecond((long) (STARTDATE + (ENDDATE - STARTDATE) * dblRandom)), ZoneId.of("Europe/Moscow"));
    }

}
