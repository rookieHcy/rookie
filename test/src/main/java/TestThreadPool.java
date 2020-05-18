import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @ClassName testThreadPool
 * @Description TODO
 * @Author hou
 * @Date 2020/5/5 1:48 上午
 * @Version 1.0
 **/
public class TestThreadPool {

    @Test
    // 测试线程池中的线程销毁
    public void testThreadDestroy() throws InterruptedException {
        // 定义一个线程池 核心线程数1 最大线程数2
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i = 0; i < 1000000; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        }

        for(;;){
            int activeCount = threadPoolExecutor.getActiveCount();
            int poolSize = threadPoolExecutor.getPoolSize();
            System.out.println("activeCount: " + activeCount + "; poolSize: " + poolSize);
            if(activeCount == 2){
                threadPoolExecutor.shutdown();
            }
//            TimeUnit.SECONDS.sleep(10);
        }
    }


    /**
     * 测试线程池中调用的是线程的run方法还是start方法
     */
    @Test
    public void testTunOrStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new TestDemo());
        }
    } /*
        run
        run
        run
        run
        run
        run
        run
        run
        run
        run
    */

    class TestDemo extends Thread{
        @Override
        public synchronized void start() {
            System.out.println("start");
            super.start();
        }

        @Override
        public void run() {
            System.out.println("run");
            super.run();
        }
    }
}