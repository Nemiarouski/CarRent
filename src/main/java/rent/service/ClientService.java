package rent.service;

import rent.repository.ClientRepository;
import java.io.IOException;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void showClients() throws IOException {
        clientRepository.showClients();
    }

    public void addClient() throws IOException {
        clientRepository.addClient();
    }

    public void deleteClient() throws IOException {
        clientRepository.deleteClient();
    }

    public void editClient() throws IOException {
        clientRepository.editClient();
    }
}