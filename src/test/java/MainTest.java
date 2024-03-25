import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import HomeWork.DTO.*;
import HomeWork.Service.*;

class MainTest {
    @SuppressWarnings("ConstantValue")
    @Test
    @DisplayName("Проверяем срабатывание исключения InvalidAnimalException при вызове метода checkLeapYearAnimal() c animal = null")
    void testInvalidAnimalException() {
        Animal animal = null;
        InvalidAnimalException exception = assertThrows(InvalidAnimalException.class, () -> new SearchServiceImpl().checkLeapYearAnimal(animal));
        Assertions.assertEquals("на вход пришло некорректный объект животного " + LocalDate.now(), exception.getMessage());
    }

    @Test
    @DisplayName("Проверяем срабатывание исключения InvalidAnimalBirthDateException при вызове метода checkLeapYearAnimal c birthDate = null")
    void testInvalidAnimalBirthDateException() {
        Wolf animal = new Wolf("Вольф", 99.99, "Гадкий", null);
        InvalidAnimalBirthDateException exception = Assertions.assertThrows(InvalidAnimalBirthDateException.class,
                () -> new SearchServiceImpl().checkLeapYearAnimal(animal));
        Assertions.assertEquals("у животного " + animal + " не указана дата его рождения", exception.getMessage());
    }

    @Test
    @DisplayName("Проверяем срабатывание исключения InvalidAnimalException при вызове метода Main.testSearchService")
    void testSearchServiceInvalidAnimalException() {
        InvalidAnimalException exception = assertThrows(InvalidAnimalException.class, () -> Main.testSearchService("Вольф", 99.99, "Гадкий", null));
        Assertions.assertEquals("Работа метода завершилась ошибкой", exception.getMessage());
    }
}
