package rent.repository;

import rent.menu.ConsoleReader;
import rent.menu.Serialization;
import rent.model.Client;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public void writeToFile(List<Client> list) throws IOException {
        Serialization.write(list);
    }

    public List<Client> readFromFile() throws IOException, ClassNotFoundException {
        return Serialization.read();
    }

    public void addClient() throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();
        try {
            clients = readFromFile();
        } catch (EOFException e) {
            System.out.println("Congratulations! This is first client!");
        }
        System.out.println("Enter information about client:");
        clients.add(new Client(clients.size(), ConsoleReader.read("Input client client name:"), ConsoleReader.read("Input car model:")));
        writeToFile(clients);
    }

    public void showClients() throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();

        try {
            clients = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Client list is empty.");
        }

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else {
            for (Client client : clients) {
                System.out.println("Client id: " + client.getId() + ", Client name: " + client.getName() + ", Car: " + client.getCar());
            }
        }
    }

    public void deleteClient() throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();

        try {
            clients = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Client list is empty.");
        }

        if (clients.isEmpty()) {
            System.out.println("Nobody to delete.");
        } else {
            showClients();
            String choice = ConsoleReader.read("Which client need to delete?");
            clients.removeIf(client -> client.getId() == Integer.parseInt(choice));
            Serialization.write(clients);
        }
    }

    public void editClient() throws IOException, ClassNotFoundException {
        List<Client> clients = new ArrayList<>();

        try {
            clients = readFromFile();
        } catch (EOFException e) {
            System.out.println("Sorry! Client list is empty.");
        }

        if (clients.isEmpty()) {
            System.out.println("Nobody to edit.");
        } else {
            showClients();
            String choice = ConsoleReader.read("Which client need to edit?");
            clients.stream().filter(client -> client.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setName(ConsoleReader.read("Input client client name:"));
            clients.stream().filter(client -> client.getId() == Integer.parseInt(choice)).findFirst().orElse(null).setCar(ConsoleReader.read("Input car model:"));
            Serialization.write(clients);
        }
    }
}