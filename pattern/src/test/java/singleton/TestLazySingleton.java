package singleton;

import org.junit.jupiter.api.Test;
import singleton.lazy_singleton.LazySingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestLazySingleton
 * @Description 测试懒汉式单例
 * @Author hou
 * @Date 2020/4/20 12:57 下午
 * @Version 1.0
 **/
public class TestLazySingleton {

    /**
     * 使用单线程测试饿汉式单例
     */
    @Test
    public void testLazySingleton() {
        Map<LazySingleton, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            LazySingleton instance = LazySingleton.getInstance();
            map.merge(instance, 1, (o, n) -> o + 1);
        }
        map.forEach((k, v) -> System.out.println(String.format("object: %s, count: %s", k, v)));
    }

    /**
     * 多线程条件下测试懒汉式单例
     */
    @Test
    public void testConcurrentLazySingleton() throws InterruptedException {
        // 计数map
        Map<LazySingleton, Integer> map = new ConcurrentHashMap<>();
        // 线程数
        int threadNum = 10;
        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    LazySingleton instance = LazySingleton.getInstance();
                    map.merge(instance, 1, (o, n) -> o + 1);
                }

                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        map.forEach((k, v) -> System.out.println(String.format("object: %s, count: %s", k, v)));
    }

    /**
     * 多线程条件下测试懒汉式单例 - 调试版本
     */
    @Test
    public void testConcurrentLazySingleton2() throws InterruptedException {
        // 线程数
        int threadNum = 2;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + ": " + instance);

                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }

}