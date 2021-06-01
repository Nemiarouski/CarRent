package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import rent.repository.RentRepository;

public class RentService {
    RentRepository rentRepository = new RentRepository();
    ClientService clientService = new ClientService();
    CarService carService = new CarService();

    public void showCars() {
        carService.show();
    }

    public void showClients() {
        clientService.show();
    }

    public void rentCar() {
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
                    carService.save(car);

                    client.setCar(car);
                    clientService.save(client);
                }
            }
        }
    }

    public void deleteCar() {
        clientService.show();
        int who = Integer.parseInt(Console.read("Which client want to unset car?"));
        Client client = clientService.findById(who);

        if (client == null) {
            System.out.println("You choose wrong client.");
        } else {
            if (client.getCar() == null) {
                System.out.println("This client doesn't have a car!");
            } else {
                Car car = carService.findById(client.getCar().getId());
                car.setRent(false);
                carService.save(car);

                client.setCar(null);
                clientService.save(client);
            }
        }
    }
}