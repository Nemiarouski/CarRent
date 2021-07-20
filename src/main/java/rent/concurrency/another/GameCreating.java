package rent.concurrency.another;

public class GameCreating extends Thread {
    private final Store store;

    public GameCreating(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                store.addGame(new Game("Game " + i));
                System.out.println("Create a game with name: " + i);
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}