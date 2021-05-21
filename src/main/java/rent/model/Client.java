package rent.model;

public class Client {
    private int id;
    private String name;
    private String car;

    public Client() {
    }
    public Client(int id, String name, String car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + car;
    }
}