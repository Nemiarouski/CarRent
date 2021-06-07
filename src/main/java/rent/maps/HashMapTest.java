package rent.maps;

import rent.menu.CustomDescription;
import rent.model.IntegerWrapper;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<IntegerWrapper, String> map = new HashMap<>();

        IntegerWrapper integerWrapper = new IntegerWrapper(5);
        IntegerWrapper integerWrapper1 = new IntegerWrapper(6, new CustomDescription("One", "Two"));
        IntegerWrapper integerWrapper2 = new IntegerWrapper(6, new CustomDescription("One", "Two"));

        map.put(integerWrapper, "IntegerWrapper without customDescription");
        map.put(integerWrapper1, "IntegerWrapper with customDescription");

        for (Map.Entry<IntegerWrapper, String> entry : map.entrySet()) {

            System.out.println(entry.getKey().getValue());
            if (entry.getKey().getCustomDescription() != null) {
                System.out.println(entry.getKey().getCustomDescription().getDescription());
                System.out.println(entry.getKey().getCustomDescription().getSecondDescription());
            }
        }
        System.out.println(map.get(integerWrapper2));
    }
}