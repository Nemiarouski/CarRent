package rent.concurrency.another;

public class Shop {
    public static void main(String[] args) {
        Store store = new Store();

        new GameCreating(store).start();

        new GameDeleter(store).start();
    }
}
