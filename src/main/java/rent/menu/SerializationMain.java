package rent.menu;

import rent.model.Client;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Client> clients = new ArrayList<>();
        List<Client> desClients;

        clients.add(new Client(0, "Roberto Cavalli", "Impala Black"));
        clients.add(new Client(1, "George IV", "Horse White"));

        Serialization.write(clients);

        desClients = Serialization.read();

        for (Client client : desClients) {
            System.out.println("Client id: " + client.getId() + ", Client name: " + client.getName() +
                    ", Client car: " + client.getCar());
        }

        System.out.println("");
        System.out.println("After adding new client:");

        clients.add(new Client(2, "Michel Jackson", "Jeep White"));

        Serialization.write(clients);
        desClients = Serialization.read();

        for (Client client : desClients) {
            System.out.println("Client id: " + client.getId() + ", Client name: " + client.getName() +
                    ", Client car: " + client.getCar());
        }
    }
}