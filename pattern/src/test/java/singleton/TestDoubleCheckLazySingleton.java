package singleton;

import org.junit.jupiter.api.Test;
import singleton.lazy_singleton.DoubleCheckLazySingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestDoubleCheckLazySingleton
 * @Description TODO
 * @Author hou
 * @Date 2020/4/20 3:50 下午
 * @Version 1.0
 **/
public class TestDoubleCheckLazySingleton {

    /**
     * 多线程条件下测试懒汉式单例
     */
    @Test
    public void testDoubleCheckLazySingleton() throws InterruptedException {
        // 计数map
        Map<DoubleCheckLazySingleton, Integer> map = new ConcurrentHashMap<>();
        // 线程数
        int threadNum = 100;
        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    DoubleCheckLazySingleton instance = DoubleCheckLazySingleton.getInstance();
                    map.merge(instance, 1, (o, n) -> o + 1);
                }

                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        map.forEach((k, v) -> System.out.println(String.format("object: %s, count: %s", k, v)));
    }
}