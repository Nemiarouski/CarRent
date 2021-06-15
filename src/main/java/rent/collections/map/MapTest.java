package rent.collections.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {
    private static Map<Key, String> treeMap = new TreeMap<>(new MapComparator());
    private static Map<Key, String> hashMap = new HashMap<>();
    private static Map<Key, String> linkedHashMap = new LinkedHashMap<>();

    public static void init(Map<Key, String> map) {
        map.put(new Key(1, "L"), "New");
        map.put(new Key(22, "P"), "Hello");
        map.put(new Key(1003, "T"), "VASIA");
        map.put(new Key(470, "B"), "A");
        map.put(new Key(0, "A"), "It's");
        map.put(new Key(-20, "F"), "Line");
    }

    public static void mapInit() {

        hashMap.keySet().stream()
                .sorted(Comparator.comparing(Key::getId))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    public static <K, V> void out(Map<K, V> map) {
        new ArrayList<>(map.keySet())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        init(hashMap);
        hashMap.keySet().stream().sorted(Comparator.comparing(Key::getId)).forEach(System.out::println);
        System.out.println();
        out(hashMap);
    }

    public static int compare(Key k1, Key k2) {
        return k1.getId().compareTo(k2.getId());
    }
}