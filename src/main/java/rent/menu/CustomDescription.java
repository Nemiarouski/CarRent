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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDescription customDescription = (CustomDescription) o;
        return description.equals(customDescription.description) && secondDescription.equals(customDescription.secondDescription);
    }
}