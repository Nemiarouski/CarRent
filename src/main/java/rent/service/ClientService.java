package rent.service;

import rent.repository.ClientRepository;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void create() {
        clientRepository.createClient();
    }

    public void update() {
        clientRepository.updateClient();
    }

    public void delete() {
        clientRepository.deleteClient();
    }

    public void show() {
        clientRepository.showClients();
    }
}