package rent.menu;

import rent.model.Car;
import rent.model.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    private final static String CAR_PATH = "src/main/newTest/deleteThisDir/cars5.out";
    private final static String CLIENT_PATH = "src/main/resources/clients.out";

    public static void writeClients(List<Client> clients) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CLIENT_PATH);
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Client> readClients() {
        File file = new File(CLIENT_PATH);

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
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
        try (FileOutputStream fileOutputStream = new FileOutputStream(CAR_PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCars() {
        File file = new File(CAR_PATH);

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
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