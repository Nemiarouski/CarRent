package rent.service;

import rent.model.Car;
import rent.repository.CarRepository;

import java.io.IOException;
import java.util.List;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public List<Car> showCars() throws IOException {
        return carRepository.showCars();
    }

    public Car showById(int id) {
        return carRepository.showById(id);
    }

    public void addCar(Car car) throws IOException {
        carRepository.addCar(car);
    }

    public void deleteCar(Car car) {
        carRepository.deleteCar(car);
    }

    public void editCar(Car car) {
        carRepository.editCar(car);
    }
}