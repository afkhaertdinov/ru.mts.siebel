import HomeWork.DTO.Animal;
import HomeWork.Service.*;
import HomeWork.DTO.Wolf;

import java.util.Objects;

import static HomeWork.Service.ConstsClass.CONSTNUM;

public class Main {
    public static void main(String[] args) {
        CreateAnimalsServiceImpl createAnimals = new CreateAnimalsServiceImpl();

        // Создаём 10 уникальных животных при помощи метода while.
        printAnimal(Objects.requireNonNull(CreateAnimalsService.CreateAnimalService()));

        // Создаём 10 уникальных животных при помощи метода do..while.
        printAnimal(Objects.requireNonNull(CreateAnimalsService.CreateAnimalService()));

        //метод, который создает N животных с помощью цикла for (где N - параметр, передаваемый в метод).
        printAnimal(Objects.requireNonNull(createAnimals.createAnimalServiceImpl(CONSTNUM)));

        //Проверяем работу исключения
        //testSearchService();
    }

    // печатаем массив питомцев
    static void printAnimal(Animal[] animals) {
        int i = 1;
        for (Animal animal : animals) {
            if (animal != null) {
                System.out.printf("%02d. %s%n", i++, animal);
            }
        }
        System.out.println();
    }

    // Пробуем отправить на проверку animal c birthDate=null и ловим исключение согласно домашнего задания
    static void testSearchService() {
        SearchServiceImpl searchService = new SearchServiceImpl();
        try {
            searchService.checkLeapYearAnimal(new Wolf("Вольф", 99.99, "Гадкий", null));
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой", e);
        }
    }
}
