package rent.menu;

public class NoActionMenu implements Menu {
    private final String name;

    public NoActionMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onAction() {
    }
}
