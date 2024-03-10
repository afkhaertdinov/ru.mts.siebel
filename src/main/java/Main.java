import HomeWork.Service.*;
import HomeWork.DTO.Wolf;

import static HomeWork.Service.ConstsClass.CONSTNUM;

public class Main {
    public static void main(String[] args) {
        CreateAnimalsServiceImpl createAnimals = new CreateAnimalsServiceImpl();

        // Создаём 10 уникальных животных при помощи метода while.
        CreateAnimalsService.CreateAnimalService();
        System.out.println();

        // Создаём 10 уникальных животных при помощи метода do..while.
        CreateAnimalsService.CreateAnimalService();
        System.out.println();

        //метод, который создает N животных с помощью цикла for (где N - параметр, передаваемый в метод).
        createAnimals.createAnimalServiceImpl(CONSTNUM);

        //Проверяем работу исключения
        SearchServiceImpl searchService = new SearchServiceImpl();
        try {
            searchService.checkLeapYearAnimal(new Wolf("Вольф", 99.99, "Гадкий", null));
        } catch (InvalidAnimalBirthDateException e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой", e);
        }
    }
}
