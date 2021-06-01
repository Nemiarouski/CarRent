package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.repository.CarRepository;
import java.util.Comparator;
import java.util.List;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void create() {
        String model = Console.read("Input model:");
        String colour = Console.read("Input colour:");

        List<Car> cars = carRepository.read();
        Car carMaxId = cars.stream().max(Comparator.comparing(Car::getId)).orElse(null);
        Car car = new Car();

        if (carMaxId != null) {
            car.setId(carMaxId.getId() + 1);
        } else {
            car.setId(0);
        }

        car.setModel(model);
        car.setColour(colour);
        cars.add(car);
        carRepository.save(cars);
    }

    public List<Car> read() {
        return carRepository.read();
    }

    public void update() {
        show();
        int choice = Integer.parseInt(Console.read("Which number to update?"));
        Car car = carRepository.findById(choice);

        if (car != null) {
            car.setModel(Console.read("New model:"));
            car.setColour(Console.read("New colour:"));
            carRepository.saveOrUpdate(car);
        } else {
            System.out.println("You choose wrong number.");
        }
    }

    public void delete() {
        show();
        String choice = Console.read("Which number to delete?");

        List<Car> cars = carRepository.read();
        cars.removeIf(c -> c.getId() == Integer.parseInt(choice));
        carRepository.save(cars);
    }

    public void show() {
        List<Car> cars = carRepository.read();

        if (cars.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            for (Car car : cars) {
                System.out.println("[Id: " + car.getId() + " | Model: " + car.getModel() + " | Colour: " + car.getColour() + " | Rent: " + car.isRent() + "]");
            }
        }
    }

    public Car findById(int id) {
        return carRepository.findById(id);
    }

    public void save(Car car) {
        carRepository.saveOrUpdate(car);
    }
}