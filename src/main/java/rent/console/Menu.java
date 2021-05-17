package rent.console;

import rent.model.Car;
import rent.model.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    List<Car> cars = new ArrayList<>();
    List<Client> clients = new ArrayList<Client>();
    int CAR_ID = 0;
    int CLIENT_ID = 0;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();
    }


    //                                //
    //         MAIN MENU PART         //
    //                                //


    public void mainMenu() {
        System.out.println("");
        System.out.println("Choose the option:");
        System.out.println("1) Information about cars and clients");
        System.out.println("2) Rent menu");
        System.out.println("3) Exit");

        String name = scanner.nextLine();

        switch (name) {
            case "1":
                System.out.println("Information about cars and clients:");
                carAndClientMenu();
                break;
            case "2":
                System.out.println("Rent menu:");
                System.out.println("in process...");
                System.out.println("");
                mainMenu();
                //Rent part
                break;
            case "3":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                mainMenu();
                break;
        }
    }

    public void carAndClientMenu() {
        System.out.println("Choose the option:");
        System.out.println("1) Car menu");
        System.out.println("2) Client menu");
        System.out.println("3) Previous menu");
        System.out.println("4) Exit");

        String name = scanner.nextLine();

        switch (name) {
            case "1":
                System.out.println("Car menu:");
                carMenu();
                break;
            case "2":
                System.out.println("Client menu:");
                clientMenu();
                break;
            case "3":
                System.out.println("Previous menu.");
                mainMenu();
                break;
            case "4":
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("You choose wrong option. Try again.");
                carAndClientMenu();
                break;
        }
    }


    //                          //
    //         CAR PART         //
    //                          //


    public void carMenu() {
        System.out.println("Choose the option:");
        System.out.println("1) Add new car");
        System.out.println("2) Delete car");
        System.out.println("3) Edit car");
        System.out.println("4) Show cars");
        System.out.println("5) Previous menu");
        System.out.println("6) Exit");

        String name = scanner.nextLine();

        switch (name) {
            case "1":
                System.out.println("Add new car.");
                addCar();
                carMenu();
                break;
            case "2":
                System.out.println("Delete car:");
                deleteCar();
                carMenu();
                break;
            case "3":
                System.out.println("Edit car:");
                editCar();
                carMenu();
                break;
            case "4":
                System.out.println("Show all cars:");
                showCars();
                carMenu();
                break;
            case "5":
                System.out.println("Previous menu.");
                carAndClientMenu();
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

    public void addCar() {
        Car car = new Car();
        car.setId(CAR_ID++);

        System.out.println("You need to enter some information:");

        System.out.println("Input car model:");
        String name = scanner.nextLine();
        car.setModel(name);

        System.out.println("Input car colour:");
        String name1 = scanner.nextLine();
        car.setColour(name1);

        System.out.println("Great!");
        cars.add(car);
        System.out.println("");
    }

    public void deleteCar() {
        System.out.println(cars.toString());
        System.out.println("Which car do you want to delete?");

        String name = scanner.nextLine();

        int i = Integer.parseInt(name);
        cars.removeIf(car -> car.getId() == i);
        System.out.println("");
    }

    public void editCar() {
        System.out.println(cars.toString());
        System.out.println("Which car do you want to edit?");

        String name = scanner.nextLine();
        int i = Integer.parseInt(name);

        System.out.println("Input car model:");
        String name1 = scanner.nextLine();
        cars.get(i).setModel(name1);

        System.out.println("Input car colour:");
        String name2 = scanner.nextLine();
        cars.get(i).setColour(name2);
        System.out.println("");

    }

    public void showCars() {
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println("");
    }


    //                       //
    //      CLIENT PART      //
    //                       //


    public void clientMenu() {
        System.out.println("");
        System.out.println("Choose the option:");
        System.out.println("1) Add new client");
        System.out.println("2) Delete client");
        System.out.println("3) Edit client");
        System.out.println("4) Show clients");
        System.out.println("5) Previous menu");
        System.out.println("6) Exit");

        String name = scanner.nextLine();

        switch (name) {
            case "1":
                System.out.println("Add new client.");
                addClient();
                clientMenu();
                break;
            case "2":
                System.out.println("Delete client:");
                deleteClient();
                clientMenu();
                break;
            case "3":
                System.out.println("Edit client:");
                editClient();
                clientMenu();
                break;
            case "4":
                System.out.println("Show all clients:");
                showClients();
                clientMenu();
                break;
            case "5":
                System.out.println("Previous menu.");
                carAndClientMenu();
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

    public void addClient() {
        Client client = new Client();
        client.setId(CLIENT_ID++);

        System.out.println("You need to enter some information:");

        System.out.println("Input full name:");
        String name1 = scanner.nextLine();
        client.setFullName(name1);

        System.out.println("Great!");
        clients.add(client);
        System.out.println("");
    }

    public void deleteClient() {
        System.out.println(clients.toString());
        System.out.println("Which client do you want to delete?");

        String name = scanner.nextLine();

        int i = Integer.parseInt(name);
        clients.removeIf(client -> client.getId() == i);
        System.out.println("");
    }

    public void editClient() {
        System.out.println(clients.toString());
        System.out.println("Which client do you want to edit?");

        String name = scanner.nextLine();
        int i = Integer.parseInt(name);

        System.out.println("Input client full name:");
        String name1 = scanner.nextLine();
        clients.get(i).setFullName(name1);
        System.out.println("");

    }

    public void showClients() {
        for (Client client: clients) {
            System.out.println(client);
        }
        System.out.println("");
    }
}