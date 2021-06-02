package rent.repository;

import rent.model.Rent;

public class RentRepository extends AbstractRepository<Rent, Integer>{
    @Override
    protected String filePath() {
        return "src/main/resources/rent.out";
    }
}