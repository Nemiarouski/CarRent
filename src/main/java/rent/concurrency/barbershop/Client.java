package rent.concurrency.barbershop;

public class Client extends Thread{
    private Hairdresser hairdresser;

    public Client(Hairdresser hairdresser) {
        this.hairdresser = hairdresser;
    }

    @Override
    public void run() {
        System.out.println("Create new client. Client name: " + Thread.currentThread().getName());
        hairdresser.addClient();
        hairdresser.work();
    }
}