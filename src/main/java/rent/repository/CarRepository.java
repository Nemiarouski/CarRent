package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import java.util.List;

public class CarRepository extends AbstractRepository{

    @Override
    String filePath() {
        return "src/main/resources/cars.out";
    }

    @Override
    List<Car> updateConditionTwo(String choice) {
        List<Car> cars = read();
        Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);
        car.setModel(Console.read("Input new model:"));
        car.setColour(Console.read("Input new colour:"));
        cars.add(car);
        return cars;
    }

    @Override
    Car updateConditionOne(String choice) {
        List<Car> cars = read();
        Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);
        return car;
    }

    @Override
    List<Car> deleteCondition(String choice) {
        List<Car> cars = read();
        cars.removeIf(l -> l.getId() == Integer.parseInt(choice));
        return cars;
    }

    @Override
    List<Car> createCondition() {
        List<Car> cars = read();
        cars.add(new Car(cars.size(), Console.read("Input model:"), Console.read("Input colour:"), false));
        return cars;
    }
}