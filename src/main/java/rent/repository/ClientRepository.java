package rent.repository;

import rent.model.Client;

public class ClientRepository extends AbstractRepository<Client, String>{
    @Override
    public String filePath() {
        return "src/main/resources/clients.out";
    }
}