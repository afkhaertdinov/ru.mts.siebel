package HomeWork.Service;

import HomeWork.DTO.Animal;

public interface SearchService {
    void checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
