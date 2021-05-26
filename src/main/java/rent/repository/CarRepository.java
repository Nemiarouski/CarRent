package rent.repository;

import rent.menu.Console;
import rent.menu.Serialization;
import rent.model.Car;
import java.util.List;

public class CarRepository {

    public void addCar() {
        List<Car> cars = readFromFile();

        System.out.println("Enter information about car:");
        cars.add(new Car(cars.size(), Console.read("Input model:"), Console.read("Input colour:"), false));
        writeToFile(cars);
    }

    public void deleteCar() {
        List<Car> cars = readFromFile();

        if (cars.isEmpty()) {
            System.out.println("Nothing to delete.");
        } else {
            show(cars);
            String choice = Console.read("Which car need to delete?");
            cars.removeIf(car -> car.getId() == Integer.parseInt(choice));
            writeToFile(cars);
        }
    }

    public void editCar() {
        List<Car> cars = readFromFile();

        if (cars.isEmpty()) {
            System.out.println("Nothing to edit.");
        } else {
            show(cars);
            String choice = Console.read("Which car need to edit?");
            int carId = Integer.parseInt(choice);
            Car car = cars.stream().filter(c -> c.getId() == carId).findFirst().orElse(null);

            if (car != null) {
                car.setModel(Console.read("Input new model:"));
                car.setColour(Console.read("Input new colour:"));
                writeToFile(cars);
            } else {
                System.out.println("You choose wrong car.");
            }
        }
    }

    public void showCars() {
        List<Car> cars = readFromFile();

        if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            show (cars);
        }
    }

    public void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("[Id: " + car.getId() + " | Model: " + car.getModel() + " | Colour: " + car.getColour() + " | Rent: " + car.isRent() + "]");
        }
    }

    public void writeToFile(List<Car> list) {
        Serialization.writeCars(list);
    }

    public List<Car> readFromFile() {
        return Serialization.readCars();
    }
}