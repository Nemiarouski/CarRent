package rent.concurrency.barbershop;

import java.util.concurrent.Callable;

public class Hairdresser implements Callable {
    private String name;
    private int min;
    private int max;
    private final Barbershop barbershop;

    public Hairdresser(String name, int min, int max, Barbershop barbershop) {
        this.name = name;
        this.min = min * 1000;
        this.max = max * 1000;
        this.barbershop = barbershop;
    }

    @Override
    public Client call() {
        Thread.currentThread().setName(name);
        while (true) {
            Client clientToServe = barbershop.getClient();
            System.out.println("[Hairdresser " + Thread.currentThread().getName() + " work with]: " + clientToServe.getName());
            try {
                long time = calculateServiceTime();
                Thread.sleep(time);
                System.out.println("[Hairdresser]: " + Thread.currentThread().getName() + " [Serve to]: " + clientToServe.getName() + " [For]: "
                        + (double) time / 1000  + " sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long calculateServiceTime() {
        return (long) (Math.random() * (max-min) + min);
    }
}