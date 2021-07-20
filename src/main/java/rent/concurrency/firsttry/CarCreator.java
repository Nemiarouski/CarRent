package rent.concurrency.firsttry;

public class CarCreator implements Runnable {
    CarFactory carFactory;

    public CarCreator(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            carFactory.createCar();
        }
    }
}
