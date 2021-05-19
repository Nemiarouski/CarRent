package rent.menu;

import rent.console.InputReader;
import rent.console.Logger;

import java.util.List;

public class ListMenu implements Menu {
    private final String name;
    private final List<Menu> items;

    public ListMenu(String name, Menu... items) {
        this.name = name;
        this.items = List.of(items);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onAction() {
        showItems();
        String input = waitForUserInput();
        selectItem(input);
    }

    private String waitForUserInput() {
        return InputReader.getInstance().waitForInput();
    }

    private void showItems() {
        for (Menu item : items) {
            showItem(item);
        }
    }

    private void showItem(Menu item) {
        Logger.getInstance().log((items.indexOf(item) + 1) + ") " + item.getName());
    }

    private void selectItem(String input) {
        int index = Integer.parseInt(input) - 1;
        Menu item = items.get(index);
        item.onAction();
    }
}
