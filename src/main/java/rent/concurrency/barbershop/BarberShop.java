package rent.concurrency.barbershop;

public class BarberShop {
    public static void main(String[] args) {
        Hairdresser hairdresser = new Hairdresser(1,3);
        new ClientCreator(hairdresser, 10).start();
    }
}