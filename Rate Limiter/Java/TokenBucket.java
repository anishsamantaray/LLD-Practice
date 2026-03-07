import java.util.concurrent.locks.ReentrantLock;

class TokenBucket {

    private final int capacity;
    private final int refillRate;

    private double tokens;
    private long lastRefillTime;

    private final ReentrantLock lock = new ReentrantLock();

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;

        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public boolean tryConsume() {

        lock.lock();

        try {

            refill();

            if (tokens >= 1) {
                tokens -= 1;
                return true;
            }

            return false;

        } finally {
            lock.unlock();
        }
    }

    private void refill() {

        long now = System.nanoTime();

        double tokensToAdd =
                (now - lastRefillTime) / 1e9 * refillRate;

        tokens = Math.min(capacity, tokens + tokensToAdd);

        lastRefillTime = now;
    }
}