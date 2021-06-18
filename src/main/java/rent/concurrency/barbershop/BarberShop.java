package rent.concurrency.barbershop;

import java.util.ArrayList;
import java.util.List;

public class BarberShop {
    public static void main(String[] args) {
        List<Hairdresser> hairdressers = new ArrayList<>();
        hairdressers.add(new Hairdresser("Bruce", 1,8));
        hairdressers.add(new Hairdresser( "Amanda",1,3));
        hairdressers.add(new Hairdresser("Kate",1,4));
        hairdressers.add(new Hairdresser("Roberto",1,5));

        for (int i = 0; i < 10; i++) {
            new ClientCreator(hairdressers, 1).start();
        }
    }
}