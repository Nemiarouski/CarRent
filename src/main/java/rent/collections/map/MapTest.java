package rent.collections.map;

import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    private static Map<Key, String> maps = new TreeMap<>();

    public static void mapInit() {
        maps.put(new Key(1, "L"), "New");
        maps.put(new Key(22, "P"), "Hello");
        maps.put(new Key(1003, "T"), "VASIA");
        maps.put(new Key(470, "B"), "A");
        maps.put(new Key(0, "A"), "It's");
        maps.put(new Key(-20, "F"), "Line");
    }

    public static void out() {
        System.out.println(maps.values());
    }

    public static void main(String[] args) {
        mapInit();
        out();
    }
}