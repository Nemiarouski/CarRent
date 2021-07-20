package rent.concurrency.firsttry;

public class Shop {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        CarCreator carCreator = new CarCreator(carFactory);
        CarSeller carSeller = new CarSeller(carFactory);

        new Thread(carCreator).start();
        new Thread(carSeller).start();
    }
}