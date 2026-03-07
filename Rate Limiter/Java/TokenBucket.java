class TokenBucket {

    private int capacity;
    private int refillRate;

    private int tokens;
    private long lastRefillTime;

    public TokenBucket(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;

        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public boolean tryConsume() {

        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }

        return false;
    }

    private void refill() {

        long now = System.currentTimeMillis();
        long secondsPassed = (now - lastRefillTime) / 1000;

        if (secondsPassed > 0) {

            int tokensToAdd = (int) (secondsPassed * refillRate);

            tokens = Math.min(capacity, tokens + tokensToAdd);

            lastRefillTime = now;
        }
    }
}