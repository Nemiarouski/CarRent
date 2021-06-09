package rent.streamapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateTime {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Harry", "Potter", LocalDate.of(2009, 6, 9), LocalDateTime.of(2021, 6, 9, 10, 8, 23)));
        users.add(new User("Harry", "Pinterest", LocalDate.of(2009, 6, 9), LocalDateTime.of(2021, 6, 7, 14, 4, 23)));
        users.add(new User("Harry", "Walker", LocalDate.of(2009, 7, 12), LocalDateTime.of(2021, 5, 13, 17, 14, 23)));
        users.add(new User("Robert", "Pattinson", LocalDate.of(1986, 5, 13), LocalDateTime.of(2021, 4, 22, 19, 6, 23)));
        users.add(new User("Bruce", "Willis", LocalDate.of(1955, 3, 19), LocalDateTime.of(2021, 3, 19, 7, 44, 23)));
        users.add(new User("Michel", "Jackson", LocalDate.of(1958, 8, 29), LocalDateTime.of(2021, 2, 28, 13, 24, 23)));

        taskThree(users);
        System.out.println();
        taskFour(users);
        System.out.println();
        taskFive(users);
    }

    //3. Вывести список пользователей, которые не логинились последние 5 дней
    public static void taskThree(List<User> users) {
        System.out.println("Users, who didn't login last 5 days.");
        users.stream()
                .filter(n -> n.getLastLogin()
                        .isBefore(LocalDateTime.now()
                                .minusDays(5)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //4. Вывести пользователей, которые родились после 10 апреля 1995г.
    public static void taskFour(List<User> users) {
        System.out.println("Users, who were born after 10 April 1995");
        users.stream()
                .filter(n -> n.getBirthDay()
                        .isAfter(LocalDate.of(1995,4,10)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //5. Отсортировать пользователей
    public static void taskFive(List<User> users) {
        List<User> sortUsers = users.stream()
                .sorted(new UserComparator())
                .collect(Collectors.toList());

        System.out.println("Sort users by birthday, firstName, lastName: ");
        sortUsers.forEach(System.out::println);

        System.out.println("\nAnd show their birthdays: ");
        sortUsers.forEach(n -> System.out.println(n.getBirthDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }
}
/*
 1. Добавить юзеру дату рождения (без времени)                                   -> DONE
 2. Добавить юзеру дату последнего логина (со временем)                          -> DONE
 3. Вывести список пользователей, которые не логинились последние 5 дней         -> DONE
 4. Вывести пользователей, которые родились после 10 апреля 1995г                -> DONE
 5. Отсортировать пользователей по дате рождения,                                -> DONE
    если дата рождения одинаковая,
    по имени, если имя одинаковое,
    то по фамилии, и вывести их даты рождения
    в формате дд/мм гггг (дд - день, мм - месяц, гггг - год)
6. Вывести дату логина всех пользователей в
    часовом поясе CET (центральное европейское время)
    и CST (центральное американское время)
    в формате мм.дд.гггг чч:мм:сс
 */