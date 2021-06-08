package rent.streamapi;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getBitrhDay() != o2.getBitrhDay()) {
            return o1.getAge() - o2.getAge();
        } else if (!o1.getFirstName().equals(o2.getFirstName())) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        } else {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
}
