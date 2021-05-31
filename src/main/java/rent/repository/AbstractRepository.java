package rent.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {
    abstract String filePath();
    abstract void showCondition();

    public void create(T t) {
        List<T> list = read();
        list.add(t);
        save(list);
    }

    public List<T> read() {
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
                return (List<T>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    public void save(List<T> list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath());
             ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        if (read().isEmpty()) {
            System.out.println("Empty list.");
        } else {
            showCondition();
        }
    }
}