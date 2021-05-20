package rent.menu;

import rent.model.Car;
import rent.model.Client;
import rent.service.CarService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    CarService carService = new CarService();
    Scanner scanner = new Scanner(System.in);
    List<Car> cars = new ArrayList<>();
    List<Client> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.mainMenu();
    }


    //                                //
    //         MAIN MENU PART         //
    //                                //


    public void mainMenu() throws IOException {
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
                System.out.println("in process...");
                //clientMenu();
                mainMenu();
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


    public void carMenu() throws IOException {
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

    public void deleteCar() throws IOException {
        carService.showCars();
        System.out.println(cars.toString());
        System.out.println("Which car do you want to delete?");

        String name = scanner.nextLine();

        int i = Integer.parseInt(name);
        cars.removeIf(car -> car.getId() == i);
        System.out.println("");
    }

    public void editCar() {
        showCars();
        System.out.println("Which car do you want to edit?");

        String name = scanner.nextLine();
        int i = Integer.parseInt(name);

        System.out.println("Input car model:");
        String model = scanner.nextLine();
        cars.get(i).setModel(model);

        System.out.println("Input car colour:");
        String colour = scanner.nextLine();
        cars.get(i).setColour(colour);
    }

    public void showCars() {
/*        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println("----------");*/
        try {
            carService.showCars();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}