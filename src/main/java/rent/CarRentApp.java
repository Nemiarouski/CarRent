package rent;

import rent.menu.Menu;
import rent.menu.MenuBuilder;

public class CarRentApp {
    public static void main(String[] args) {
        Menu menu = MenuBuilder.buildMainMenu();
        menu.onAction();
    }
}
