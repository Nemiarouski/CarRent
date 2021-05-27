package rent.repository;

import rent.menu.Console;
import rent.model.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private final static String CLIENT_PATH = "src/main/resources/clients.out";

    public void createClient() {
        System.out.println("Enter information about client:");
        Client client = new Client(readClients().size(), Console.read("Input client client name:"), null);
        saveClient(client);
    }

    public List<Client> readClients() {
        File file = new File(CLIENT_PATH);

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream))
            {
                return (List<Client>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public void updateClient() {
        List<Client> clients = readClients();

        if (clients.isEmpty()) {
            System.out.println("Nobody to edit.");
        } else {
            show(clients);
            String choice = Console.read("Which client need to edit?");
            Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

            if (client != null) {
                client.setName(Console.read("Input client client name:"));
                saveClients(clients);
            } else {
                System.out.println("You choose wrong client.");
            }
        }
    }

    public void deleteClient() {
        List<Client> clients = readClients();

        if (clients.isEmpty()) {
            System.out.println("Nobody to delete.");
        } else {
            show(clients);
            String choice = Console.read("Which client need to delete?");
            clients.removeIf(client -> client.getId() == Integer.parseInt(choice));
            saveClients(clients);
        }
    }

    public void showClients() {
        List<Client> clients = readClients();

        if (clients.isEmpty()) {
            System.out.println("You need to add new client.");
        } else {
            show(clients);
        }
    }

    public void show(List<Client> clients) {
        for (Client client : clients) {
            if (client.getCar() == null) {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [NONE]");
            } else {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [Id: "
                        + client.getCar().getId() + " | Model: " + client.getCar().getModel() + " | Colour: " + client.getCar().getColour() + "]");
            }
        }
    }

    public void saveClient(Client client) {
        List<Client> clients = readClients();
        clients.add(client);
        saveClients(clients);
    }

    public void saveClients(List<Client> clients) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CLIENT_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}