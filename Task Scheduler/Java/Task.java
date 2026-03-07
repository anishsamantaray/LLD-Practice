public class Task {
    //so this instance variables can be accessed by this class only so its private
    //runnable is some code that can be executed and it can be passed as a parameter to the constructor and stored in the instance variable fn
    private final Runnable fn;
    private final long runAt;
    private final int priority;

    public Task(Runnable fn, long runAt, int priority) {
        this.fn = fn;
        this.runAt = runAt;
        this.priority = priority;
    }

    public void execute() {
        fn.run();
    }

    public long getRunAt() {
        return runAt;
    }

    public int getPriority() {
        return priority;
    }
}