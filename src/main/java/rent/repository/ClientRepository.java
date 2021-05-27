package rent.repository;

import rent.menu.Console;
import rent.model.Client;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ClientRepository extends AbstractRepository{
    private final static String CLIENT_PATH = "src/main/resources/clients.out";

    public void createClient() {
        List<Client> clients = read();

        System.out.println("Enter information about client:");
        clients.add(new Client(clients.size(), Console.read("Input client client name:"), null));
        saveClients(clients);
    }

    public void updateClient() {
        List<Client> clients = read();

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
        List<Client> clients = read();

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
        List<Client> clients = read();

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

    public void saveClients(List<Client> clients) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CLIENT_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    String filePath() {
        return "src/main/resources/clients.out";
    }
}