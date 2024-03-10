package HomeWork.Service;

import HomeWork.DTO.Animal;

import java.time.LocalDate;

public class SearchServiceImpl implements SearchService {
    @Override
    public void checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException {
        try {
            if (animal == null) {
                throw new InvalidAnimalException("на вход пришло некорректный объект животного " + LocalDate.now());
            }
            if (animal.getBirthDate() == null){
                throw new InvalidAnimalBirthDateException("у животного " + animal + " не указана дата его рождения");
            }
            if (animal.getBirthDate().isLeapYear()) {
                System.out.println(animal.getName() + " был рожден в високосный год");
            } else {
                System.out.println(animal.getName() + " не был рожден в високосный год");
            }
        } catch (InvalidAnimalException ignored) {
        }

    }
}
