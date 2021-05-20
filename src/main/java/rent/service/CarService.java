package rent.service;

import rent.model.Car;
import rent.repository.CarRepository;
import java.io.IOException;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void showCars() throws IOException {
        carRepository.showCars();
    }

    public void addCar() throws IOException {
        carRepository.addCar();
    }

    public void deleteCar() throws IOException {
        carRepository.deleteCar();
    }

    public void editCar(Car car) {
        carRepository.editCar(car);
    }

    public void readCars() throws IOException {carRepository.readCars();}
}