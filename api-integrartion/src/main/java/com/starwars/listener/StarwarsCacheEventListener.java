package com.starwars.listener;

import lombok.extern.log4j.Log4j2;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * Cache event listener which listens for all type of
 * events and logs them for troubleshooting
 */
@Log4j2
public class StarwarsCacheEventListener implements CacheEventListener {

    @Override
    public void onEvent(CacheEvent cacheEvent) {
        log.info("Cache event {} triggered for key {}", cacheEvent.getType(), cacheEvent.getKey());
    }
}
