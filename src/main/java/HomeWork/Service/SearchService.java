package HomeWork.Service;

import HomeWork.DTO.Animal;

public interface SearchService {
    String checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
