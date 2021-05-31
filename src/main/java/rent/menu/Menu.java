package rent.menu;

import rent.service.CarService;
import rent.service.ClientService;
import rent.service.RentService;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CarService carService = new CarService();
    ClientService clientService = new ClientService();
    RentService rentService = new RentService();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();
    }
    //                          //
    //       MAIN MENU PART     //
    //                          //
    public void mainMenu() {
        List<String> menu = Arrays.asList("Car menu", "Client menu", "Rent menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                carMenu();
                break;
            case "2":
                clientMenu();
                break;
            case "3":
                rentMenu();
                break;
            case "4":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                mainMenu();
                break;
        }
    }
    //                          //
    //         CAR PART         //
    //                          //
    public void carMenu() {
        List<String> menu = Arrays.asList("Add new car", "Delete car", "Edit car", "Show cars", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                carService.create();
                carMenu();
                break;
            case "2":
                carService.delete();
                carMenu();
                break;
            case "3":
                carService.update();
                carMenu();
                break;
            case "4":
                carService.show();
                carMenu();
                break;
            case "5":
                mainMenu();
                break;
            case "6":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                carMenu();
                break;
        }
    }
    //                          //
    //        CLIENT PART       //
    //                          //
    public void clientMenu() {
        List<String> menu = Arrays.asList("Add new client", "Delete client", "Edit client", "Show clients", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                clientService.create();
                clientMenu();
                break;
            case "2":
                clientService.delete();
                clientMenu();
                break;
            case "3":
                clientService.update();
                clientMenu();
                break;
            case "4":
                clientService.show();
                clientMenu();
                break;
            case "5":
                mainMenu();
                break;
            case "6":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                clientMenu();
                break;
        }
    }
    //                          //
    //        RENT PART         //
    //                          //
    public void rentMenu() {
        List<String> menu = Arrays.asList("Show cars", "Show clients", "Rent car", "Delete car", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                rentService.showCars();
                rentMenu();
                break;
            case "2":
                rentService.showClients();
                rentMenu();
                break;
            case "3":
                rentService.rentCar();
                rentMenu();
                break;
            case "4":
                rentService.deleteCar();
                rentMenu();
                break;
            case "5":
                mainMenu();
                break;
            case "6":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                rentMenu();
                break;
        }
    }
}