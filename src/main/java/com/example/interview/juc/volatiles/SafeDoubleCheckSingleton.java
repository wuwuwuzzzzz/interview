package com.example.interview.juc.volatiles;

/**
 *
 * @author wxz
 * @date 10:36 2023/1/9
 */
public class SafeDoubleCheckSingleton {

    private static SafeDoubleCheckSingleton singleton;

    /**
     * 私有化构造方法
     * @author wxz
     * @date 10:39 2023/1/9
     */
    private SafeDoubleCheckSingleton() {}

    /**
     * 双重锁设计
     * @author wxz
     * @date 10:39 2023/1/9
     * @return com.example.interview.juc.volatiles.SafeDoubleCheckSingleton
     */
    public static SafeDoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (SafeDoubleCheckSingleton.class) {
                if (singleton == null) {
                    // 隐患: d多线程环境下，由于重排序，该对象可能还未完成初始化就被其他线程读取
                    singleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
