package rent.repository;

import rent.model.Car;

public class CarRepository extends AbstractRepository<Car> {

    @Override
    public String filePath() {
        return "src/main/resources/cars.out";
    }
}