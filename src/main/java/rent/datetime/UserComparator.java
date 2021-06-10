package rent.datetime;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        if (!u1.getBirthDay().equals(u2.getBirthDay())) {
            return u2.getBirthDay().compareTo(u1.getBirthDay());
        } else if (!u2.getFirstName().equals(u1.getFirstName())) {
            return u2.getFirstName().compareTo(u1.getFirstName());
        } else if (!u1.getLastName().equals(u2.getLastName())) {
            return u1.getLastName().compareTo(u2.getLastName());
        }
        return 0;
    }
}