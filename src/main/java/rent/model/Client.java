package rent.model;

public class Client {
    private int id;
    private String fullName;
    private Car car;

    public Client() {
    }
    public Client(int id, String fullName, Car car) {
        this.id = id;
        this.fullName = fullName;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", car=" + car +
                '}';
    }
}