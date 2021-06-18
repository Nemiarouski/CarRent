package rent.concurrency.barbershop;

public class ClientCreator extends Thread {
    private Hairdresser hairdresser;
    private int clientCount;

    public ClientCreator(Hairdresser hairdresser, int clientCount) {
        this.hairdresser = hairdresser;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < clientCount; i++) {
            try {
                createClient();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createClient() {
        new Client(hairdresser).start();
    }
}