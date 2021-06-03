package rent.menu;

import rent.model.IntegerWrapper;
import java.util.ArrayList;
import java.util.List;

public class TestCase {
    public static void main(String[] args) {

        //Идет сравниение через equals который переопределил в IntegerWrapper
        IntegerWrapper integerWrapper1 = new IntegerWrapper(1);
        IntegerWrapper integerWrapper2 = new IntegerWrapper(2);
        IntegerWrapper integerWrapper3 = new IntegerWrapper(3);

        IntegerWrapper integerWrapper2again = new IntegerWrapper(1);

        List<IntegerWrapper> collection = new ArrayList<>();
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

        IntegerWrapper integerWrapper50 = new IntegerWrapper(5);
        IntegerWrapper integerWrapper51= new IntegerWrapper(6);

        if (integerWrapper50.equals(integerWrapper51)) {
            System.out.println("They are same.");
        }
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

