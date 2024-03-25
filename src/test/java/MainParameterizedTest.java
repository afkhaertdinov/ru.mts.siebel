import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.MethodSource;

import static HomeWork.Service.ConstsClass.CONSTNUM;
import HomeWork.DTO.*;
import HomeWork.Service.*;

public class MainParameterizedTest {

    private static SearchServiceImpl searchService;

    @BeforeAll
    static void initBeforeAll(){
        searchService = new SearchServiceImpl();
    }

    @DisplayName("Проверяем работу checkLeapYearAnimal с высокосным годом через EnumSource")
    @ParameterizedTest
    @EnumSource(LeapYear.class)
    void testLeapYear(LeapYear year) {
        LocalDate localDate = LocalDate.of(year.getYear(), 1, 1);
        Animal animal = new Dog("Артур", 11.11, "Загадочный", localDate);
        try {
            Assertions.assertEquals(animal.getName() + " был рожден в високосный год", searchService.checkLeapYearAnimal(animal));
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Проверяем работу checkLeapYearAnimal с невысокосным годом")
    @ParameterizedTest
    @CsvSource({
            "Wolf,Ахмат,165.20,Агрессивный,2015-05-09",
            "Wolf,Артур,201.15,Непредсказуемый,2003-11-12"
    })
    void testNoLeapYear(String clas, String name, Double cost, String character, LocalDate birthDate) {
        Animal animal;
        try {
            animal = (Animal) Class.forName("HomeWork.DTO." + clas).getConstructor(String.class, Double.class, String.class, LocalDate.class).newInstance(name, cost, character, birthDate);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        try {
            Assertions.assertEquals(animal.getName() + " не был рожден в високосный год", searchService.checkLeapYearAnimal(animal));
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Проверяем работу checkLeapYearAnimal с рандомными значениями через MethodSource")
    @ParameterizedTest
    @MethodSource("createAnimal")
    public void parameterizedMethodSourceTest(Animal animal){
        System.out.println(animal);
        try {
            Assertions.assertEquals(animal.getName() + (animal.getBirthDate().isLeapYear()?"":" не") + " был рожден в високосный год",
                    searchService.checkLeapYearAnimal(animal));
        } catch (InvalidAnimalBirthDateException e) {
            throw new RuntimeException(e);
        }
    }
    public static Stream<Animal> createAnimal(){
        HashMap<String, List<Animal>> hashMapAnimals = new CreateAnimalsServiceImpl().createAnimalServiceImpl(CONSTNUM);
        ArrayList<Animal> animals = new ArrayList<>();
        for (Map.Entry<String, List<Animal>> entry: hashMapAnimals.entrySet()) animals.addAll(entry.getValue());
        return animals.stream();
    }
}
