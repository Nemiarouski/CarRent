package rent.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Worker> workers = new ArrayList<>();

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void deleteWorker(Worker worker) {
        workers.remove(worker);
    }

    public void createWork() {
        System.out.println("In our city work: ");
        for (Worker worker: workers) {
            worker.work();
        }
    }
}