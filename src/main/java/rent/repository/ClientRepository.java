package rent.repository;

import rent.menu.ConsoleReader;
import rent.menu.ReadFromFile;
import rent.menu.WriteToFile;
import rent.model.Client;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    File file = new File("src/main/resources/clients.txt");

    public void addClient() throws IOException {
        Client client = new Client();
        System.out.println("You need to enter information about client:");

        client.setId(0);
        client.setName(ConsoleReader.read("Input client client name:"));
        client.setCar(ConsoleReader.read("Input car model:"));

        WriteToFile.writeAppend(file, client);
    }

    public void deleteClient() throws IOException {
        List<Client> testClientArray = readClients();

        showClients();

        if (readClients() != null) {
            int i = Integer.parseInt(ConsoleReader.read("Which client do you want to delete?"));
            testClientArray.removeIf(client -> client.getId() == i);

            WriteToFile.write(file, "");
            for (Client client : testClientArray) {
                WriteToFile.writeAppend(file, client.toString());
            }
        } else {
            System.out.println("Create client, bro!");
        }
    }

    public void editClient() throws IOException {
        List<Client> testClientArray = readClients();
        showClients();

        if (readClients() != null) {
            int i = Integer.parseInt(ConsoleReader.read("Which client do you want to edit?"));


            testClientArray.get(i).setName(ConsoleReader.read("Input client name:"));
            testClientArray.get(i).setCar(ConsoleReader.read("Input car model:"));

            WriteToFile.write(file, "");
            for (Client client : testClientArray) {
                WriteToFile.writeAppend(file, client.toString());
            }
        } else {
            System.out.println("Create client, bro!");
        }
    }

    public void showClients() throws IOException {

        if (readClients() != null) {
            for (Client client : readClients()) {
                System.out.println("Client id: " + client.getId() + ", Client name: " + client.getName() + ", Car: " + client.getCar());
            }
        } else {
            System.out.println("You need to create a client before showing.");
            System.out.println();
        }
    }

    public List<Client> readClients() throws IOException {
        List<Client> testClientArray = new ArrayList<>();

        String allClientsInOneString = ReadFromFile.read(file);  //Read from file

        if (allClientsInOneString.equals("")) {
            System.out.println("Client list is empty");
        } else {
            String[] clientArray = allClientsInOneString.split("\n"); // Create array of '0 Kia Red' and etc.

            for (int i = 0; i < clientArray.length; i++) {

                String[] newClient = clientArray[i].split(" ");

                String name = newClient[1];
                String car = newClient[2];

                testClientArray.add(new Client(i, name, car));
            }
            return testClientArray;
        }
        return null;
    }
}