package rent.concurrency.barbershop;

public class BarberShopApp {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();

        new ClientCreator(barbershop, 6).start();

        new Thread(new Hairdresser("James", 1,7, barbershop)).start();
        new Thread(new Hairdresser("Katie", 3,8, barbershop)).start();
        new Thread(new Hairdresser("Amanda", 5,7, barbershop)).start();
        new Thread(new Hairdresser("Robert", 1,12, barbershop)).start();
    }
}