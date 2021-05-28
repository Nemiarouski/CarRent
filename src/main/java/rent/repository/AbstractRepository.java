package rent.repository;

import rent.menu.Console;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository {
    abstract String filePath();
    abstract <E> List<E> createCondition();
    abstract void updateCondition(String choice);
    abstract <E> List<E> deleteCondition(String choice);
    abstract void showCondition();

    public <E> void create() {
        List<E> list = createCondition();
        save(list);
    }

    public <E> List<E> read() {
        File file = new File(filePath());

        if (!file.exists()) {
            try {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() > 0) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fileInputStream))
            {
                return (List<E>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public <E> void update() {
        List<E> list = read();

        if (!list.isEmpty()) {
            show();
            String choice = Console.read("Which number to edit?");
            updateCondition(choice);
        } else {
            System.out.println("Nothing to edit.");
        }
    }

    public <E> void delete() {
        List<E> list = read();

        if (!list.isEmpty()) {
            show();
            String choice = Console.read("Which number to delete?");
            list = deleteCondition(choice);
            save(list);
        } else {
            System.out.println("Empty list.");
        }
    }

    public <E> void save(List<E> list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath());
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        showCondition();
    }

    public void showAll() {
        if (read().isEmpty()) {
            System.out.println("Empty list.");
        } else {
            show();
        }
    }
}