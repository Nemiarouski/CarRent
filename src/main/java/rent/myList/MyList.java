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
    public void contains(Object o) {
        for (T iw : list) {
            if (iw.equals(o)) {
                System.out.println("Same elements.");
            } else {
                System.out.println("No one same elements.");
            }
        }
    }
}