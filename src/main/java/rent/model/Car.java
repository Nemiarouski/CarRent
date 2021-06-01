package rent.model;

import rent.repository.IdentifiableEntity;

import java.io.Serializable;

public class Car implements IdentifiableEntity, Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String model;
    private String colour;
    private boolean rent;

    public Car() {
    }
    public Car(int id, String model, String colour, boolean rent) {
        this.id = id;
        this.model = model;
        this.colour = colour;
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return id + " " + model + " " + colour;
    }
}