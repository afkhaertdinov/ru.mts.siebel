//import DTO.Animal;
import Service.*;

import static Service.ConstsClass.CONSTNUM;

public class Main {
    public static void main(String[] args) {
//        Animal[] animalArray;
        CreateAnimalsServiceImpl createAnimals = new CreateAnimalsServiceImpl();

        // Создаём 10 уникальных животных при помощи метода while.
        CreateAnimalsService.CreateAnimalService();
//        System.out.println("Проверяем последний массив животных:");
//        System.out.printf(animalArray != null ? printAnimals(animalArray) : "!!!Массив пустой!!!%n");
        System.out.println();
        // Создаём 10 уникальных животных при помощи метода do..while.
        //noinspection AccessStaticViaInstance
        createAnimals.CreateAnimalService();
//        System.out.println("Проверяем последний массив животных:");
//        System.out.printf(animalArray != null ? printAnimals(animalArray) : "!!!Массив пустой!!!%n");
        System.out.println();
        //метод, который создает N животных с помощью цикла for (где N - параметр, передаваемый в метод).
        createAnimals.createAnimalServiceImpl(CONSTNUM);
//        System.out.println("Проверяем последний массив животных:");
//        System.out.printf(animalArray != null ? printAnimals(animalArray) : "!!!Массив пустой!!!%n");
    }

/*
    private static String printAnimals(Animal[] animalArray) {
        int i = 1;
        for (Animal animal : animalArray) {
            if (animal != null) {
                System.out.printf("%02d. %s%n",i++,animal.about());
                System.out.printf("    порода: %s; имя: %s; цена: $%.2f; характер: %s%n",animal.getBreed(),animal.getName(),animal.getCost(),animal.getCharacter());
            }
        }
        return "Печать массива закончена!%n%n";
    }
*/
}
