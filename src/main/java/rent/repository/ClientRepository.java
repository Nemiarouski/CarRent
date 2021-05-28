package rent.repository;

import rent.menu.Console;
import rent.model.Client;
import java.util.List;

public class ClientRepository extends AbstractRepository{

    @Override
    public String filePath() {
        return "src/main/resources/clients.out";
    }

    @Override
    public List<Client> createCondition() {
        List<Client> clients = read();
        clients.add(new Client(clients.size(), Console.read("Input client client name:"), null));
        return clients;
    }

    @Override
    public void updateCondition(String choice) {
        List<Client> clients = read();
        Client client = clients.stream().filter(c -> c.getId() == Integer.parseInt(choice)).findFirst().orElse(null);

        if (client != null) {
            client.setName(Console.read("Input client name:"));
            save(clients);
        } else {
            System.out.println("You choose wrong number.");
        }
    }

    @Override
    public List<Client> deleteCondition(String choice) {
        List<Client> clients = read();
        clients.removeIf(l -> l.getId() == Integer.parseInt(choice));
        return clients;
    }

    @Override
    public void showCondition() {
        List<Client> clients = read();
        for (Client client : clients) {
            if (client.getCar() == null) {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [NONE]");
            } else {
                System.out.println("[Id: " + client.getId() + " | Name: " + client.getName() + "] : [Id: "
                        + client.getCar().getId() + " | Model: " + client.getCar().getModel() + " | Colour: " + client.getCar().getColour() + "]");
            }
        }
    }
}