package rent.service;

import rent.repository.ClientRepository;
import java.io.IOException;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void showClients() throws IOException, ClassNotFoundException {
        clientRepository.showAllClients();
    }

    public void addClient() throws IOException, ClassNotFoundException {
        clientRepository.newClient();
    }

    public void deleteClient() throws IOException, ClassNotFoundException {
        clientRepository.deleteOneClient();
    }

    public void editClient() throws IOException, ClassNotFoundException {
        clientRepository.editOneClient();
    }
}