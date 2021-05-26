package rent.menu;

import rent.model.Car;
import rent.model.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    public static void writeClients(List<Client> clients) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/clients.out");
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Client> readClients() {
        File file = new File("src/main/resources/clients.out");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream))
            {
                return (List<Client>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public static void writeCars(List<Car> cars) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/cars.out");
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCars() {
        File file = new File("src/main/resources/cars.out");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream))
            {
                return  (List<Car>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }
}