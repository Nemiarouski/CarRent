package rent.menu;

import rent.model.Car;
import rent.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Client> clients = new ArrayList<>();

        clients.add(new Client(0, "Roberto Cavalli", "Impala Black"));
        clients.add(new Client(1, "George IV", "Horse White"));

        Serialization.write(clients);

        List<Client> desClients;


        desClients = Serialization.read();

        for (Client client : desClients) {
            System.out.println("Client id: " + client.getId() + ", Client name: " + client.getName() +
                    ", Client car: " + client.getCar());
        }

    }
}