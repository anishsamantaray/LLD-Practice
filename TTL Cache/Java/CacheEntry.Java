class CacheEntry {

    Object value;
    long expiryTime;

    public CacheEntry(Object value, long ttlMillis) {
        this.value = value;
        this.expiryTime = System.currentTimeMillis() + ttlMillis;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}