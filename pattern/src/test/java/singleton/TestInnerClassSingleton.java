package singleton;

import org.junit.jupiter.api.Test;
import singleton.inner_class_singleton.InnerClassSingleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestInnerClassSingleton
 * @Description 测试内部类单例模式
 * @Author hou
 * @Date 2020/4/20 4:17 下午
 * @Version 1.0
 **/
public class TestInnerClassSingleton {

    /**
     * 多线程条件下测试内部类单例
     */
    @Test
    public void testInnerClassSingleton() throws InterruptedException {
        // 计数map
        Map<InnerClassSingleton, Integer> map = new ConcurrentHashMap<>();
        // 线程数
        int threadNum = 10;
        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    InnerClassSingleton instance = InnerClassSingleton.getInstance();
                    map.merge(instance, 1, (o, n) -> o + 1);
                }

                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        map.forEach((k, v) -> System.out.println(String.format("object: %s, count: %s", k, v)));
    }

}