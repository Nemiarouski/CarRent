package rent.service;

import rent.menu.Console;
import rent.model.Client;
import rent.repository.ClientRepository;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void create() {
        String clientName = Console.read("Input client name:");
        List<Client> clients = clientRepository.read();
        Client clientMaxId = clients.stream().max(Comparator.comparing(Client::getId)).orElseThrow(NoSuchElementException::new);

        Client client = new Client();
        client.setId(clientMaxId.getId() + 1);
        client.setName(clientName);

        clients.add(client);
        clientRepository.save(clients);
    }

    public List<Client> read() {
        return clientRepository.read();
    }

    public void update() {
        show();
        int choice = Integer.parseInt(Console.read("Which number to update?"));
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
        clients.removeIf(c -> c.getId() == Integer.parseInt(choice));
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

    public Client findById(int id) {
        return clientRepository.findById(id);
    }
}