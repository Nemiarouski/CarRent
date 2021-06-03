package rent.generics;

public class Container<T extends Product>{
    T item;

    public Container() {
    }
    public Container(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}