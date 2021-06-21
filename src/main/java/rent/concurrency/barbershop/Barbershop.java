package rent.concurrency.barbershop;

import java.util.ArrayList;
import java.util.List;

public class Barbershop {
    private volatile List<Client> clients = new ArrayList<>();

    public synchronized void addClient(Client client) {
        clients.add(client);
        notify();
    }

    public synchronized Client getClient() {
        while (clients.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Client client = clients.get(0);
        clients.remove(0);
        notify();
        return client;
    }
}
