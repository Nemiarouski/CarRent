package rent.concurrency.barbershop;

public class Hairdresser {
    private int clients = 0;
    private int serviceTime = 0;

    public synchronized void work() {
        System.out.println("Hairdresser work with client: " + Thread.currentThread().getName());
        try {
            serviceTime = createServiceTime();
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Client: " + Thread.currentThread().getName() + " served by: " + serviceTime / 1000 + " sec.");
        deleteClient();
        System.out.println("Clients left: " + clients);
        System.out.println();
    }

    public int createServiceTime() {
        return (int) (Math.random() * 6000 + 1000);
    }

    public void deleteClient() {
        clients--;
    }
    public void addClient() {
        clients++;
    }
}