package digito_unico.Service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CacheService {

    private final int MAX_ENTRIES = 10;
    private Map<String, Integer> cache = new LinkedHashMap<String, Integer>(MAX_ENTRIES + 1, .75F, true) {
      protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > MAX_ENTRIES;
      }
    };

    public Integer getFromCache(String key) {
      return cache.get(key);
    }

    public void addToCache(String key, Integer value) {
      cache.put(key, value);
    }
}
