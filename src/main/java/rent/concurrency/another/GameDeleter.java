package rent.concurrency.another;

public class GameDeleter extends Thread {

    private final Store store;

    public GameDeleter(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            Game game = store.getGame();
            System.out.println("Game to play and delete: " + game.getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}