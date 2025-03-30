import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author iuuui
 * @date 2025/03/16 1529
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 固定线程数量 线程池，线程永久存活 + 无界队列（LinkedBlockingQueue）
        Executors.newFixedThreadPool(1);
        //
        ExecutorService pool = Executors.newCachedThreadPool();
        // 固定线程数量 线程池，线程永久存活 + 无界队列（DelayedWorkQueue）
        Executors.newScheduledThreadPool(1);
        // 单个线程 线程池，线程永久存活 + 无界队列（LinkedBlockingQueue）
        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();
    }


    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void test() {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                countDownLatch.countDown();
                System.out.println("线程执行啦");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("结束啦");

        executor.shutdown();
    }
}
