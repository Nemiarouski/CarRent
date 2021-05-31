package rent.repository;

import rent.model.Car;
import java.util.List;

public class CarRepository extends AbstractRepository<Car> {

    @Override
    public String filePath() {
        return "src/main/resources/cars.out";
    }

    @Override
    public void showCondition() {
        List<Car> cars = read();
        for (Car car : cars) {
            System.out.println("[Id: " + car.getId() + " | Model: " + car.getModel() + " | Colour: " + car.getColour() + " | Rent: " + car.isRent() + "]");
        }
    }
}