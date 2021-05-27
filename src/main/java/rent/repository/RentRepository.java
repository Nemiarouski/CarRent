package rent.repository;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import java.util.List;

public class RentRepository {
    ClientRepository clientRepository = new ClientRepository();
    CarRepository carRepository = new CarRepository();

    public void rentCar() {
        List<Client> clients = clientRepository.read();
        List<Car> cars = carRepository.read();

        clientRepository.show(clients);
        String who = Console.read("Which client want to rent car?");
        Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(who)).findFirst().orElse(null);

        if (client == null) {
            System.out.println("You choose wrong client.");
        } else {
            carRepository.show(cars);
            String which = Console.read("Which car he want to rent?");
            Car car = cars.stream().filter(c -> c.getId() == Integer.parseInt(which)).findFirst().orElse(null);

            if (car == null) {
                System.out.println("You choose wrong car.");
            } else {
                if (car.isRent()) {
                    System.out.println("This car is busy.");
                } else {
                    car.setRent(true);
                    carRepository.saveCars(cars);

                    client.setCar(car);
                    clientRepository.saveClients(clients);
                }
            }
        }
    }

    public void deleteCar() {
        List<Client> clients = clientRepository.read();
        List<Car> cars = carRepository.read();

        clientRepository.show(clients);
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
                carRepository.saveCars(cars);

                client.setCar(null);
                clientRepository.saveClients(clients);
            }
        }
    }
}