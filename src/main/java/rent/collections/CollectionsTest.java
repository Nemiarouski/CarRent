package rent.collections;

import java.util.*;

public class CollectionsTest {
    private static List<Integer> listOfIntegers = new ArrayList<>();
    private static Deque<String> dequeOfIntegers = new ArrayDeque<>();
    private static List<String> linkedListOfStrings = new LinkedList<>();
    private static Set<Integer> setOfIntegers = new HashSet<>();
    private static Map<Integer, Integer> mapOfIntegers = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(listOf());
    }

    public static int listOf() {
        System.out.println("List Collection:");
        listOfIntegers.add(1);
        listOfIntegers.add(5);
        listOfIntegers.add(-17);
        listOfIntegers.add(8);
        listOfIntegers.add(4);
        listOfIntegers.sort(Comparator.comparingInt(o -> o));
        int sum = listOfIntegers.stream().reduce(Integer::sum).get();
        return sum;
    }

    public void dequeOf() {
        System.out.println("\nQueue Collection:");
        dequeOfIntegers.add("Germany");
        dequeOfIntegers.addFirst("France");
        dequeOfIntegers.push("Great Britain");
        dequeOfIntegers.addLast("Spain");
        dequeOfIntegers.add("Italy");
        while (dequeOfIntegers.peek() != null) {
            System.out.println(dequeOfIntegers.pop());
        }
    }

    public void linkedListOf() {
        System.out.println("\nLinkedList Collection");
        linkedListOfStrings.add("F");
        linkedListOfStrings.add("B");
        linkedListOfStrings.add("D");
        linkedListOfStrings.add("E");
        linkedListOfStrings.add("C");
        linkedListOfStrings.add(null);
        linkedListOfStrings.add(1, "A2");
        System.out.println("Содержимое: " + linkedListOfStrings);
    }

}