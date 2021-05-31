package rent.service;

import rent.menu.Console;
import rent.model.Client;
import rent.repository.ClientRepository;
import java.util.List;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void create() {
        String clientName = Console.read("Input client name:");

        Client client = new Client();
        client.setId(0);
        client.setName(clientName);

        List<Client> clients = clientRepository.read();
        clients.add(client);
        clientRepository.save(clients);
    }

    public void update() {
        show();

        String choice = Console.read("Which number to edit?");

        List<Client> clients = clientRepository.read();
        Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

        if (client != null) {
            client.setName(Console.read("New client name:"));

            clientRepository.save(clients);
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
        replaceId();
        clientRepository.show();
    }

    public void replaceId() {
        List<Client> clients = clientRepository.read();

        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).setId(i);
        }

        clientRepository.save(clients);
    }
}