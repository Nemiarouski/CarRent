package rent.service;

import rent.repository.ClientRepository;
import java.io.IOException;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void showClients() throws IOException, ClassNotFoundException {
        clientRepository.showClients();
    }

    public void addClient() throws IOException, ClassNotFoundException {
        clientRepository.addClient();
    }

    public void deleteClient() throws IOException, ClassNotFoundException {
        clientRepository.deleteClient();
    }

    public void editClient() throws IOException, ClassNotFoundException {
        clientRepository.editClient();
    }
}