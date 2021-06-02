package rent.service;

import rent.menu.Console;
import rent.model.Client;
import rent.repository.ClientRepository;
import java.util.Comparator;
import java.util.List;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void create() {
        String clientName = Console.read("Input client name:");
        List<Client> clients = clientRepository.read();
        Client clientMaxId = clients.stream().max(Comparator.comparing(Client::getId)).orElse(null);

        Client client = new Client();
        if (clientMaxId != null) {
             client.setId(clientMaxId.getId() + 1);
        } else {
            client.setId("a");
        }
        client.setName(clientName);
        clients.add(client);
        clientRepository.save(clients);
    }

    public List<Client> read() {
        return clientRepository.read();
    }

    public void update() {
        show();
        String choice = Console.read("Which number to update?");
        Client client = clientRepository.findById(choice);

        if (client != null) {
            client.setName(Console.read("New client name:"));
            clientRepository.saveOrUpdate(client);
        } else {
            System.out.println("You choose wrong number.");
        }
    }

    public void delete() {
        show();
        String choice = Console.read("Which number to delete?");

        List<Client> clients = clientRepository.read();
        clients.removeIf(c -> c.getId().equals(choice));
        clientRepository.save(clients);
    }

    public void show() {
        List<Client> clients = clientRepository.read();

        for (Client client : clients) {
            if (client.getCar() == null) {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [NONE]");
            } else {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [Id: "
                        + client.getCar().getId() + " | Model: " + client.getCar().getModel() + " | Colour: " + client.getCar().getColour() + "]");
            }
        }
    }

    public Client findById(String id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        clientRepository.saveOrUpdate(client);
    }
}