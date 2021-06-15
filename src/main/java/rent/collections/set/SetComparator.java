package rent.collections.set;

import java.util.Comparator;

public class SetComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}