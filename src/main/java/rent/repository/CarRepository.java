package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CarRepository extends AbstractRepository{
    private final static String CAR_PATH = "src/main/resources/cars.out";

    public void createCar() {
        List<Car> cars = read();

        System.out.println("Enter information about car:");
        cars.add(new Car(cars.size(), Console.read("Input model:"), Console.read("Input colour:"), false));
        saveCars(cars);
    }

    public void updateCar() {
        List<Car> cars = read();

        if (cars.isEmpty()) {
            System.out.println("Nothing to edit.");
        } else {
            show(cars);
            String choice = Console.read("Which car need to edit?");
            Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

            if (car != null) {
                car.setModel(Console.read("Input new model:"));
                car.setColour(Console.read("Input new colour:"));
                saveCars(cars);
            } else {
                System.out.println("You choose wrong car.");
            }
        }
    }

    public void deleteCar() {
        List<Car> cars = read();

        if (cars.isEmpty()) {
            System.out.println("Nothing to delete.");
        } else {
            show(cars);
            String choice = Console.read("Which car need to delete?");
            cars.removeIf(car -> car.getId() == Integer.parseInt(choice));
            saveCars(cars);
        }
    }

    public void showCars() {
        List<Car> cars = read();

        if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            show(cars);
        }
    }

    public void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("[Id: " + car.getId() + " | Model: " + car.getModel() + " | Colour: " + car.getColour() + " | Rent: " + car.isRent() + "]");
        }
    }

    public void saveCars(List<Car> cars) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CAR_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    String filePath() {
        return "src/main/resources/cars.out";
    }
}