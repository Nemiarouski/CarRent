package rent.model;

import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id = 0;
    private String model;
    private String colour;

    public Car() {
    }
    public Car(int id, String model, String colour) {
        this.id = id;
        this.model = model;
        this.colour = colour;
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

    @Override
    public String toString() {
        return id + " " + model + " " + colour;
    }
}