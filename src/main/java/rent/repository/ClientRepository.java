package rent.repository;

import rent.menu.Console;
import rent.menu.Serialization;
import rent.model.Car;
import rent.model.Client;
import java.util.List;

public class ClientRepository {

    public void addClient() {
        List<Client> clients = readFromFile();

        System.out.println("Enter information about client:");
        clients.add(new Client(clients.size(), Console.read("Input client client name:"), new Car()));
        writeToFile(clients);
    }

    public void deleteClient() {
        List<Client> clients = readFromFile();

        if (clients.isEmpty()) {
            System.out.println("Nobody to delete.");
        } else {
            showClients();
            String choice = Console.read("Which client need to delete?");
            clients.removeIf(client -> client.getId() == Integer.parseInt(choice));
            writeToFile(clients);
        }
    }

    public void editClient() {
        List<Client> clients = readFromFile();

        if (clients.isEmpty()) {
            System.out.println("Nobody to edit.");
        } else {
            showClients();
            String choice = Console.read("Which client need to edit?");
            clients.stream().filter(client -> client.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setName(Console.read("Input client client name:"));
            writeToFile(clients);
        }
    }

    public void showClients() {
        List<Client> clients = readFromFile();

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else {
            for (Client client : clients) {
                if (client.getCar().getModel() == null) {
                    System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [NONE]");
                } else {
                    System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [Id: "
                            + client.getCar().getId() + " | Model: " + client.getCar().getModel() + " | Colour: " + client.getCar().getColour() + "]");
                }

            }
        }
    }

    public void writeToFile(List<Client> list) {
        Serialization.writeClients(list);
    }

    public List<Client> readFromFile() {
        return Serialization.readClients();
    }
}