package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import java.util.List;

public class CarRepository extends AbstractRepository {

    @Override
    public String filePath() {
        return "src/main/resources/cars.out";
    }

    @Override
    public List<Car> createCondition() {
        List<Car> cars = read();
        cars.add(new Car(cars.size(), Console.read("Input model:"), Console.read("Input colour:"), false));
        return cars;
    }

    @Override
    public void updateCondition(String choice) {
        List<Car> cars = read();
        Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

        if (car != null) {
            car.setModel(Console.read("Input new model:"));
            car.setColour(Console.read("Input new colour:"));
            save(cars);
        } else {
            System.out.println("You choose wrong number.");
        }
    }

    @Override
    public List<Car> deleteCondition(String choice) {
        List<Car> cars = read();
        cars.removeIf(l -> l.getId() == Integer.parseInt(choice));
        return cars;
    }

    @Override
    public void showCondition() {
        List<Car> cars = read();
        for (Car car : cars) {
            System.out.println("[Id: " + car.getId() + " | Model: " + car.getModel() + " | Colour: " + car.getColour() + " | Rent: " + car.isRent() + "]");
        }
    }
}