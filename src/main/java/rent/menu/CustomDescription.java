package rent.menu;

public class CustomDescription {
    private final String description;
    private final String secondDescription;

    public CustomDescription(String description, String secondDescription) {
        this.description = description;
        this.secondDescription = secondDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getSecondDescription() {
        return secondDescription;
    }
}