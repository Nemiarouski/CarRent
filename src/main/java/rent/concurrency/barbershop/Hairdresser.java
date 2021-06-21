package rent.concurrency.barbershop;

import java.text.DecimalFormat;

public class Hairdresser extends Thread {
    private String name;
    private int min;
    private int max;
    private final Barbershop barbershop;

    public Hairdresser(String name, int min, int max, Barbershop barbershop) {
        this.name = name;
        this.min = min * 1000;
        this.max = max * 1000;
        this.barbershop = barbershop;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            Client clientToServe = barbershop.getClient();
            System.out.println("[Hairdresser " + this.getName() + " work with]: " + clientToServe.getName());
            try {
                double time = calculateServiceTime();
                Thread.sleep((long) time);
                System.out.println("[Hairdresser]: " + this.getName() + " [Serve to]: " + clientToServe.getName() + " [For]: "
                        + new DecimalFormat("0.00").format(time / 1000)  + " sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double calculateServiceTime() {
        return (Math.random() * (max-min) + min);
    }
}