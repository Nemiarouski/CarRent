package rent.repository;

import rent.menu.ReadFromFile;
import rent.model.Car;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {
    Scanner scanner = new Scanner(System.in);
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private List<Car> cars = new ArrayList<>();
    File file = new File("src/main/resources/cars.txt");


    public void addCar() throws IOException {
        Car car = new Car();
        System.out.println("You need to enter some information:");

        System.out.println("Input car model:");
        String model = scanner.nextLine();
        car.setModel(model);

        System.out.println("Input car colour:");
        String colour = scanner.nextLine();
        car.setColour(colour);

        car.setId(AUTO_ID.getAndIncrement());
        cars.add(car.getId(), car);
        writeToFile(car);
    }

    public Car deleteCar(Car car) {
        return cars.remove(car.getId());
    }

    public void editCar(Car car) {
        cars.add(car.getId(), car);
    }

    public void showCars() throws IOException {
        //readFromFile();
        ReadFromFile.readFromFile(file);
    }

    public Car showById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

/*    public void readFromFile() throws IOException {
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        fileReader.close();
    }*/

    public void writeToFile(Car car) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(car.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}