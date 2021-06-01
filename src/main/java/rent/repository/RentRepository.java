package rent.repository;

public class RentRepository extends AbstractRepository{
    @Override
    protected String filePath() {
        return "src/main/resources/rent.out";
    }
}