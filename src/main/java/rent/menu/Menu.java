package rent.menu;

import rent.service.CarService;
import rent.service.ClientService;

import java.io.IOException;
import java.util.ArrayList;
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


    //                                //
    //         MAIN MENU PART         //
    //                                //


    public void mainMenu() throws IOException, ClassNotFoundException {
        System.out.println("");
        System.out.println("Choose the option:");
        System.out.println("1) Car menu");
        System.out.println("2) Client menu");
        System.out.println("3) Rent menu");
        System.out.println("4) Exit");

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                System.out.println("Car menu:");
                carMenu();
                break;
            case "2":
                System.out.println("Client menu:");
                clientMenu();
                break;
            case "3":
                System.out.println("Rent menu:");
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
        System.out.println("Choose the option:");
        System.out.println("1) Add new car");
        System.out.println("2) Delete car");
        System.out.println("3) Edit car");
        System.out.println("4) Show cars");
        System.out.println("5) Previous menu");
        System.out.println("6) Exit");

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                System.out.println("Add new car.");
                carService.addCar();
                carMenu();
                break;
            case "2":
                System.out.println("Delete car:");
                carService.deleteCar();
                carMenu();
                break;
            case "3":
                System.out.println("Edit car:");
                carService.editCar();
                carMenu();
                break;
            case "4":
                System.out.println("Show all cars:");
                carService.showCars();
                carMenu();
                break;
            case "5":
                System.out.println("Previous menu.");
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

    //                             //
    //         CLIENT PART         //
    //                             //

    public void clientMenu() throws IOException, ClassNotFoundException {
        List<String> menu = Arrays.asList("Add new client", "Delete client", "Edit client", "Show clients", "Previous menu", "Exit");
        System.out.println("Choose the option:");
        for (int i = 0; i < menu.size(); i++) { System.out.println(i + 1 + ") " + menu.get(i)); }

        /*System.out.println("Choose the option:");
        System.out.println("1) Add new client");
        System.out.println("2) Delete client");
        System.out.println("3) Edit client");
        System.out.println("4) Show clients");
        System.out.println("5) Previous menu");
        System.out.println("6) Exit");*/

        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1":
                System.out.println("Add new client.");
                clientService.addClient();
                clientMenu();
                break;
            case "2":
                System.out.println("Delete client:");
                clientService.deleteClient();
                clientMenu();
                break;
            case "3":
                System.out.println("Edit client:");
                clientService.editClient();
                clientMenu();
                break;
            case "4":
                System.out.println("Show all clients:");
                clientService.showClients();
                clientMenu();
                break;
            case "5":
                System.out.println("Previous menu.");
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