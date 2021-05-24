package rent.menu;

import rent.model.Client;
import java.io.*;

public class Serialization {

    public static void write(Client client) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("test.out", true); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(client);
            oos.flush();
        } finally {
            System.out.println("Write method close.");
        }
    }

    public static Client read() throws IOException, ClassNotFoundException {
        try(FileInputStream fis = new FileInputStream("test.out"); ObjectInputStream oin = new ObjectInputStream(fis)) {
            Client client = (Client) oin.readObject();
            return client;
        }
    }
}