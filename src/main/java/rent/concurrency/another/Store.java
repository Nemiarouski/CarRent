package rent.concurrency.another;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    private final ConcurrentLinkedQueue<Game> games = new ConcurrentLinkedQueue<>();

    public synchronized void addGame(Game game) {
        games.add(game);
        notify();
    }

    public synchronized Game getGame() {
        while (games.size() < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Game game = games.poll();
        notify();
        return game;
    }
}