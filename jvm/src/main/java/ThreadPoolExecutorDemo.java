import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author iuuui
 * @date 2025/03/16 1109
 */
public class ThreadPoolExecutorDemo {

    private final static LinkedBlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>(1);

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,
            2,
            10,
            TimeUnit.MINUTES,
            QUEUE,
            new MyThreadFactory(),
            new MyRejectedExecutionHandler());

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int count = i +1;
            executor.submit(()-> {
                System.out.println("way? -->> "+count);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }



        executor.shutdown();
    }

    static class MyThreadFactory implements ThreadFactory{

        final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, String.format("线程名称：%s", ATOMIC_INTEGER.getAndIncrement()));
            t.setDaemon(false);
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.err.printf("被拒绝啦！！！！！！！！ %s%n", r.toString());
        }
    }

}
