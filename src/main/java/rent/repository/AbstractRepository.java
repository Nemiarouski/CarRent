package rent.repository;

import rent.menu.Console;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository {
    abstract String filePath();
    abstract <E> List<E> deleteCondition(String choice);
    abstract <E> List<E> createCondition();
    abstract <E> Object updateConditionOne(String choice);
    abstract <E> List<E> updateConditionTwo(String choice);

    public <E> void update() {
        List<E> list = read();

        if (list.isEmpty()) {
            System.out.println("Nothing to edit.");
        } else {
            show(list);
            String choice = Console.read("Which number to edit?");
            if (updateConditionOne(choice) != null) {
                save(updateConditionTwo(choice));
            } else {
                System.out.println("You choose wrong number.");
            }
        }
    }

    public <E> void create() {
        List<E> list = read();
        list.addAll(createCondition());
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

    public <E> void save(List<E> list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath());
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <E> void show(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public <E> void showAll() {
        List<E> list = read();

        if (list.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            show(list);
        }
    }

    public <E> void delete() {
        List<E> list = read();

        if (list.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            show(list);
            String choice = Console.read("Which number to delete?");
            list.addAll(deleteCondition(choice));
            save(list);
        }
    }
}