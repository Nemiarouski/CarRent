package rent.service;

import rent.repository.ClientRepository;

public class ClientService {
    ClientRepository clientRepository = new ClientRepository();

    public void create() {
        clientRepository.create();
    }

    public void update() {
        clientRepository.update();
    }

    public void delete() {
        clientRepository.delete();
    }

    public void show() {
        clientRepository.showAll();
    }
}