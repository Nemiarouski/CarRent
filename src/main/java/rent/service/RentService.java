package rent.service;

import rent.repository.RentRepository;

public class RentService {
    CarService carService = new CarService();
    ClientService clientService = new ClientService();
    RentRepository rentRepository = new RentRepository();

    public void showCars() {
        carService.show();
    }

    public void showClients() {
        clientService.show();
    }

    public void rentCar() {
        rentRepository.rentCar();
    }

    public void deleteCar() {
        rentRepository.deleteCar();
    }
}