package rent.menu;

import rent.service.CarService;
import rent.service.ClientService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CarService carService = new CarService();
    ClientService clientService = new ClientService();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        menu.mainMenu();
    }
    //                          //
    //       MAIN MENU PART     //
    //                          //
    public void mainMenu() throws IOException, ClassNotFoundException {
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
                System.out.println("in process...");
                mainMenu();
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
    public void carMenu() throws IOException, ClassNotFoundException {
        List<String> menu = Arrays.asList("Add new car", "Delete car", "Edit car", "Show cars", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                carService.addCar();
                carMenu();
                break;
            case "2":
                carService.deleteCar();
                carMenu();
                break;
            case "3":
                carService.editCar();
                carMenu();
                break;
            case "4":
                carService.showCars();
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
    public void clientMenu() throws IOException, ClassNotFoundException {
        List<String> menu = Arrays.asList("Add new client", "Delete client", "Edit client", "Show clients", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                clientService.addClient();
                clientMenu();
                break;
            case "2":
                clientService.deleteClient();
                clientMenu();
                break;
            case "3":
                clientService.editClient();
                clientMenu();
                break;
            case "4":
                clientService.showClients();
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
}