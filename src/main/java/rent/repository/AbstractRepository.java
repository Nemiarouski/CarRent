package rent.repository;

import java.io.*;
import java.util.*;

public abstract class AbstractRepository<T extends IdentifiableEntity<E>, E extends Comparable<E>> {
    protected abstract String filePath();

    public T findById(E id) {
        List<T> list = read();
        T t = list.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);
        return t;
    }

    public void saveOrUpdate(T t) {
        List<T> list = read();
        list.removeIf(t1 -> t1.getId().equals(t.getId()));
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
            list.sort(Comparator.comparing(l -> l.getId()));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}