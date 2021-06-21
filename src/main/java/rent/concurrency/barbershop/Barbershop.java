package rent.concurrency.barbershop;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Barbershop {
    private final ConcurrentLinkedQueue<Client> clients = new ConcurrentLinkedQueue<>();

    public void addClient(Client client) {
        synchronized (clients) {
            clients.add(client);
            clients.notify();
        }
    }

    public Client getClient() {
        synchronized (clients) {
            while (clients.isEmpty()) {
                try {
                    clients.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Client client = clients.poll();
            clients.notify();
            return client;
        }
    }
}
