package com.wxmp.core.util;

import net.oschina.j2cache.*;

import java.io.IOException;

/**
 * @author hermit
 */
public class J2CacheUtil{

    private final static String CONFIG_FILE = "/j2cache/j2cache.properties";

    private final static J2CacheBuilder builder;

    static {
        try {
            J2CacheConfig config = J2CacheConfig.initFromConfig(CONFIG_FILE);
            builder = J2CacheBuilder.init(config);
        } catch (IOException e) {
            throw new CacheException("Failed to load j2cache configuration " + CONFIG_FILE, e);
        }
    }

    /**
     * 返回缓存操作接口
     * @return CacheChannel
     */
    public static CacheChannel getChannel(){
        return builder.getChannel();
    }

    /**
     * 关闭 J2Cache
     */
    public static void close() {
        builder.close();
    }
}
