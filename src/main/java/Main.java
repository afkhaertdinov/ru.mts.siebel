import HomeWork.DTO.Animal;
import HomeWork.Service.*;
import HomeWork.DTO.Wolf;

import java.time.LocalDate;
import java.util.*;

import static HomeWork.Service.ConstsClass.CONSTAGE;
import static HomeWork.Service.ConstsClass.CONSTNUM;

public class Main {
    public static void main(String[] args) {
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();
        HashMap<String, List<Animal>> animalHashMap;
        List<Animal> animalList = new ArrayList<>();

//TODO  1.  Создаём 10 уникальных животных при помощи метода while в CreateAnimalsService.CreateAnimalService().
        printAnimal(animalHashMap = CreateAnimalsService.CreateAnimalService());
        if (animalHashMap != null)
            for (Map.Entry<String, List<Animal>> entry: animalHashMap.entrySet())
                animalList.addAll(entry.getValue());
        else System.out.println("CreateAnimalsService.CreateAnimalService() вернул null");
        // Передаём созданный массив животных в AnimalRepositoryImpl.findLeapYearNames()
        // и получаем список животных родившихся в высокосный год
        System.out.println("Животные родившиеся в высокосный год:");
        System.out.println(animalRepository.findLeapYearNames(animalList));
        System.out.println();

//TODO  2.  Создаём 10 уникальных животных при помощи метода do..while в CreateAnimalsServiceImpl.CreateAnimalService().
        printAnimal(animalHashMap = CreateAnimalsServiceImpl.CreateAnimalService());
        animalList.clear();
        if (animalHashMap != null)
            for (Map.Entry<String, List<Animal>> entry: animalHashMap.entrySet())
                animalList.addAll(entry.getValue());
        else System.out.println("CreateAnimalsService.CreateAnimalService() вернул null");
        // Передаём созданный массив животных в AnimalRepositoryImpl.findOlderAnimal()
        // и получаем список животных, возраст которых старше CONSTAGE
        try {
            Map<Animal,Integer> animalMap = animalRepository.findOlderAnimal(animalList, CONSTAGE);
            if (animalMap.values().iterator().next() > CONSTAGE)
                System.out.println("Животные старше " + CONSTAGE + " лет:");
            else System.out.println("Животных старше " + CONSTAGE + " нет, самый взрослый из них:");
            for (Map.Entry<Animal,Integer> entry: animalMap.entrySet())
                System.out.println(entry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();

//TODO  3.  Создаём CONSTNUM уникальных животных с помощью цикла for в CreateAnimalsServiceImpl.createAnimalServiceImpl().
        printAnimal(animalHashMap = new CreateAnimalsServiceImpl().createAnimalServiceImpl(CONSTNUM));
        // Передаём созданный массив животных в AnimalRepositoryImpl.findDuplicate()
        // и получаем количество животных каждого типа
        if (animalHashMap != null)
            System.out.println(animalRepository.findDuplicate(animalHashMap));
    }



    //TODO печатаем массив питомцев
    static <T,K extends Animal> void printAnimal(HashMap<T, List<K>> hashMap) {
        int i = 1;
        if (hashMap != null)
            for (Map.Entry<T, List<K>> entry: hashMap.entrySet())
                for (K iterator: entry.getValue())
                    System.out.printf("%02d. %s%n", i++, iterator);
    }

    //TODO Пробуем отправить на проверку animal c birthDate=null и ловим в тесте исключение согласно домашнего задания
    @SuppressWarnings("SameParameterValue")
    static void testSearchService(String name, Double cost, String character, LocalDate birthDate) {
        try {
            new SearchServiceImpl().checkLeapYearAnimal(new Wolf(name, cost, character, birthDate));
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой", e);
        }
    }
}
