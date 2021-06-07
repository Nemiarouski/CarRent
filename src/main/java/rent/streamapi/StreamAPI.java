package rent.streamapi;

import rent.model.IntegerWrapper;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // 1.1. Given list of User objects (firstName, lastName, age)
        // 1.2. Print list of unique firstNames where age is less than 30

        // 1.1.
/*        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Budko", 50));
        users.add(new User("Valentina", "Budko", 60));
        users.add(new User("Harry", "Potter", 10));
        users.add(new User("Draco", "Lucius", 15));
        users.add(new User("Ron", "Weasley", 20));
        users.add(new User("Ron", "Weasley", 20));
        users.add(new User("George", "Weasley", 30));
        users.add(new User("Adam", "Sandler", 36));

        // 1.2.
        //users.stream().filter(s -> s.getAge() < 30).forEach(user -> System.out.println(user.getFirstName()));
        //users.stream().filter(s -> s.getAge() < 30).distinct().forEach(user -> System.out.println(user.getFirstName()));
        users.stream().filter(s -> s.getAge() < 30).distinct().collect(Collectors.toList()).forEach(user -> System.out.println(user.getFirstName()));*/




        // 2.1. List of strings
        // 2.2. Sort them in descending order
        // 2.3. Show then as a single string, each value separated by "; "

        // 2.1.
/*        List<String> lannistersSlogan = new ArrayList<>();
        lannistersSlogan.add("Lannisters");
        lannistersSlogan.add("Always");
        lannistersSlogan.add("Pays");
        lannistersSlogan.add("Their");
        lannistersSlogan.add("Debts");

        //2.2. and 2.3.
        System.out.println(lannistersSlogan.stream().sorted((l1, l2) -> -l1.compareTo(l2)).collect(Collectors.joining(";")));*/

        // 3.1. List of integers
        // 3.2. Calculate sum of all values

/*        //3.1.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(30);
        numbers.add(5);
        numbers.add(-10);
        numbers.add(0);
        numbers.add(20);
        numbers.add(-15);
        //3.2.
        System.out.println(numbers.stream().mapToInt(n -> n).sum());*/


        // 4.1. The same as above, BUT
        // 4.2. Transform integers to IntegerWrapper objects at the first step
        // 4.3. as above, calculate IntegerWrapper which is a sum of all values (the following method could be added: IntegerWrapper.sum(IntegerWrapper value))

        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(30);
        numbers1.add(5);
        numbers1.add(-10);
        numbers1.add(0);
        numbers1.add(20);
        numbers1.add(-15);

        Stream<IntegerWrapper> stream = numbers1.stream().map(n -> new IntegerWrapper(n));
        List<IntegerWrapper> integerWrappers = stream.collect(Collectors.toList());

        integerWrappers.forEach(IntegerWrapper::sum);
        System.out.println();


        // 6.1. Given list of lists
        // 6.2. Print all the values using single Stream chain

/*        List<List<String>> listOfListsOfString = new ArrayList<>();

        List<String> string1 = Arrays.asList("1", "2", "3", "4", "5");
        List<String> string2 = Arrays.asList("Hello", "My", "Dear", "Friend");
        List<String> string3 = Arrays.asList("What is love", "baby don't hurt", "don't hurt me", "no more!");

        listOfListsOfString.add(string1);
        listOfListsOfString.add(string2);
        listOfListsOfString.add(string3);

        listOfListsOfString.stream().forEach(n -> System.out.println(n));*/
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

// 5.1. ...

// 6.1. Given list of lists
// 6.2. Print all the values using single Stream chain