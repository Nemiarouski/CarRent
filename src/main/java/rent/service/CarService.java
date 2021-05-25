package rent.service;

import rent.repository.CarRepository;
import java.io.IOException;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void showCars() throws IOException, ClassNotFoundException {
        carRepository.showCars();
    }

    public void addCar() throws IOException, ClassNotFoundException {
        carRepository.addCar();
    }

    public void deleteCar() throws IOException, ClassNotFoundException {
        carRepository.deleteCar();
    }

    public void editCar() throws IOException, ClassNotFoundException {
        carRepository.editCar();
    }
}