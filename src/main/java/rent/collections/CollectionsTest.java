package rent.collections;

import java.util.*;

public class CollectionsTest {
    private static List<Integer> listOfIntegers = new ArrayList<>();
    private static ArrayDeque<String> dequeOfIntegers = new ArrayDeque<>();
    private static List<String> linkedListOfStrings = new LinkedList<>();
    private static Set<Integer> setOfIntegers = new HashSet<>();
    private static Map<Integer, Integer> mapOfIntegers = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("\nTesting difference between Arrays.asList and List.of");
        List<Integer> integerList = Arrays.asList(5,6,1,4,6,7,9);
        List<Integer> integerList1 = List.of(1,4,8,0,2,123,5);
        System.out.println("First element before: " + integerList.get(0));
        integerList.set(0, 3);
        System.out.println("First element after: " + integerList.get(0));
        //System.out.println(integerList1.set(0, 25));
        System.out.println();

        System.out.println("List Collection:");
        listOfIntegers.add(1);
        listOfIntegers.add(5);
        listOfIntegers.add(-17);
        listOfIntegers.add(8);
        System.out.println(listOfIntegers.get(3));
        System.out.println();
        listOfIntegers.sort(Comparator.comparingInt(o -> o));
        listOfIntegers.forEach(System.out::println);

        System.out.println("\nQueue Collection:");
        dequeOfIntegers.add("Germany");
        dequeOfIntegers.addFirst("France");
        dequeOfIntegers.push("Great Britain");
        dequeOfIntegers.addLast("Spain");
        dequeOfIntegers.add("Italy");
        while (dequeOfIntegers.peek() != null) {
            System.out.println(dequeOfIntegers.pop());
        }

        System.out.println("\nLinkedList Collection");
        linkedListOfStrings.add("F");
        linkedListOfStrings.add("B");
        linkedListOfStrings.add("D");
        linkedListOfStrings.add("E");
        linkedListOfStrings.add("C");
        //linkedListOfStrings.addLast("Z");
        //linkedListOfStrings.addFirst("A");
        //linkedListOfStrings.add(1, "A2");
        System.out.println("Содержимое: " + linkedListOfStrings);


    }
}