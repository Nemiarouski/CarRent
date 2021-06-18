package rent.concurrency.barbershop;

public class BarberShop {
    public static void main(String[] args) {
        Hairdresser hairdresser = new Hairdresser();
        for (int i = 0; i < 10; i++) {
            new Client(hairdresser).start();
        }
        new ClientCreator(hairdresser, 5).start();
    }
}