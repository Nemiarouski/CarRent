package rent.streamapi;

import rent.model.IntegerWrapper;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
    }

    // 1.1. Given list of User objects (firstName, lastName, age)
    // 1.2. Print list of unique firstNames where age is less than 30
    private static void taskOne() {
        //1.1.
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
        //1.2.
        System.out.println("Result: ");
        //users.stream().filter(s -> s.getAge() < 30).distinct().collect(Collectors.toList()).forEach(user -> System.out.println(user.getFirstName()));

        users.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toSet())
                .forEach(n -> System.out.println(n.getFirstName()));

        System.out.println("");

        Map<String, Integer> result = users.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toMap(p -> p.getFirstName(), n -> n.getAge(), (item, identicalItem) -> item));
        System.out.println(result);

        System.out.println("");
    }

    // 2.1. List of strings
    // 2.2. Sort them in descending order
    // 2.3. Show then as a single string, each value separated by "; "
    // 2.4. List of Users
    // 2.5. Sort them by age in descending order
    private static void taskTwo() {
        // 2.1.
        List<String> lannistersSlogan = new ArrayList<>();
        lannistersSlogan.add("Lannisters");
        lannistersSlogan.add("Always");
        lannistersSlogan.add("Pays");
        lannistersSlogan.add("Their");
        lannistersSlogan.add("Debts");
        //2.2. and 2.3.
        System.out.println("Lannisters slogan in reverse order:");
        String result = lannistersSlogan
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(";"));
        System.out.println(result);
        System.out.println("");
        //2.4.
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Budko", 50));
        users.add(new User("Valentina", "Budko", 60));
        users.add(new User("Harry", "Potter", 10));
        users.add(new User("Draco", "Lucius", 15));
        users.add(new User("Ron", "Weasley", 20));
        //2.5.
        System.out.println("Sort by age in descending order:");
        users
                .stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("Sort by age in descending order with Comparator:");
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        users.sort(comparator.reversed());
        users.forEach(System.out::println);
        System.out.println("");
    }

    // 3.1. List of integers
    // 3.2. Calculate sum of all values
    private static void taskThree() {
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
        int result = numbers
                .stream()
                .reduce((n1, n2) -> n1 + n2)
                .orElse(0);
        System.out.println(result);
        System.out.println("");
    }

    // 4.1. The same as above, BUT
    // 4.2. Transform integers to IntegerWrapper objects at the first step
    // 4.3. as above, calculate IntegerWrapper which is a sum of all values (the following method could be added: IntegerWrapper.sum(IntegerWrapper value))
    private static void taskFour() {
        //4.1.
        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(25);
        numbers1.add(5);
        numbers1.add(-10);
        numbers1.add(0);
        numbers1.add(20);
        numbers1.add(-15);
        numbers1.add(100);
        numbers1.add(-55);
        //4.2.
        Optional<IntegerWrapper> wrapper = numbers1
                .stream()
                .map(IntegerWrapper::new)
                .reduce((n1, n2) -> n1.sum(n2));
        //4.3.
        wrapper.ifPresent(n -> System.out.println("Your sum is: " + n.getValue()));
        System.out.println("");
    }

    // 5.1. Given list of users
    // 5.2. Extract age and transform to IntegerWrapper
    // 5.3. Return Map where key - IntegerWrapper.value, value - actual IntegerWrapper
    private static void taskFive() {
        //5.1.
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Budko", 50));
        users.add(new User("Valentina", "Budko", 60));
        users.add(new User("Harry", "Potter", 10));
        users.add(new User("Draco", "Lucius", 15));
        users.add(new User("Ron", "Weasley", 20));
        //5.2.
        Map<Integer, IntegerWrapper> map = users.stream()
                .map(n -> new IntegerWrapper(n.getAge()))
                .collect(Collectors.toMap(IntegerWrapper::getValue, Function.identity()));
        System.out.println(map);
        System.out.println("");
    }

    // 6.1. Given list of lists
    // 6.2. Print all the values using single Stream chain
    private static void taskSix() {
        //6.1.
        List<List<String>> listOfListsOfString = new ArrayList<>();
        List<String> string1 = Arrays.asList("1", "2", "3", "4");
        List<String> string2 = Arrays.asList("Hello", "My", "Dear", "Friend");
        List<String> string3 = Arrays.asList("What is love", "baby don't hurt", "don't hurt me", "no more!");
        listOfListsOfString.add(string1);
        listOfListsOfString.add(string2);
        listOfListsOfString.add(string3);
        //6.2.
        listOfListsOfString.stream()
                .flatMap(List<String>::stream)
                .forEach(n1 -> System.out.print(n1 + " "));
    }
}