package rent.service;

import rent.menu.Console;
import rent.model.Client;
import rent.repository.ClientRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();
    AtomicInteger atomicInt = new AtomicInteger(0);

    public void create() {
        String clientName = Console.read("Input client name:");

        Client client = new Client();
        client.setId(atomicInt.getAndIncrement());
        client.setName(clientName);

        clientRepository.create(client);
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
        clientRepository.show();
    }
}