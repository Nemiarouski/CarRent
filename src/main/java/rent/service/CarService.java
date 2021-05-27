package rent.service;

import rent.repository.CarRepository;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void creat() {
        carRepository.createCar();
    }

    /*public void read() {
        carRepository.readCars();
    }*/

    public void edit() {
        carRepository.updateCar();
    }

    public void delete() {
        carRepository.deleteCar();
    }

    public void show() {
        carRepository.showCars();
    }
}