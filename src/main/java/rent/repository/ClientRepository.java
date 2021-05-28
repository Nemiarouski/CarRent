package rent.repository;

import rent.menu.Console;
import rent.model.Client;
import java.util.List;

public class ClientRepository extends AbstractRepository{

    @Override
    String filePath() {
        return "src/main/resources/clients.out";
    }

    @Override
    List<Client> updateConditionTwo(String choice) {
        List<Client> clients = read();
        Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);
        client.setName(Console.read("Input client name:"));
        clients.add(client);
        return clients;
    }

    @Override
    Client updateConditionOne(String choice) {
        List<Client> clients = read();
        Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);
        return client;
    }

    @Override
    List<Client> deleteCondition(String choice) {
        List<Client> clients = read();
        clients.removeIf(l -> l.getId() == Integer.parseInt(choice));
        return clients;
    }

    @Override
    List<Client> createCondition() {
        List<Client> clients = read();
        clients.add(new Client(clients.size(), Console.read("Input client client name:"), null));
        return clients;
    }
}