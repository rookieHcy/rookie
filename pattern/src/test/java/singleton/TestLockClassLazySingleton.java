package singleton;

import org.junit.jupiter.api.Test;
import singleton.lazy_singleton.LockClassLazySingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestLockClassLazySingleton
 * @Description 测试锁类的懒汉式单例模式
 * @Author hou
 * @Date 2020/4/20 3:30 下午
 * @Version 1.0
 **/
public class TestLockClassLazySingleton {

    /**
     * 多线程条件下测试懒汉式单例
     */
    @Test
    public void testLockClassLazySingleton() throws InterruptedException {
        // 计数map
        Map<LockClassLazySingleton, Integer> map = new ConcurrentHashMap<>();
        // 线程数
        int threadNum = 10;
        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    LockClassLazySingleton instance = LockClassLazySingleton.getInstance();
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
    public void testLockClassLazySingleton2() throws InterruptedException {
        // 线程数
        int threadNum = 2;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                LockClassLazySingleton instance = LockClassLazySingleton.getInstance();
                System.out.println(instance);

                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }


}