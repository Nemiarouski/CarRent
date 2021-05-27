package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final static String CAR_PATH = "src/main/resources/cars.out";

    public void createCar() {
        System.out.println("Enter information about car:");
        Car car = new Car(readCars().size(), Console.read("Input model:"), Console.read("Input colour:"), false);
        saveCar(car);
    }

    public List<Car> readCars() {
        File file = new File(CAR_PATH);

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream))
            {
                return  (List<Car>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public void updateCar() {
        List<Car> cars = readCars();

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
        List<Car> cars = readCars();

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
        List<Car> cars = readCars();

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

    public void saveCar(Car car) {
        List<Car> cars = readCars();
        cars.add(car);
        saveCars(cars);
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
}