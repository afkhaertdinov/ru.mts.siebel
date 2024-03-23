import HomeWork.DTO.*;
import HomeWork.Service.AnimalRepositoryImpl;
import HomeWork.Service.EmptyParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.*;


class AnimalRepositoryImplTest {
    private static AnimalRepositoryImpl animalRepository;
    private static final List<Animal> animalList = new ArrayList<>();

    @BeforeAll
    static void initBeforeAll() {
        animalRepository = new AnimalRepositoryImpl();
        animalList.add(new Wolf("Асасин", 924.62, "Агрессивный", LocalDate.parse("2012-11-14")));
        animalList.add(new Dog("Амур", 792.53, "Активный", LocalDate.parse("2003-03-18")));
        animalList.add(new Cat("Аксель", 197.36, "Спокойный", LocalDate.parse("2016-06-20")));
        animalList.add(new Dog("Арти", 230.13, "Непредсказуемый", LocalDate.parse("2018-04-19")));
        animalList.add(new Shark("Анубис", 224.32, "Активный", LocalDate.parse("2002-03-02")));
        animalList.add(new Wolf("Айрон", 527.23, "Непредсказуемый", LocalDate.parse("2013-05-16")));

    }

    /**
     * <h3>Тест метода AnimalRepositoryImpl.findLeapYearNames </h3>
     * Тест 1. Проверяем успешность отработки успешных данных, проверяем, что на выходе все животные рождёные в высокосный год.<br>
     * Тест 2. Проверяем, что метод вернёт пустую коллекцию, когда нет верных значений.<br>
     * Тест 3. Проверяем, что передаваемый параметр может быть пустым, но не может быть Null.<br>
     */
    @Test
    void findLeapYearNames() {
        Map.Entry<String, LocalDate> etalonEntry, testEntry;
        Iterator<Map.Entry<String, LocalDate>> testIterator, etalonIterator;
        Map<String, LocalDate> etalonMap, testMap;

        //TODO Тест-1. Проверяем, что метод вернул только животных, которые родились в высокосный год.
        {
            //создаём шаблон с верными значениями
            etalonMap = new HashMap<>();
            etalonMap.put("Волк Асасин", LocalDate.parse("2012-11-14"));
            etalonMap.put("Кот Аксель", LocalDate.parse("2016-06-20"));

            //вызываем AnimalRepositoryImpl.findLeapYearNames() и получаем в testMap данные для теста
            testMap = animalRepository.findLeapYearNames(animalList);

            testIterator = testMap.entrySet().iterator();
            etalonIterator = etalonMap.entrySet().iterator();
            while (testIterator.hasNext() && etalonIterator.hasNext()) {
                etalonEntry = etalonIterator.next();
                testEntry = testIterator.next();
                Assertions.assertEquals(etalonEntry.getKey(), testEntry.getKey());
                Assertions.assertEquals(etalonEntry.getValue(), testEntry.getValue());
            }
        }
        //TODO Тест-2. Проверяем, что метод вернёт пустую коллекцию, когда нет верных значений.
        {
            //Удаляем из тестовых данных правильные записи с высокосным годом
            if (2 <= animalList.size()) {
                animalList.remove(2);
                animalList.remove(0);
            }

            //вызываем AnimalRepositoryImpl.findLeapYearNames() и получаем в testMap данные для теста
            testMap = animalRepository.findLeapYearNames(animalList);
            Assertions.assertTrue(testMap.isEmpty());
        }

        //TODO Тест-3. Передаваемый параметр может быть пустым, но не может быть Null.
        {
            animalList.clear();
            Assertions.assertTrue(animalRepository.findLeapYearNames(animalList).isEmpty());
            try {
                //noinspection DataFlowIssue
                Assertions.assertThrows(NullPointerException.class, () -> animalRepository.findLeapYearNames(null));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


        /**
         * <h3>Тест метода AnimalRepositoryImpl.findOlderAnimal </h3>
         * Тест 1. Проверяем успешность отработки успешных данных, когда есть животные старше указанного возраста.<br>
         * Тест 2. Проверяем успешность отработки неуспешных данных, когда нет животных старше указанного возраста.<br>
         * Тест 3. Проверяем передачу Null в параметре или пустого списка животных.<br>
         * <li> нет смысла проверять значение возраста на выход за пределы, при переданном отрицательном параметре выведутся все животные, т.к. будут старше указанного возраста.</li>
         */
        @Test
        void findOlderAnimal() {
            Map.Entry<Animal, Integer> etalonEntry, testEntry;
            Map<Animal, Integer> etalonMap, testMap;
            Iterator<Map.Entry<Animal, Integer>> testIterator, etalonIterator;

            //TODO Тест-1. Проверяем, что два животных старше 20 лет.
            {
                //создаём шаблон с верными значениями
                etalonMap = new HashMap<>();
                etalonMap.put(new Dog("Амур", 792.53, "Активный", LocalDate.parse("2003-03-18")), 21);
                etalonMap.put(new Shark("Анубис", 224.32, "Активный", LocalDate.parse("2002-03-02")), 22);
                //вызываем AnimalRepositoryImpl.findOlderAnimal() и получаем в testMap данные для теста
                try {
                    testMap = animalRepository.findOlderAnimal(animalList, 20);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //проверяем на идеинтичность эталонную коллекцию etalonMap и тестовую коллекцию testMap
                testIterator = testMap.entrySet().iterator();
                etalonIterator = etalonMap.entrySet().iterator();
                while (testIterator.hasNext() && etalonIterator.hasNext()) {
                    etalonEntry = etalonIterator.next();
                    testEntry = testIterator.next();
                    Assertions.assertEquals(etalonEntry.getKey(), testEntry.getKey());
                    Assertions.assertEquals(etalonEntry.getValue(), testEntry.getValue());
                }
                //проверяем, что ни в одном итераторе не осталось данных после проверки
                //noinspection ConstantValue
                Assertions.assertFalse(etalonIterator.hasNext() && testIterator.hasNext());
            }

            //TODO Тест-2. Проверяем, что нет животных старше 25 лет, и должны получить самое старшее животное.
            {
                //создаём шаблон с верными значениями
                etalonMap = new HashMap<>();
                etalonMap.put(new Shark("Анубис", 224.32, "Активный", LocalDate.parse("2002-03-02")), 22);
                //вызываем AnimalRepositoryImpl.findOlderAnimal() и получаем в testMap данные для теста
                try {
                    testMap = animalRepository.findOlderAnimal(animalList, 25);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //проверяем на идеинтичность эталонную коллекцию etalonMap и тестовую коллекцию testMap
                testIterator = testMap.entrySet().iterator();
                etalonIterator = etalonMap.entrySet().iterator();
                while (testIterator.hasNext() && etalonIterator.hasNext()) {
                    etalonEntry = etalonIterator.next();
                    testEntry = testIterator.next();
                    Assertions.assertEquals(etalonEntry.getKey(), testEntry.getKey());
                    Assertions.assertEquals(etalonEntry.getValue(), testEntry.getValue());
                }
                //проверяем, что ни в одном итераторе не осталось данных после проверки
                //noinspection ConstantValue
                Assertions.assertFalse(etalonIterator.hasNext() && testIterator.hasNext());
            }

            //TODO Тест-3. Передаваемый параметр не может быть пустым или Null.
            {
                try {
                    animalList.clear();
                    Assertions.assertThrows(EmptyParameterException.class, () -> animalRepository.findOlderAnimal(animalList, 25));
                    //noinspection DataFlowIssue
                    Assertions.assertThrows(NullPointerException.class, () -> animalRepository.findOlderAnimal(null, 25));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    /**
     * <h3>Тест метода AnimalRepositoryImpl.findDuplicate </h3>
     * Тест 1. Проверяем успешность отработки успешных данных.<br>
     * Тест 2. Проверяем, что передаваемый параметр может быть пустым, но не может быть Null.<br>
     */
    @Test
    void findDuplicate() {
        Map.Entry<String,Integer> etalonEntry, testEntry;
        Iterator<Map.Entry<String, Integer>> testIterator, etalonIterator;
        Map<String, Integer> etalonMap, testMap;

        //Создаём данные для теста в Map(String,List<Animal>>
        Map<String,List<Animal>> hashMap = new HashMap<>();
        animalList.clear();
        animalList.add(new Shark("Анубис", 224.32, "Активный", LocalDate.parse("2002-03-02")));
        hashMap.put("Акула", new ArrayList<>(animalList));
        animalList.clear();
        animalList.add(new Wolf("Асасин", 924.62, "Агрессивный", LocalDate.parse("2012-11-14")));
        animalList.add(new Wolf("Айрон", 527.23, "Непредсказуемый", LocalDate.parse("2013-05-16")));
        hashMap.put("Волк", new ArrayList<>(animalList));
        animalList.clear();
        animalList.add(new Cat("Аксель", 197.36, "Спокойный", LocalDate.parse("2016-06-20")));
        hashMap.put("Кот", new ArrayList<>(animalList));
        animalList.clear();
        animalList.add(new Dog("Амур", 792.53, "Активный", LocalDate.parse("2003-03-18")));
        animalList.add(new Dog("Арти", 230.13, "Непредсказуемый", LocalDate.parse("2018-04-19")));
        hashMap.put("Собака", new ArrayList<>(animalList));

        //TODO Тест-1. Проверяем, что метод вернул значения согласно ожиданиям.
        {
            //создаём шаблон с верными значениями
            etalonMap = new HashMap<>();
            etalonMap.put("Акула", 1);
            etalonMap.put("Волк", 2);
            etalonMap.put("Кот", 1);
            etalonMap.put("Собака", 2);

            //вызываем AnimalRepositoryImpl.findDuplicate() и получаем в testMap данные для теста
            testMap = animalRepository.findDuplicate(hashMap);

            testIterator = testMap.entrySet().iterator();
            etalonIterator = etalonMap.entrySet().iterator();
            while (testIterator.hasNext() && etalonIterator.hasNext()) {
                etalonEntry = etalonIterator.next();
                testEntry = testIterator.next();
                Assertions.assertEquals(etalonEntry.getKey(), testEntry.getKey());
                Assertions.assertEquals(etalonEntry.getValue(), testEntry.getValue());
            }
        }
        //TODO Тест-2. Передаваемый параметр может быть пустым, но не может быть Null.
        {
            hashMap.clear();
            Assertions.assertTrue(animalRepository.findDuplicate(hashMap).isEmpty());
            try {
                //noinspection DataFlowIssue
                Assertions.assertThrows(NullPointerException.class, () -> animalRepository.findDuplicate(null));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}

