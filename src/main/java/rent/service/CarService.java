package rent.service;

import rent.model.Car;
import rent.repository.CarRepository;
import java.io.IOException;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void showCars() throws IOException {
        carRepository.showCars();
    }

    public Car showById(int id) {
        return carRepository.showById(id);
    }

    public void addCar() throws IOException {
        carRepository.addCar();
    }

    public void deleteCar(Car car) {
        carRepository.deleteCar(car);
    }

    public void editCar(Car car) {
        carRepository.editCar(car);
    }
}