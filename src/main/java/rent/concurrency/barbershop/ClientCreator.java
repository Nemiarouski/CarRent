package rent.concurrency.barbershop;

public class ClientCreator extends Thread {
    private final Barbershop barbershop;
    private final int clientCount;

    public ClientCreator(Barbershop barbershop, int clientCount) {
        this.barbershop = barbershop;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        int currentCount = clientCount;
        while (currentCount > 0) {
            try {
                Client client = new Client("Client " + ((clientCount - currentCount) + 1));
                System.out.println("[New client]: " + client.getName());
                barbershop.addClient(client);

                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentCount--;
        }
    }
}