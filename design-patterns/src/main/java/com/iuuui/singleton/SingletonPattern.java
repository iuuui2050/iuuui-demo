package com.iuuui.singleton;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author iuuui
 * @date 2025/03/25 2352
 */
public class SingletonPattern {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        CountDownLatch countDownLatch = new CountDownLatch(50);
        List<Singleton> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    Singleton instance = Singleton.getInstance();
                    list.add(instance);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        fixedThreadPool.shutdown();
        list.forEach(obj -> System.out.println(obj.hashCode()));
    }

}
