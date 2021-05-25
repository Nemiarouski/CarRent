package rent.model;

import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Car car;

    public Client() {
    }
    public Client(int id, String name, Car car) {
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + car;
    }
}