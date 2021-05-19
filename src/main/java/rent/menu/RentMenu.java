package rent.menu;

public class RentMenu extends ListMenu {
    public RentMenu() {
        super("Rent menu",
                new NoActionMenu("Add rent"),
                new NoActionMenu("Edit rent"),
                new NoActionMenu("Exit")
        );
    }
}
