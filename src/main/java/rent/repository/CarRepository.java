package rent.repository;

import rent.menu.ReadFromFile;
import rent.menu.WriteToFile;
import rent.model.Car;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {
    Scanner scanner = new Scanner(System.in);
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    List<Car> allCarsGlobal = new ArrayList<>();
    File file = new File("src/main/resources/cars.txt");


    public void addCar() throws IOException {
        Car car = new Car();
        car.setId(AUTO_ID.getAndIncrement());

        System.out.println("You need to enter some information:");

        System.out.println("Input car model:");
        String model = scanner.nextLine();
        car.setModel(model);

        System.out.println("Input car colour:");
        String colour = scanner.nextLine();
        car.setColour(colour);

        WriteToFile.writeToFileAppend(file, car);
    }

    public void deleteCar() throws IOException {
        System.out.println("Which car do you want to delete?");
        showCars();

        String carId = scanner.nextLine();

        int i = Integer.parseInt(carId);
        allCarsGlobal.removeIf(car -> car.getId() == i);
        System.out.println("");

        showCars();

        for (Car car : allCarsGlobal) {
            WriteToFile.writeToFileAppend(file, car.toString());
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
        String[] arrayOfCars = allCarsInOneString.split("\\*"); // Create array of '0 Kia Red' and ect.

        for (int i = 1; i < arrayOfCars.length; i++) {

            String[] newCar = arrayOfCars[i].split(" ");

            int id = Integer.parseInt(newCar[0]);
            String model = newCar[1];
            String colour = newCar[2];

            allCarsGlobal.add(new Car(id, model, colour));
        }
        return allCarsGlobal;
    }
}