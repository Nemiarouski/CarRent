package rent.concurrency.firsttry;

public class CarFactory {
    private int cars = 0;

    public synchronized void sellCar() {
        while (cars < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cars--;
        System.out.println("We sold one car.");
        System.out.println("Now we have: " + cars);
        notify();
    }

    public synchronized void createCar() {
        while (cars > 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cars++;
        System.out.println("We create new car");
        System.out.println("We create have: " + cars);
        notify();
    }
}
