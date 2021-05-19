package rent.menu;

public class MenuBuilder {
    public static Menu buildMainMenu() {
        return new ListMenu(
                "Main menu",
                new ListMenu("Client menu",
                        new ListMenu("Premium client",
                                new NoActionMenu("Action 1"),
                                new NoActionMenu("Action 2")
                        ),
                        new ListMenu("Just client...",
                                new NoActionMenu("Another action 1"),
                                new NoActionMenu("Another action 2")
                        )
                ),
                new RentMenu(),
                new NoActionMenu("Exit")
        );
    }
}