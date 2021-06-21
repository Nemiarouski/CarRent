package rent.concurrency.barbershop;

import java.util.ArrayDeque;
import java.util.Queue;

public class Barbershop {
    private volatile Queue<Client> clients = new ArrayDeque<>();

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
        Client client = clients.poll();
        notify();
        return client;
    }
}
