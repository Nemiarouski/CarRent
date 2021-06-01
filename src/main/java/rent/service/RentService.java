package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import rent.repository.RentRepository;

import java.util.List;

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
        List<Client> clients = clientService.read();
        List<Car> cars = carService.read();

        clientService.show();
        int who = Integer.parseInt(Console.read("Which client want to rent car?"));
        Client client = clientService.findById(who);

        if (client == null) {
            System.out.println("You choose wrong client.");
        } else {
            carService.show();
            int which = Integer.parseInt(Console.read("Which car he want to rent?"));
            Car car = carService.findById(which);

            if (car == null) {
                System.out.println("You choose wrong car.");
            } else {
                if (car.isRent()) {
                    System.out.println("This car is busy.");
                } else {
                    car.setRent(true);
                    //carService.update(cars);

                    client.setCar(car);
                    //clientRepository.save(clients);
                }
            }
        }

        rentRepository.rentCar();
    }

    public void deleteCar() {
        rentRepository.deleteCar();
    }
}