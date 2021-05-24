package rent.menu;

import rent.model.Car;
import rent.model.Client;

import java.io.*;

public class SerializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Car car = new Car(0, "Impala", "Black");
        Car car1 = new Car(1, "BMW", "Blue");

        Client client = new Client(0, "Roberto Cavalli", car.getId() + " " + car.getModel() + " " + car.getColour());
        Client client1 = new Client(1, "Margaret Mitchell", car1.getId() + " " + car1.getModel() + " " + car1.getColour());

        Serialization.write(client);
        Serialization.write(client1);

        System.out.println("Some magic");

        Client client2 = (Client) Serialization.read();
        System.out.println("Test client: " + client2.getId() + " Client name: " + client2.getName() + " Client car: " + client2.getCar());

        Client client3 = (Client) Serialization.read();
        System.out.println("Test client: " + client3.getId() + " Client name: " + client3.getName() + " Client car: " + client3.getCar());
    }
}