package rent.repository;

import rent.model.Car;
import rent.model.IntegerWrapper;

public class CarRepository extends AbstractRepository<Car, IntegerWrapper> {
    @Override
    public String filePath() {
        return "src/main/resources/cars.out";
    }
}