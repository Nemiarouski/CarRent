package rent.myList;

public class MyListMain {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(54);
        myList.add(45);
        myList.add(33);
        System.out.println(myList.contains(33));

        MyList<String> myList1 = new MyList<>();
        myList1.add("One");
        myList1.add("Two");
        myList1.add("Three");
        System.out.println(myList1.contains("Two"));
    }
}