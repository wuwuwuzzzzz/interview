package com.example.interview.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wxz
 * @date 10:25 2022/12/26
 */
public class LruCacheDemo<K, V> extends LinkedHashMap<K, V> {

    /**
     * 缓存容量
     */
    private final int capacity;

    /**
     * @author wxz
     * @date 10:40 2022/12/26
     * accessOrder     the ordering mode - <tt>true</tt> for
     * access-order, <tt>false</tt> for insertion-order
     */
    public LruCacheDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * 当容量大于给定的缓存容量时删除最先put进集合的数据
     *
     * @return boolean
     * @author wxz
     * @date 10:41 2022/12/26
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    /**
     * 测试LRU算法
     *
     * @author wxz
     * @date 10:43 2022/12/26
     */
    public static void main(String[] args) {
        LruCacheDemo lruCacheDemo = new LruCacheDemo(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "e");
        System.out.println(lruCacheDemo.keySet());
    }
}
