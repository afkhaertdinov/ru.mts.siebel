package Service;

import DTO.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import static Service.ConstsClass.*;

public interface CreateAnimalsService {

     static Animal[] CreateAnimalService(){ // Создаём 10 случайных питомцев
        System.out.println("Создаём 10 случайных питомцев через метод интерфейса CreateAnimalService()");
        Animal[] animalArray = new Animal[10];
        SearchServiceImpl searchService = new SearchServiceImpl();
        int i = 0;
        Random randomNum = new Random();
        while (i < 10) {
            LocalDate localDate = randomDate();
            switch (randomNum.nextInt(4)){
                case 0:
                    animalArray[i] = new Wolf(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 1:
                    animalArray[i] = new Shark(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 2:
                    animalArray[i] = new Dog(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                case 3:
                    animalArray[i] = new Cat(AnimalNames.values()[randomNum.nextInt(19)].toString(), randomNum.nextDouble() * 1000, AnimalCharacters.values()[randomNum.nextInt(5)].toString(), localDate);
                    break;
                default:
                    System.out.println("Что-то пошло не так");
                    return null;
            }
            System.out.printf("%02d. %s%n    ",i+1,animalArray[i].toString());
            searchService.checkLeapYearAnimal(animalArray[i]);
            i++;
        }
        return animalArray;
    }

     Animal[] createAnimalServiceImpl(int num);

     static LocalDate randomDate(){
         double dblRandom = new Random().nextDouble();
         return LocalDate.ofInstant(Instant.ofEpochSecond((long) (STARTDATE + (ENDDATE - STARTDATE) * dblRandom)), ZoneId.of("Europe/Moscow"));
     }

}
