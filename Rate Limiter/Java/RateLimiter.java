import java.util.HashMap;
import java.util.Map;

class RateLimiter {

    private Map<String, TokenBucket> buckets = new HashMap<>();
    private int capacity;
    private int refillRate;

    public RateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    public boolean allowRequest(String clientId) {

        if (!buckets.containsKey(clientId)) {
            buckets.put(clientId, new TokenBucket(capacity, refillRate));
        }

        TokenBucket bucket = buckets.get(clientId);

        return bucket.tryConsume();
    }
}