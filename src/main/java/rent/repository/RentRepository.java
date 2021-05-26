package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import rent.service.CarService;
import rent.service.ClientService;

import java.util.List;

public class RentRepository {
    ClientService clientService = new ClientService();
    CarService carService = new CarService();

    public void showCars() {
        carService.showCars();
    }

    public void showClients() {
        clientService.showClients();
    }

    public void rentCar() {
        List<Client> clients = clientService.readClients();
        List<Car> cars = carService.readCars();

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            showClients();
            String who = Console.read("Which client want to rent car?");
            Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(who)).findFirst().orElse(null);

            if (client == null) {
                System.out.println("You choose wrong client.");
            } else {
                showCars();
                String which = Console.read("Which car he want to rent?");
                Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(which)).findFirst().orElse(null);

                if (car == null) {
                    System.out.println("You choose wrong car.");
                } else {
                    if (car.isRent()) {
                        System.out.println("This car is busy.");
                    } else {
                        car.setRent(true);
                        carService.writeCars(cars);

                        client.setCar(car);
                        clientService.writeClients(clients);
                    }
                }
            }
        }
    }

    public void deleteCar() {
        List<Client> clients = clientService.readClients();
        List<Car> cars = carService.readCars();

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            showClients();
            String who = Console.read("Which client want to unset car?");
            Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(who)).findFirst().orElse(null);

            if (client == null) {
                System.out.println("You choose wrong client.");
            } else {
                if (client.getCar() == null) {
                    System.out.println("This client doesn't have a car!");
                } else {
                    Car car = cars.stream().filter(c -> c.getId() == clients.get(Integer.parseInt(who)).getCar().getId()).findFirst().orElse(null);
                    car.setRent(false);
                    carService.writeCars(cars);

                    client.setCar(null);
                    clientService.writeClients(clients);
                }
            }
        }
    }
}