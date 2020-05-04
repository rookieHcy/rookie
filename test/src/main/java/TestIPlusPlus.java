import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestIPlusPlus
 * @Description 测试i++是否为原子操作
 * @Author hou
 * @Date 2020/4/20 9:56 上午
 * @Version 1.0
 **/
public class TestIPlusPlus {

    /**
     * 测试i++
     * @throws InterruptedException
     */
    @Test
    public void testIPlusPlus() throws InterruptedException {
        int threadNum = 10;
        // lambda内部访问 需要设置为final数组或者AtomicInteger
        final int[] count = {0};
        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    count[0]++;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(count[0]);
    }

    /**
     * 测试AtomicInteger
     * @throws InterruptedException
     */
    @Test
    public void testAtomicInteger() throws InterruptedException {
        int threadNum = 10;
        AtomicInteger count = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    count.incrementAndGet();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(count);
    }

    /**
     * 测试i++
     * @throws InterruptedException
     */
     volatile int count = 0;
    @Test
    public void testVolatileIPlusPlus() throws InterruptedException {
        int threadNum = 10;
        // lambda内部访问 需要设置为final数组或者AtomicInteger

        // 发令枪
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    count++;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(count);
    }

}