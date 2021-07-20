package rent.concurrency.firsttry;

public class CarSeller implements Runnable {
    CarFactory carFactory;

    public CarSeller(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            carFactory.sellCar();
        }
    }
}
