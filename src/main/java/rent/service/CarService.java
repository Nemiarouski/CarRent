package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.repository.CarRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarService {
    CarRepository carRepository = new CarRepository();
    AtomicInteger atomicInt = new AtomicInteger(0);

    public void create() {
        String model = Console.read("Input model:");
        String colour = Console.read("Input colour:");

        Car car = new Car();
        car.setId(atomicInt.getAndIncrement());
        car.setModel(model);
        car.setColour(colour);

        carRepository.create(car);
    }

    public void update() {
        show();

        String choice = Console.read("Which number to update?");

        List<Car> cars = carRepository.read();
        Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

        if (car != null) {
            car.setModel(Console.read("New model:"));
            car.setColour(Console.read("New colour:"));

            carRepository.save(cars);
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
        carRepository.show();
    }
}