package rent.streamapi;

import rent.model.IntegerWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // 1.1. Given list of User objects (firstName, lastName, age)
        // 1.2. Print list of unique firstNames where age is less than 30

        // 1.1.
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Budko", 50));
        users.add(new User("Valentina", "Budko", 60));
        users.add(new User("Harry", "Potter", 10));
        users.add(new User("Draco", "Lucius", 15));
        users.add(new User("Ron", "Weasley", 20));
        users.add(new User("Ron", "Weasley", 20));
        users.add(new User("Ron", "Potter", 20));
        users.add(new User("George", "Weasley", 30));
        users.add(new User("Adam", "Sandler", 36));

        // 1.2.
        System.out.println("Result: ");
        users.stream().filter(s -> s.getAge() < 30).distinct().collect(Collectors.toList()).forEach(user -> System.out.println(user.getFirstName()));
        //users.stream().filter(s -> s.getAge() < 30).filter((s1,s2) -> s1.getLastName() != s2).distinct().collect(Collectors.toList()).forEach(user -> System.out.println(user.getFirstName()));

        //users.stream().filter(s -> s.getAge() < 30).filter((s1, s2) -> s1.getLastName().equals(s2 -> s2.));

        // 2.1. List of strings
        // 2.2. Sort them in descending order
        // 2.3. Show then as a single string, each value separated by "; "
        // 2.4. List of Users
        // 2.5. Sort them by age in descending order

        // 2.1.
        List<String> lannistersSlogan = new ArrayList<>();
        lannistersSlogan.add("Lannisters");
        lannistersSlogan.add("Always");
        lannistersSlogan.add("Pays");
        lannistersSlogan.add("Their");
        lannistersSlogan.add("Debts");

        //2.2. and 2.3.
        System.out.println("Lannisters slogan in reverse order:");
        System.out.println(lannistersSlogan.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(";")));
        System.out.println("");

        //2.4.
        List<User> users1 = new ArrayList<>();
        users1.add(new User("Ivan", "Budko", 50));
        users1.add(new User("Valentina", "Budko", 60));
        users1.add(new User("Harry", "Potter", 10));
        users1.add(new User("Draco", "Lucius", 15));
        users1.add(new User("Ron", "Weasley", 20));

        //2.5.
        System.out.println("Sort by age in descending order:");
        users1.stream().sorted(Comparator.comparing(User::getAge).reversed()).forEach(System.out::println);
        System.out.println("");

        // 3.1. List of integers
        // 3.2. Calculate sum of all values

        //3.1.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(30);
        numbers.add(5);
        numbers.add(-10);
        numbers.add(0);
        numbers.add(20);
        numbers.add(-15);
        //3.2.
        System.out.println("Sum of list numbers: ");
        System.out.println(numbers.stream().reduce((n1, n2) -> n1 + n2).orElse(0));
        System.out.println("");

        // 4.1. The same as above, BUT
        // 4.2. Transform integers to IntegerWrapper objects at the first step
        // 4.3. as above, calculate IntegerWrapper which is a sum of all values (the following method could be added: IntegerWrapper.sum(IntegerWrapper value))

        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(25);
        numbers1.add(5);
        numbers1.add(-10);
        numbers1.add(0);
        numbers1.add(20);
        numbers1.add(-15);

        List<IntegerWrapper> integerWrappers = numbers1.stream().map(IntegerWrapper::new).collect(Collectors.toList());
        int sum = 0;
        //sum = integerWrappers.forEach();

        //integerWrappers.stream().reduce((n1, n2) -> n1.getValue() + n2.getValue());
        //System.out.println(integerWrappers.forEach(IntegerWrapper::sum));

        // 5.1. Given list of users
        // 5.2. Extract age and transform to IntegerWrapper
        // 5.3. Return Map where key - IntegerWrapper.value, value - actual IntegerWrapper

        //5.1.
        List<User> users2 = new ArrayList<>();
        users2.add(new User("Ivan", "Budko", 50));
        users2.add(new User("Valentina", "Budko", 60));
        users2.add(new User("Harry", "Potter", 10));
        users2.add(new User("Draco", "Lucius", 15));
        users2.add(new User("Ron", "Weasley", 20));

        //5.2.
        //List<IntegerWrapper> ageTransormfList = users2.stream().map(n -> new IntegerWrapper(n.getAge()));



        // 6.1. Given list of lists
        // 6.2. Print all the values using single Stream chain

        List<List<String>> listOfListsOfString = new ArrayList<>();

        List<String> string1 = Arrays.asList("1", "2", "3", "4");
        List<String> string2 = Arrays.asList("Hello", "My", "Dear", "Friend");
        List<String> string3 = Arrays.asList("What is love", "baby don't hurt", "don't hurt me", "no more!");

        listOfListsOfString.add(string1);
        listOfListsOfString.add(string2);
        listOfListsOfString.add(string3);

        listOfListsOfString.stream().forEach(n -> new ArrayList<>(n).forEach(n1 -> System.out.print(n1 + " ")));

    }
}

// STREAM API
// 1.1. Given list of User objects (firstName, lastName, age)
// 1.2. Print list of unique firstNames where age is less than 30

// 2.1. List of strings
// 2.2. Sort them in descending order
// 2.3. Show then as a single string, each value separated by "; "

// 3.1. List of integers
// 3.2. Calculate sum of all values

// 4.1. The same as above, BUT
// 4.2. Transform integers to IntegerWrapper objects at the first step
// 4.3. as above, calculate IntegerWrapper which is a sum of all values (the following method could be added: IntegerWrapper.sum(IntegerWrapper value))

// 5.1. Given list of users
// 5.2. Extract age and transform to IntegerWrapper
// 5.3. Return Map where key - IntegerWrapper.value, value - actual IntegerWrapper

// 6.1. Given list of lists
// 6.2. Print all the values using single Stream chain