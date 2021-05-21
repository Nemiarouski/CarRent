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
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    File file = new File("src/main/resources/cars.txt");


    public void addCar() throws IOException {
        Car car = new Car();
        System.out.println("You need to enter some information:");

        car.setId(AUTO_ID.getAndIncrement());
        car.setModel(ConsoleReader.consoleReader("Input car model:"));
        car.setColour(ConsoleReader.consoleReader("Input car colour:"));

        WriteToFile.writeToFileAppend(file, car);
    }

    public void deleteCar() throws IOException {
        showCars();
        int i = Integer.parseInt(ConsoleReader.consoleReader("Which car do you want to delete?"));

        List<Car> testCarArray = readCars();
        testCarArray.removeIf(car -> car.getId() == i);

        if(testCarArray.size() > 0) {
            WriteToFile.writeToFile(file, testCarArray.get(0).toString());
        } else System.out.println("You want to write empty car.");

        for (int j = 1; j < testCarArray.size(); j++) {
            WriteToFile.writeToFileAppend(file, testCarArray.get(j).toString());
        }
    }

    public void editCar(Car car) {
        //Some logic
    }

    public void showCars() throws IOException {
        for (Car car : readCars()) {
            System.out.println("Car id: " + car.getId() + ", Model: " + car.getModel() + ", Colour: " + car.getColour());
        }
    }

    public List<Car> readCars() throws IOException {
        String allCarsInOneString = ReadFromFile.readFromFile(file);  //Read from file
        String[] carArray = allCarsInOneString.split("\n"); // Create array of '0 Kia Red' and etc.

        List<Car> testCarArray = new ArrayList<>();
        for (int i = 0; i < carArray.length; i++) {

            String[] newCar = carArray[i].split(" ");

            int id = Integer.parseInt(newCar[0]);
            String model = newCar[1];
            String colour = newCar[2];

            testCarArray.add(new Car(id, model, colour));
        }
        return testCarArray;
    }
}