package rent.repository;

import rent.menu.ConsoleReader;
import rent.menu.ReadFromFile;
import rent.menu.WriteToFile;
import rent.model.Car;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {
      File file = new File("src/main/resources/cars.txt");
      AtomicInteger AUTO_INC = new AtomicInteger(0);

    public void addCar() throws IOException {
        Car car = new Car();
        System.out.println("Enter car data:");

        car.setId(AUTO_INC.getAndIncrement());
        car.setModel(ConsoleReader.read("Input car model:"));
        car.setColour(ConsoleReader.read("Input car colour:"));

        WriteToFile.writeAppend(file, car);
    }

    public void deleteCar() throws IOException {
        List<Car> cars = readCars();

        showCars();

        if (cars != null) {
            int i = Integer.parseInt(ConsoleReader.read("Which car need to delete?"));
            cars.removeIf(car -> car.getId() == i);

            WriteToFile.write(file, "");
            for (Car car : cars) {
                WriteToFile.writeAppend(file, car.toString());
            }
        } else {
            System.out.println("Create car, bro!");
        }
    }

    public void editCar() throws IOException {
        List<Car> cars = readCars();
        showCars();

        if (cars != null) {
            int i = Integer.parseInt(ConsoleReader.read("Which car need to edit?"));

            editCars(cars.get(i));

            WriteToFile.write(file, "");
            for (Car car : cars) {
                WriteToFile.writeAppend(file, car.toString());
            }
        } else {
            System.out.println("Create car, bro!");
        }
    }

    public void editCars(Car car) {
        car.setModel(ConsoleReader.read("Input car model:"));
        car.setColour(ConsoleReader.read("Input car colour:"));
    }

    public void showCars() throws IOException {
        List<Car> cars = readCars();
        if (cars != null) {
            for (Car car : cars) {
                System.out.println("Car id: " + car.getId() + ", Model: " + car.getModel() + ", Colour: " + car.getColour());
            }
        } else {
            System.out.println("You need to create a car before showing.");
            System.out.println();
        }
    }

    public List<Car> readCars() throws IOException {
        List<Car> cars = new ArrayList<>();

        String allCarsInOneString = ReadFromFile.read(file);  //Read from file

        if (allCarsInOneString.equals("")) {
            System.out.println("Car list is empty");
            return null;
        } else {
            String[] carArray = allCarsInOneString.split("\n"); // Create array of '0 Kia Red' and etc.

            for (int i = 0; i < carArray.length; i++) {

                String[] newCar = carArray[i].split(" ");

                String model = newCar[1];
                String colour = newCar[2];

                cars.add(new Car(i, model, colour));
            }
            return cars;
        }
    }
}