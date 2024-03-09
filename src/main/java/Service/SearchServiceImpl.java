package Service;

import DTO.Animal;

public class SearchServiceImpl implements SearchService {
    @Override
    public void checkLeapYearAnimal(Animal animal) {
        if (animal.getBirthDate().isLeapYear()){
            System.out.println(animal.getName() + " был рожден в високосный год");
        } else {
            System.out.println(animal.getName() + " не был рожден в високосный год");
        }
    }
}
