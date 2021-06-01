package rent.service;

import rent.menu.Console;
import rent.model.Car;
import rent.model.Client;
import rent.model.Rent;
import rent.repository.RentRepository;
import java.util.Comparator;
import java.util.List;

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

    public void deleteCar() {
        List<Rent> rents = rentRepository.read();

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

                rents.removeIf(rent -> rent.getClient().getId() == who);
                rentRepository.save(rents);
            }
        }
    }

    public void rentCar() {
        List<Rent> rents = rentRepository.read();

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
                    Rent rent;
                    Rent rentMaxId = rents.stream().max(Comparator.comparing(Rent::getId)).orElse(null);

                    if (rentMaxId != null) {
                        rent = new Rent(rentMaxId.getId() + 1, car, client, true);
                    } else {
                        rent = new Rent(0, car, client, true);
                    }
                    rentRepository.saveOrUpdate(rent);
                    car.setRent(true);
                    carService.save(car);
                    client.setCar(car);
                    clientService.save(client);
                }
            }
        }
    }

    public void showRent() {
        List<Rent> rents = rentRepository.read();

        if (rents.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            for (Rent rent : rents) {
                System.out.println("[Id: " + rent.getId() + "] [Car id: " + rent.getCar().getId() + " | Car model: "
                        + rent.getCar().getModel() + " | Car colour: " + rent.getCar().getColour() + "] [Client id: "
                        + rent.getClient().getId() + " | Client name: " + rent.getClient().getName() + "] [Rent: " + rent.isRent() + "]");
            }
        }
    }
}