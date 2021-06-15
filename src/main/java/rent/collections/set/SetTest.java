package rent.collections.set;

import java.util.*;

public class SetTest {
    private static Set<User> hashSetStrings = new HashSet<>();
    private static Set<User> treeSetStrings = new TreeSet<>(new SetComparator());
    private static Set<User> linkedHashSet = new LinkedHashSet<>();

    public static void init(Set<User> set) {
        set.add(new User("Alex"));
        set.add(new User("Margo"));
        set.add(new User("Steven"));
        set.add(new User("Robert"));
        set.add(new User("Alex"));
    }

    public static void out(Set<User> set) {
        set.forEach(System.out::println);
    }

    public static void main(String[] args) {
        init(hashSetStrings);
        init(treeSetStrings);
        init(linkedHashSet);

        System.out.println("LinkedHashSet");
        out(linkedHashSet);
        System.out.println("\nHashSet");
        out(hashSetStrings);
        System.out.println("\nTreeSet");
        out(treeSetStrings);
    }
}