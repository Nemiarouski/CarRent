package rent.streamapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataTime {
    public static void main(String[] args) {
        taskThree();
        System.out.println();
        taskFour();
        System.out.println();
        taskFive();
    }

    //3. Вывести список пользователей, которые не логинились последние 5 дней
    public static void taskThree() {
        List<User> users = new ArrayList<>();
        users.add(new User("Harry", "Potter", 12,"2021-06-08 14:04:23"));
        users.add(new User("Harry", "Armstrong", 12,"2021-06-08 14:04:23"));
        users.add(new User("Harry", "Walker", 12,"2021-06-08 14:04:23"));
        users.add(new User("Ron", "Weasley", 13,"2021-06-07 11:24:23"));
        users.add(new User("Michel", "Jackson", 30,"2021-05-08 17:06:23"));
        users.add(new User("Bruce", "Willis", 50,"2021-04-12 10:14:23"));
        users.add(new User("Michel", "Obama", 32,"2021-03-08 19:54:23"));

        System.out.println("Users, who didn't login last 5 days.");
        users.stream()
                .filter(n -> n.getLastLogin()
                        .isBefore(LocalDateTime.now()
                                .minus(5, ChronoUnit.DAYS)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //4. Вывести пользователей, которые родились после 10 апреля 1995г.
    public static void taskFour() {
        List<User> users = new ArrayList<>();
        users.add(new User("Harry", "Potter", 12,"2021-06-08 14:04:23"));
        users.add(new User("Harry", "Armstrong", 12,"2021-06-08 14:04:23"));
        users.add(new User("Harry", "Walker", 12,"2021-06-08 14:04:23"));
        users.add(new User("Ron", "Weasley", 13,"2021-06-07 11:24:23"));
        users.add(new User("Michel", "Jackson", 30,"2021-05-08 17:06:23"));
        users.add(new User("Bruce", "Willis", 50,"2021-04-12 10:14:23"));
        users.add(new User("Michel", "Obama", 32,"2021-03-08 19:54:23"));

        System.out.println("Users, who were born after 10 April 1995");
        users.stream()
                .filter(n -> n.getBitrhDay()
                        .isAfter(LocalDate.of(1995,04,10)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //5. Отсортировать пользователей
    public static void taskFive() {
        List<User> users = new ArrayList<>();
        System.out.println("Sort users by birthday, firstName, lastName: ");
        users.add(new User("A", "A", 10,"2021-06-08 14:04:23"));
        users.add(new User("A", "AB", 10,"2021-06-08 14:04:23"));
        users.add(new User("A", "ABC", 10,"2021-06-08 14:04:23"));
        users.add(new User("A", "ABCD", 10,"2021-06-08 14:04:23"));

        users.stream()
                .sorted(new UserComparator())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nAnd show their birthdays: ");
        users.stream()
                .sorted(new UserComparator())
                .collect(Collectors.toList())
                .forEach(n -> System.out.println(n.getBitrhDay()));
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