package rent.menu;

import rent.model.Client;
import java.io.*;
import java.util.List;

public class Serialization {

    public static void write(List<Client> clients) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.out");
                ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(clients);
            System.out.println("List has been written");
        }
    }
    public static List<Client> read() throws IOException, ClassNotFoundException {
        List<Client> desClients;
        try (FileInputStream fileInputStream = new FileInputStream("test.out");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream))
        {
            desClients = (List<Client>) ois.readObject();
        }
        return desClients;
    }
}