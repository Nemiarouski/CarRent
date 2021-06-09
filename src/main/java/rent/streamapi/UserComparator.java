package rent.streamapi;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        if (!u1.getBitrhDay().equals(u2.getBitrhDay())) {
            return u2.getBitrhDay().compareTo(u1.getBitrhDay());
        } else if (u2.getBitrhDay().equals(u1.getBitrhDay()) && !u2.getFirstName().equals(u1.getFirstName())) {
            return u2.getFirstName().compareTo(u1.getFirstName());
        } else if (u1.getBitrhDay().equals(u2.getBitrhDay()) && u1.getFirstName().equals(u2.getFirstName()) && !u1.getLastName().equals(u2.getLastName())) {
            return u1.getLastName().compareTo(u2.getLastName());
        }
        return 0;
    }
}