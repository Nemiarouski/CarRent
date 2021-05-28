package rent.service;

import rent.repository.CarRepository;

public class CarService {
    CarRepository carRepository = new CarRepository();

    public void creat() {
        carRepository.create();
    }

    public void edit() {
        carRepository.update();
    }

    public void delete() {
        carRepository.delete();
    }

    public void show() {
        carRepository.showAll();
    }
}