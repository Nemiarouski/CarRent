package rent.hibernate.phonelist.service;

import rent.hibernate.phonelist.dao.UserDao;
import rent.hibernate.phonelist.entity.User;
import rent.hibernate.phonelist.utils.Console;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public void createUser() {
        System.out.println("Input user's name:");
        String name = Console.read();
        System.out.println("Input user's phone:");
        String phone = Console.read();
        userDao.create(new User(name, phone));
    }

    public User readUser() {
        System.out.println("Input user's number:");
        int choice = Integer.parseInt(Console.read());
        return userDao.read(choice);
    }

    public void updateUser() {
        System.out.println("Input user's number to update:");
        int choice = Integer.parseInt(Console.read());
        User user = userDao.read(choice);

        System.out.println("Input user's name:");
        String name = Console.read();
        System.out.println("Input user's phone:");
        String phone = Console.read();

        user.setName(name);
        user.setPhone(phone);

        userDao.update(user);
    }

    public void deleteUser() {
        System.out.println("Input user's number to update:");
        int choice = Integer.parseInt(Console.read());
        User user = userDao.read(choice);
        userDao.delete(user);
    }

    public void show() {
        List<User> users = userDao.show();

        if (users != null && !users.isEmpty()) {
            for (User user: users) {
                System.out.println(user.toString());
            }
        }
    }
}