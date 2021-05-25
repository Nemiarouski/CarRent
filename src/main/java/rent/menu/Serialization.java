package rent.menu;

import rent.model.Car;
import rent.model.Client;
import java.io.*;
import java.util.List;

public class Serialization {

    public static void write(List<Client> clients) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/clients.out");
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
        }
    }

    public static List<Client> read() throws IOException, ClassNotFoundException {
        List<Client> desClients;
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/clients.out");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream))
        {
            desClients = (List<Client>) ois.readObject();
        }
        return desClients;
    }

    public static void writeCars(List<Car> cars) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/cars.out");
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(cars);
        }
    }

    public static List<Car> readCars() throws IOException, ClassNotFoundException {
        List<Car> desCars;
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/cars.out");
             ObjectInputStream ois = new ObjectInputStream(fileInputStream))
        {
            desCars = (List<Car>) ois.readObject();
        }
        return desCars;
    }
}