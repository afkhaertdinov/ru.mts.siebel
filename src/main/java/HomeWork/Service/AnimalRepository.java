package HomeWork.Service;

import HomeWork.DTO.Animal;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    /**
     * При помощи цикла (любой по желанию) найти всех животных, которые родились в високосный год.
     * @param animals На вход подается массив животных {@code List<Animal>}.
     * @return Метод должен возвращать {@code Map<String,LocalDate>}, которая содержит в качестве ключа тип
     * животного + имя,  а в значении дату рождения. Пример ключа: Cat Barsik, Dog Spot (русский язык
     * допускается в именах).
     */
    Map<String, LocalDate> findLeapYearNames(@NonNull List<Animal> animals);

    /**
     * При помощи цикла for найти всех животных, возраст которых старше N лет, где N аргумент метода.
     * <br/><i> - данный кейс необходимо покрыть кейсами в тестах.</i>
     * @param animals На вход подается массив животных {@code List<Animal>}.
     * @param age Возраст, животных старше которого необходимо вернуть.
     * @return Метод должен возвращать {@code Map<Animal,Integer>}, которая содержит в качестве ключа животное, а в качестве значения возраст.
     * Если при заданном значении поиска (передаваемый аргумент возраста) не было найдено ни одного животного, то вернуть нужно самого старшего из возможных.
     */
    Map<Animal, Integer> findOlderAnimal(@NonNull List<Animal> animals, int age) throws Exception;

    /**
     * Метод выводит на экран дубликаты животных.
     * @param animals На вход подается массив животных {@code Map<String,List<Animal>>}, который в качестве ключа содержит тип животного, а в значении список созданных животных.
     * @return Возвращает {@code Map<String,Integer>}, которая содержит в качестве ключа строку с типом животного, а в значении количество найденных дублей.
     * Пример данных: Cat=1, Dog=3. Значение Integer равно всем найденным дубликатам (пример: Собака[Шарик], Собака[Шарик], Собака[Дружок], Собака[Дружок] должен вернуть Собака=4).
     */
    Map<String, Integer> findDuplicate(@NonNull Map<String, List<Animal>> animals);
}
