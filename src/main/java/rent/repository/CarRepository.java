package rent.repository;

import rent.model.Car;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private List<Car> cars = new ArrayList<>();
    File file = new File("src/main/resources/cars.txt");

    public void addCar(Car car) {
        car.setId(AUTO_ID.getAndIncrement());
        cars.add(car.getId(), car);
    }

    public Car deleteCar(Car car) {
        return cars.remove(car.getId());
    }

    public void editCar(Car car) {
        cars.add(car.getId(), car);
    }

    public List<Car> showCars() throws IOException {
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        int i = 0;

        while (scanner.hasNextLine()) {
            System.out.println(i + " : " + scanner.nextLine());
            i++;
        }
        fileReader.close();
        return cars;
    }

    public Car showById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }
}