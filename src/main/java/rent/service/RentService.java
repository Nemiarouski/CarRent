package rent.service;

import rent.repository.RentRepository;

public class RentService {
    RentRepository rentRepository = new RentRepository();

    public void showCars() {
        rentRepository.showCars();
    }

    public void showClients() {
        rentRepository.showClients();
    }

    public void rentCar() {
        rentRepository.rentCar();
    }

    public void deleteCar() {
        rentRepository.deleteCar();
    }
}