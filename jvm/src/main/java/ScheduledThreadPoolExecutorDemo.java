import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author iuuui
 * @date 2025/03/16 1109
 */
public class ScheduledThreadPoolExecutorDemo {

    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
            1,
            new MyThreadFactory(),
            new MyRejectedExecutionHandler());

    public static void main(String[] args) {
        executor.schedule(()-> {
            System.out.println("我是延迟后执行的");
        }, 5000, TimeUnit.MILLISECONDS);

        executor.submit(() -> {
            System.out.println("直接执行");
        });
        executor.shutdown();
    }

    static class MyThreadFactory implements ThreadFactory {

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
