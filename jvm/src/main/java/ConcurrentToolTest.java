import java.util.concurrent.*;

/**
 * @author iuuui
 * @date 2025/03/16 1808
 */
public class ConcurrentToolTest {


    public static void main(String[] args) {
//        cyclicBarrierDemo();
//        semaphoreDemo();
        countDownLatchDemo();
    }

    /**
     * 计数器
     */
    public static void countDownLatchDemo() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            try {
                final int count = i + 1;
                Thread.sleep(i * 1000);
                System.out.println("count is " + count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("等待结束啦");
    }

    /**
     * 类似于维护了一个队列，用于只有 2 个在执行，需要释放 1 个后，另外一个线程才能继续执行
     */
    public static void semaphoreDemo() {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 4; i++) {
            final int count = i + 1;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("加入：" + count);
                    Thread.sleep(count * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("释放：" + count);
                    semaphore.release();
                }
            }).start();
        }
    }

    /**
     * 构造函数 (int parties)、(int parties, Runnable barrierAction)
     * 当有 parties 个线程都调用了 await 进入阻塞时，唤醒全部线程继续执行
     */
    public static void cyclicBarrierDemo() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 4; i++) {
            final int count = i + 1;
            new Thread(() -> {
                try {
                    Thread.sleep(count * 1000);
                    System.out.println("获得第" + count + "颗龙珠了 start");
                    cyclicBarrier.await();
                    System.out.println("获得第" + count + "颗龙珠了 end");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

}
