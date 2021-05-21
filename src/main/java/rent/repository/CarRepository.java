package rent.repository;

import rent.menu.ConsoleReader;
import rent.menu.ReadFromFile;
import rent.menu.WriteToFile;
import rent.model.Car;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
      File file = new File("src/main/resources/cars.txt");

    public void addCar() throws IOException {
        Car car = new Car();
        System.out.println("You need to enter information about car:");

        car.setId(0);
        car.setModel(ConsoleReader.consoleReader("Input car model:"));
        car.setColour(ConsoleReader.consoleReader("Input car colour:"));

        WriteToFile.writeToFileAppend(file, car);
    }

    public void deleteCar() throws IOException {
        List<Car> testCarArray = readCars();

        showCars();

        if (readCars() != null) {
            int i = Integer.parseInt(ConsoleReader.consoleReader("Which car do you want to delete?"));
            testCarArray.removeIf(car -> car.getId() == i);

            WriteToFile.writeToFile(file, "");
            for (Car car : testCarArray) {
                WriteToFile.writeToFileAppend(file, car.toString());
            }
        } else {
            System.out.println("Create car, bro!");
        }
    }

    public void editCar() throws IOException {
        List<Car> testCarArray = readCars();
        showCars();

        if (readCars() != null) {
            int i = Integer.parseInt(ConsoleReader.consoleReader("Which car do you want to edit?"));

            testCarArray.get(i).setModel(ConsoleReader.consoleReader("Input car model:"));
            testCarArray.get(i).setColour(ConsoleReader.consoleReader("Input car colour:"));

            WriteToFile.writeToFile(file, "");
            for (Car car : testCarArray) {
                WriteToFile.writeToFileAppend(file, car.toString());
            }
        } else {
            System.out.println("Create car, bro!");
        }
    }

    public void showCars() throws IOException {

        if (readCars() != null) {
            for (Car car : readCars()) {
                System.out.println("Car id: " + car.getId() + ", Model: " + car.getModel() + ", Colour: " + car.getColour());
            }
        } else {
            System.out.println("You need to create a car before showing.");
            System.out.println();
        }
    }

    public List<Car> readCars() throws IOException {
        List<Car> testCarArray = new ArrayList<>();

        String allCarsInOneString = ReadFromFile.readFromFile(file);  //Read from file

        if (allCarsInOneString.equals("")) {
            System.out.println("Car list is empty");
        } else {
            String[] carArray = allCarsInOneString.split("\n"); // Create array of '0 Kia Red' and etc.

            for (int i = 0; i < carArray.length; i++) {

                String[] newCar = carArray[i].split(" ");

                String model = newCar[1];
                String colour = newCar[2];

                testCarArray.add(new Car(i, model, colour));
            }
            return testCarArray;
        }
        return null;
    }
}