package rent.service;

import rent.model.Client;
import rent.repository.ClientRepository;
import java.util.List;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void showClients() {
        clientRepository.showClients();
    }

    public void addClient() {
        clientRepository.addClient();
    }

    public void deleteClient() {
        clientRepository.deleteClient();
    }

    public void editClient() {
        clientRepository.editClient();
    }

    public List<Client> readClients() {
        return clientRepository.readFromFile();
    }
}