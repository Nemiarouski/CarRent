package rent.repository;

import rent.model.Client;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client>{

    @Override
    public String filePath() {
        return "src/main/resources/clients.out";
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