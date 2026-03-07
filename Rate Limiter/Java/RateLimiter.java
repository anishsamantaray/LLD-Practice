import java.util.HashMap;
import java.util.Map;

class RateLimiter {

    private final Map<String, TokenBucket> buckets = new HashMap<>();

    private final int capacity;
    private final int refillRate;

    public RateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean allowRequest(String clientId) {

        TokenBucket bucket = buckets.computeIfAbsent(clientId,id -> new TokenBucket(capacity, refillRate);

        return bucket.tryConsume();
    }
}