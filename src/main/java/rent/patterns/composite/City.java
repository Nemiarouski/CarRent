package rent.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class City implements Worker {
    private List<Worker> workers = new ArrayList<>();

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void deleteWorker(Worker worker) {
        workers.remove(worker);
    }

    @Override
    public void work() {
        for (Worker worker : workers) {
            worker.work();
        }
    }
}