package rent.task;

import rent.model.Client;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private final static String PATH = "src/main/java/rent/task/test5.txt";

    public static void main(String[] args) {
        writeClients();
        readClients();
    }

    public static void writeClients() {
        List<Client> clients = new ArrayList<>();
        Client client = new Client(0, "Vasia", null);
        Client client1 = new Client(1, "Kolia", null);
        clients.add(client);
        clients.add(client1);

        Path path = Paths.get(PATH);

        try {
            Files.write(path, Collections.singleton(clients.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> readClients() {
        Charset charset = Charset.forName("UTF-8");
        List<String> clients = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(PATH), charset);
            for (String line : lines) {
                System.out.println(line);
                clients.add(line);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return clients;
    }
}