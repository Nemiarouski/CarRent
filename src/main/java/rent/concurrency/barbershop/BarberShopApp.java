package rent.concurrency.barbershop;

public class BarberShopApp {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();

        new ClientCreator(barbershop, 6).start();

        new Hairdresser("James", 1,7, barbershop).start();
        new Hairdresser("Katie", 3,8, barbershop).start();
        new Hairdresser("Amanda", 5,7, barbershop).start();
        new Hairdresser("Robert", 1,12, barbershop).start();
    }
}