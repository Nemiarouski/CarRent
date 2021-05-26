package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import java.util.List;

public class RentService {
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
            showCars();
            String which = Console.read("Which car he want to rent?");

            if (cars.get(Integer.parseInt(which)).isRent()) {
                System.out.println("This car is busy.");
            } else {
                cars.stream().filter(car -> car.getId() == Integer.parseInt(which)).findFirst().orElse(null).setRent(true);
                carService.carRepository.writeToFile(cars);

                clients.get(Integer.parseInt(who)).setCar(cars.get(Integer.parseInt(which)));
                clientService.clientRepository.writeToFile(clients);
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

            cars.stream().filter(car -> car.getId() == clients.get(Integer.parseInt(who)).getCar().getId()).findFirst().orElse(null).setRent(false);
            carService.carRepository.writeToFile(cars);

            clients.get(Integer.parseInt(who)).setCar(new Car());
            clientService.clientRepository.writeToFile(clients);
        }
    }
       /*
       * Удаление автомобиля:
       *
       * Какой клиент? clientNumber
       * car[client[clientNumber].getCar().getId].setRent(false)
       * client[clientNumber].setCar(new Car());
       * */
}