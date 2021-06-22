package rent.concurrency.barbershop;

import java.util.concurrent.*;

public class BarberShopApp {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new ClientCreator(barbershop,6));

        service.submit(new Hairdresser("James", 1,7, barbershop));
        service.submit(new Hairdresser("Katie", 3,8, barbershop));
        service.submit(new Hairdresser("Amanda", 5,7, barbershop));
        service.submit(new Hairdresser("Robert", 1,5, barbershop));

        service.shutdown();
    }
}