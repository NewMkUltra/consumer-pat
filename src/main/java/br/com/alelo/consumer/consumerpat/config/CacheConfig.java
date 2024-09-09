package br.com.alelo.consumer.consumerpat.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public JCacheCacheManager cacheManager() {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();
        var cacheConfiguration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, String.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .heap(100, EntryUnit.ENTRIES))
                .withExpiry(org.ehcache.expiry.Expirations.timeToLiveExpiration(org.ehcache.expiry.Duration.of(10, java.util.concurrent.TimeUnit.MINUTES)))
                .build();
        cacheManager.createCache("consumers", Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfiguration));
        return new JCacheCacheManager(cacheManager);
    }
}