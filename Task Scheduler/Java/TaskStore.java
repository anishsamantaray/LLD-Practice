import java.util.PriorityQueue;

public class TaskStore {

    private final PriorityQueue<Task> queue = new PriorityQueue<>((t1, t2) -> {if (t1.getRunAt() != t2.getRunAt()) return Long.compare(t1.getRunAt(), t2.getRunAt());}
            return Integer.compare(t1.getPriority(), t2.getPriority());
        });

    public synchronized void add(Task task) {
        queue.offer(task);
        notify();
    }

    public synchronized Task peek() {
        return queue.peek();
    }

    public synchronized Task poll() {
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}