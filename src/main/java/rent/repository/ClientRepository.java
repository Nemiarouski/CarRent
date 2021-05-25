package rent.repository;

import rent.menu.Console;
import rent.menu.Serialization;
import rent.model.Car;
import rent.model.Client;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public void addClient() throws IOException, ClassNotFoundException {
        List<Client> clients = clientInit("Congratulations! This is first client!");

        System.out.println("Enter information about client:");
        clients.add(new Client(clients.size(), Console.read("Input client client name:"), new Car()));
        writeToFile(clients);
    }

    public void deleteClient() throws IOException, ClassNotFoundException {
        List<Client> clients = clientInit("Sorry! Client list is empty.");

        if (clients.isEmpty()) {
            System.out.println("Nobody to delete.");
        } else {
            showClients();
            String choice = Console.read("Which client need to delete?");
            clients.removeIf(client -> client.getId() == Integer.parseInt(choice));
            writeToFile(clients);
        }
    }

    public void editClient() throws IOException, ClassNotFoundException {
        List<Client> clients = clientInit("Sorry! Client list is empty.");

        if (clients.isEmpty()) {
            System.out.println("Nobody to edit.");
        } else {
            showClients();
            String choice = Console.read("Which client need to edit?");
            clients.stream().filter(client -> client.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setName(Console.read("Input client client name:"));
            writeToFile(clients);
        }
    }

    public void showClients() throws IOException, ClassNotFoundException {
        List<Client> clients = clientInit("Sorry! Client list is empty.");

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else {
            for (Client client : clients) {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [Id: "
                        + client.getCar().getId() + " | Model: " +client.getCar().getModel() + " | Colour: " + client.getCar().getColour() + "]");
            }
        }
    }

    public void writeToFile(List<Client> list) throws IOException {
        Serialization.write(list);
    }

    public List<Client> readFromFile() throws IOException, ClassNotFoundException {
        return Serialization.read();
    }

    public List<Client> clientInit(String text) throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();

        try {
            clients = readFromFile();
        } catch (EOFException e) {
            Console.write(text);
        }
        return clients;
    }
}