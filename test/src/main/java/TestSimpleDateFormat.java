import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TestSimpleDateFormat
 * @Description TODO
 * @Author hou
 * @Date 2020/4/29 4:45 下午
 * @Version 1.0
 **/
public class TestSimpleDateFormat {
    /**
     * 测试SimpleDateFormat的线程不安全
     */
    @Test
    public void testSimpleDateFormat() {
        int threadNum = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        Random random = new Random();

        // 随机一些时间戳和格式化后的日期
        int arrSize = 100;
        long[] longs = new long[arrSize];
        String[] strings = new String[arrSize];

        for (int i = 0; i < arrSize; i++) {
            long abs = Math.abs(random.nextLong() % 4102415999L);
            longs[i] = abs;
            strings[i] = sdf.format(new Date(abs));
        }

        for (; ; ) {
            try {
                pool.execute(() -> {
                    int i = random.nextInt(arrSize);
                    String format = sdf.format(new Date(longs[i]));
                    if (!format.equals(strings[i])) {
                        System.out.println(String.format("timestamp is %d, expect: %s, actual: %s", longs[i], strings[i], format));
                        System.exit(1);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

    }
}