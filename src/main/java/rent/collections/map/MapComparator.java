package rent.collections.map;

import java.util.Comparator;

public class MapComparator implements Comparator<Key> {

    @Override
    public int compare(Key o1, Key o2) {
        return o1.getId().compareTo(o2.getId());
    }
}