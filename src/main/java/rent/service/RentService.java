package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import java.io.IOException;
import java.util.List;

public class RentService {
    ClientService clientService = new ClientService();
    CarService carService = new CarService();

    public void showCars() throws IOException, ClassNotFoundException {
        carService.showCars();
    }

    public void showClients() throws IOException, ClassNotFoundException {
        clientService.showClients();
    }

    public void rentCar() throws IOException, ClassNotFoundException {

        List<Client> clients = clientService.clientRepository.clientInit(("Sorry! Client list is empty."));
        List<Car> cars = carService.carRepository.carInit(("Sorry! Car list is empty."));

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else if (cars.isEmpty()) {
            System.out.println("You need to add new car.");
        } else {
            showClients();
            String who = Console.read("Which client want to rent car?");
            showCars();
            String which = Console.read("Which car he want to rent?");

/*            if () {

            }*/

            cars.stream().filter(car -> car.getId() == Integer.parseInt(which)).findFirst().orElse(null).setRent(true);
            carService.carRepository.writeToFile(cars);

            clients.get(Integer.parseInt(who)).setCar(cars.get(Integer.parseInt(which)));
            clientService.clientRepository.writeToFile(clients);
        }
    }

    public void deleteCar() throws IOException, ClassNotFoundException {
        List<Client> clients = clientService.clientRepository.clientInit(("Sorry! Client list is empty."));
        List<Car> cars = carService.carRepository.carInit(("Sorry! Car list is empty."));

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
       * Добавление автомобиля клиенту:
       * Какой клиент? clientNumber
       * Какую машину? carNumber
       * if (car[carNumber].isRent = true) {
       *    "Car is busy."
       * } else {
       *    car[carNumber] - setRent(true)
       *    client[clientNumber] - setCar(car[carNumber])
       * }
       *
       * */
}