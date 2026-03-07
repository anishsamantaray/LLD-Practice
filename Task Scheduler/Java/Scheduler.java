import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    private final TaskStore store = new TaskStore();
    private final ExecutorService executor = Executors.newFixedThreadPool(3);
    private volatile boolean running = false;

    public void start() {
        running = true;

        Thread worker = new Thread(() -> {
            while (running) {
                try {
                    Task task;

                    synchronized (store) {

                        while (store.isEmpty()) {
                            store.wait();  // wait until a task is added
                        }

                        task = store.peek();

                        long delay = task.getRunAt() - System.currentTimeMillis();

                        if (delay > 0) {
                            store.wait(delay); // wait until it's time
                            continue;          // re-check queue
                        }

                        store.poll(); // remove task to execute
                    }

                    // execute outside synchronized block
                    executor.submit(task::execute);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        worker.start();
    }

    public void schedule(Task task) {
        synchronized (store) {
            store.add(task);
            store.notify(); // wake worker thread
        }
    }

    public void stop() {
        running = false;
        executor.shutdown();
    }
}