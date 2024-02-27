public class Main {
    public static void main(String[] args) {
        final int CONSTNUM = 6; // Количество значений для проверки метода CreateAnimalServiceImpl.CreateAnimalServiceImpl(constNum)
        Animal[] animalArray;
        CreateAnimalsServiceImpl createAnimals = new CreateAnimalsServiceImpl();

        CreateAnimalsService.CreateAnimalService(); // Создаём 10 уникальных животных при помощи метода while.
        System.out.printf("%n%n");
        CreateAnimalsServiceImpl.CreateAnimalService(); // Создаём 10 уникальных животных при помощи метода do..while.
        System.out.printf("%n%n");
        animalArray = createAnimals.CreateAnimalServiceImpl(CONSTNUM); //метод, который создает N животных с помощью цикла for (где N - параметр, передаваемый в метод).


        System.out.printf("%n%nПроверяем последний массив животных:%n");
        System.out.println(animalArray != null ? PrintAnimals(animalArray) : "!!!Массив пустой!!!");
    }
    private static Object PrintAnimals(Animal[] animalArray) {
        for (Animal animal : animalArray) {
            if (animal != null) {
                System.out.printf("%s%nХарактеристики:%n   порода: %s%n   имя: %s%n   цена: %.2f%n   характер: %s%n%n",animal.about(),animal.getBreed(),animal.getName(),animal.getCost(),animal.getCharacter());
            }
        }
        return "Печать массива закончена!";
    }
}
