package rent.menu;

import rent.model.IntegerWrapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestCase {
    public static void main(String[] args) {

        //Идет сравниение через equals который переопределил в IntegerWrapper
        IntegerWrapper integerWrapper1 = new IntegerWrapper(1);
        IntegerWrapper integerWrapper2 = new IntegerWrapper(2);
        IntegerWrapper integerWrapper3 = new IntegerWrapper(3);

        IntegerWrapper integerWrapper2again = new IntegerWrapper(1);

        Set<IntegerWrapper> collection = new HashSet<>();
        collection.add(integerWrapper1);
        collection.add(integerWrapper2);
        collection.add(integerWrapper3);

        if (collection.contains(integerWrapper2again)) {
            System.out.println("I found the wrapper!!!");
        }

        //Мой contains
        //contains(collection, integerWrapper2again);


        // Возьмет реализацию наследников, просто хранить будет в ссылке типа родителя.
/*      Object object = new IntegerWrapper(555);
        object.equals(...);

        IntegerWrapper integerWrapper = new IntegerWrapper(555);
        integerWrapper.equals(...);*/


        CustomDescription customDescription = new CustomDescription("One", "Two");
        CustomDescription customDescription1 = new CustomDescription("One", "Two");

        IntegerWrapper integerWrapper35 = new IntegerWrapper(1, customDescription);
        IntegerWrapper integerWrapper36 = new IntegerWrapper(1, customDescription1);

        if (integerWrapper35.equals(integerWrapper36)) {
            System.out.println("They are same.");
        }


        CustomDescription customDescription2 = new CustomDescription("One", "Two");

        IntegerWrapper integerWrapper50 = new IntegerWrapper(5);
        IntegerWrapper integerWrapper51= new IntegerWrapper(5, customDescription2);

        if (integerWrapper50.equals(integerWrapper51)) {
            System.out.println("They are same.");
        }

        int i = 10;
        String message = (i > 20) ? "Greater than 20" : "Less or equal than 20";
        System.out.println(message);



        System.out.println("isEqual: " + isEqual(null, new CustomDescription("", "")));
    }

    private static boolean isEqual(CustomDescription a, CustomDescription b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
        /*if (a == null) {
            return b == null;
        } else {
            return a.equals(b);
        }*/
    }

/*    static void contains(List<IntegerWrapper> list, Object integerWrapper) {
        for (IntegerWrapper iw : list) {
            if (iw.equals(integerWrapper)) {
                System.out.println("Same elements.");
            } else {
                System.out.println("No one same elements.");
            }
        }
    }*/
}

