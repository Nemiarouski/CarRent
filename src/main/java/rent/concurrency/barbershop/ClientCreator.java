package rent.concurrency.barbershop;

import java.util.List;

public class ClientCreator extends Thread {
    private List<Hairdresser> hairdressers;
    private int clientCount;

    public ClientCreator(List<Hairdresser> hairdressers, int clientCount) {
        this.hairdressers = hairdressers;
        this.clientCount = clientCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < clientCount; i++) {
            try {
                System.out.println("[New client]: " + Thread.currentThread().getName());
                int randomHairdresser = (int) (Math.random() * hairdressers.size());
                hairdressers.get(randomHairdresser).work();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}