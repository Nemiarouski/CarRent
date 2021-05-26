package rent.service;

import rent.model.Car;
import rent.repository.CarRepository;
import java.util.List;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void showCars() {
        carRepository.showCars();
    }

    public void addCar() {
        carRepository.addCar();
    }

    public void deleteCar() {
        carRepository.deleteCar();
    }

    public void editCar() {
        carRepository.editCar();
    }

    public List<Car> readCars() {
        return carRepository.readFromFile();
    }

    public void writeCars(List<Car> cars){
        carRepository.writeToFile(cars);
    }
}