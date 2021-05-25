package rent.repository;

import rent.menu.Console;
import rent.menu.Serialization;
import rent.model.Car;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    public void writeToFile(List<Car> list) throws IOException {
        Serialization.writeCars(list);
    }

    public List<Car> readFromFile() throws IOException, ClassNotFoundException {
        return Serialization.readCars();
    }

    public void addCar() throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();

        try {
            cars = readFromFile();
        } catch (EOFException e) {
            System.out.println("Congratulations! This is first car!");
        }

        System.out.println("Enter information about car:");
        cars.add(new Car(cars.size(), Console.read("Input model:"), Console.read("Input colour:")));
        writeToFile(cars);
    }

    public void deleteCar() throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();

        try {
            cars = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Car list is empty.");
        }

        if (cars.isEmpty()) {
            System.out.println("Nothing to delete.");
        } else {
            showCars();
            String choice = Console.read("Which car need to delete?");
            cars.removeIf(car -> car.getId() == Integer.parseInt(choice));
            writeToFile(cars);
        }
    }

    public void editCar() throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();

        try {
            cars = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Car list is empty.");
        }

        if (cars.isEmpty()) {
            System.out.println("Nothing to edit.");
        } else {
            showCars();
            String choice = Console.read("Which car need to edit?");
            cars.stream().filter(car -> car.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setModel(Console.read("Input new model:"));
            cars.stream().filter(car -> car.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setColour(Console.read("Input new colour:"));
            writeToFile(cars);
        }
    }

    public void showCars() throws IOException, ClassNotFoundException {
        List<Car> cars = new ArrayList<>();

        try {
            cars = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Car list is empty.");
        }

        if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            for (Car car : cars) {
                System.out.println("Car id: " + car.getId() + ", Car model: " + car.getModel() + ", Car colour: " + car.getColour());
            }
        }
    }
}