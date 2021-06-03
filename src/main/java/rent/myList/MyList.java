package rent.myList;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements MyCollectionInterface<T>{
    List<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }
}