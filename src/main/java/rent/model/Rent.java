package rent.model;

import rent.repository.IdentifiableEntity;

import java.io.Serializable;

public class Rent implements IdentifiableEntity<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Car car;
    private Client client;
    private boolean rent;

    public Rent() {
    }
    public Rent(Integer id, Car car, Client client, boolean rent) {
        this.id = id;
        this.car = car;
        this.client = client;
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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