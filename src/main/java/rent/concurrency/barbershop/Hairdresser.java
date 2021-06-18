package rent.concurrency.barbershop;

public class Hairdresser {
    private int min;
    private int max;

    public Hairdresser(int min, int max) {
        this.min = min * 1000;
        this.max = max * 1000;
    }

    public synchronized void work() {
        System.out.println("[Hairdresser work with]: " + Thread.currentThread().getName());
        int serviceTime = createServiceTime();
        try {
            Thread.sleep(serviceTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Client]: " + Thread.currentThread().getName() + " [Served by]: " + serviceTime / 1000 + " sec.");
        System.out.println();
    }

    public int createServiceTime() {
        return (int) (Math.random() * (max-min) + min);
    }
}