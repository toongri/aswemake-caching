package toongri.blog.dbcacheproject.global;

import lombok.NoArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.cache.support.SimpleCacheManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
class CustomCacheManager<T extends Cache> {
    private final List<T> caches;

    public CustomCacheManager() {
        this.caches = new ArrayList<>();
    }

    public void add(T cache) {
        caches.add(cache);
    }

    public SimpleCacheManager build() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
