package HomeWork.Service;

import HomeWork.DTO.Animal;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalRepositoryImpl implements AnimalRepository {
    /**
     * При помощи цикла (любой по желанию) найти всех животных, которые родились в високосный год.
     * @param animals На вход подается массив животных {@code List<Animal>}.
     * @return Метод должен возвращать {@code Map<String,LocalDate>}, которая содержит в качестве ключа тип
     * животного + имя,  а в значении дату рождения. Пример ключа: Cat Barsik, Dog Spot (русский язык
     * допускается в именах).
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames(@NonNull List<Animal> animals) {
        Map<String,LocalDate> animalMap = new HashMap<>();
        for (Animal animal: animals){
            if (animal.getBirthDate().isLeapYear())
                animalMap.put(animal.getBreed() + " " + animal.getName(),animal.getBirthDate());
        }
        return animalMap;
    }

    /**
     * При помощи цикла for найти всех животных, возраст которых старше N лет, где N аргумент метода.
     * <br/><i> - данный кейс необходимо покрыть кейсами в тестах.</i>
     * @param animals На вход подается массив животных {@code List<Animal>}.
     * @param age Возраст, животных старше которого необходимо вернуть.
     * @return Метод должен возвращать {@code Map<Animal,Integer>}, которая содержит в качестве ключа животное, а в качестве значения возраст.
     * Если при заданном значении поиска (передаваемый аргумент возраста) не было найдено ни одного животного, то вернуть нужно самого старшего из возможных.
     */
    @Override
    public Map<Animal, Integer> findOlderAnimal(@NonNull List<Animal> animals, int age) throws Exception {
        if (animals.isEmpty())
            throw new EmptyParameterException();
        Map<Animal,Integer> animalMap = new HashMap<>();
        Animal animalMaxAge = animals.get(0);
        int countAge, maxAge = 0;
        for (Animal animal: animals){
            if ((animal.getBirthDate() != null)) {
                countAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
                if (countAge > age)
                    animalMap.put(animal, countAge);
                else if (maxAge < countAge) {
                    maxAge = countAge;
                    animalMaxAge = animal;
                }
            } else throw new Exception(new InvalidAnimalBirthDateException("у животного " + animal + " не указана дата его рождения"));
        }
        if (animalMap.isEmpty())
            animalMap.put(animalMaxAge,maxAge);
        return animalMap;
    }

    /**
     * Метод выводит на экран дубликаты животных.
     * @param animalHashMap На вход подается массив животных {@code Map<String,List<Animal>>}, который в качестве ключа содержит тип животного, а в значении список созданных животных.
     * @return Возвращает {@code Map<String,Integer>}, которая содержит в качестве ключа строку с типом животного, а в значении количество найденных дублей.
     * Пример данных: Cat=1, Dog=3. Значение Integer равно всем найденным дубликатам (пример: Собака[Шарик], Собака[Шарик], Собака[Дружок], Собака[Дружок] должен вернуть Собака=4).
     */
    @Override
    public Map<String, Integer> findDuplicate(@NonNull Map<String, List<Animal>> animalHashMap) {
        Map<String,Integer> animalMap = new HashMap<>();
        for (Map.Entry<String, List<Animal>> entry: animalHashMap.entrySet()){
            animalMap.put(entry.getKey(),entry.getValue().size());
        }
        return animalMap;
    }
}
