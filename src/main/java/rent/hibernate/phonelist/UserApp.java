package rent.hibernate.phonelist;

import rent.hibernate.phonelist.service.UserService;

public class UserApp {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.show();

        userService.readUser();
    }
}