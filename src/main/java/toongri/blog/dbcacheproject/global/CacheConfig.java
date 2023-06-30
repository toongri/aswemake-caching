package toongri.blog.dbcacheproject.global;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static toongri.blog.dbcacheproject.global.CacheType.GRADE;

@Configuration
public class CacheConfig implements CachingConfigurer {

    @Bean
    @Override
    public CacheManager cacheManager() {

        CustomCacheManager<CaffeineCache> caffeineCacheManager = new CustomCacheManager<>();

        caffeineCacheManager.add(new CaffeineCache(
                GRADE.getName(),
                Caffeine.newBuilder()
                        .recordStats()
                        .expireAfterWrite(GRADE.getExpireAfterWrite(), TimeUnit.MINUTES)
                        .initialCapacity(GRADE.getSize())
                        .maximumSize(GRADE.getSize())
                        .build()));

        return caffeineCacheManager.build();
    }

    @Bean
    public CacheManager alternateCacheManager() {
        return new ConcurrentMapCacheManager("grades2");
    }

}
