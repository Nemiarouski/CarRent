package rent.model;

import rent.repository.IdentifiableEntity;

import java.io.Serializable;

public class Rent implements IdentifiableEntity, Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Car car;
    private Client client;
    private boolean rent;

    public Rent() {
    }
    public Rent(int id, Car car, Client client, boolean rent) {
        this.id = id;
        this.car = car;
        this.client = client;
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }
}