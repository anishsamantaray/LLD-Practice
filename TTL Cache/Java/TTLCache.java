import java.util.HashMap;
import java.util.Map;

class TTLCache {

    private Map<String, CacheEntry> cache = new HashMap<>();

    public void put(String key, Object value, long ttlMillis) {

        CacheEntry entry = new CacheEntry(value, ttlMillis);
        cache.put(key, entry);
    }

    public Object get(String key) {

        CacheEntry entry = cache.get(key);

        if (entry == null)
            return null;

        if (entry.isExpired()) {
            cache.remove(key);
            return null;
        }

        return entry.value;
    }

    public void delete(String key) {
        cache.remove(key);
    }
}