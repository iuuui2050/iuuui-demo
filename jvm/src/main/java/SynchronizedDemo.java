import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author iuuui
 * @date 2025/03/15 1329
 */
public class SynchronizedDemo {

    Lock lock = new ReentrantLock();

    public void method() {
        lock.lock(); // 获取锁
        try {
            // 同步代码块
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public static void main(String[] args) {

    }

}
